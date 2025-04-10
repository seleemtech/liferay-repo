# Creating React Portlet In Liferay [](id=creating-react-portlet-in-liferay)

Follow these steps to create your React widget.

1. Install `NVM` using below link.

   https://github.com/coreybutler/nvm-windows/releases

2. Install Node.js using NVM.
   
   **Before that, please refer to the link below to check which Node.js version is compatible with the Liferay version you are installing.**

   https://learn.liferay.com/w/dxp/liferay-development/tooling/reference/node-version-information
   
   ```bash
   nvm install v16.13.0

3. Install Yeoman for the generator.

   ```bash
   npm i yo@4.3.1

4. Install the Liferay JS Generator.
   
   ```bash
   npm i yo@4.3.1

5. Run the generator with the command below, select the JavaScript widget you want to create, and answer the prompts that follow.

   

   

7. Add below script in `build.gradle`

   ```groovy
   import com.liferay.gradle.util.OSDetector
   import com.liferay.gradle.util.StringUtil
   
   import java.text.DateFormat
   import java.text.SimpleDateFormat
   
   import java.util.Date
   import java.util.TimeZone
   
   import org.gradle.util.GUtil
   
   apply plugin: "com.liferay.node"
   
   configurations {
   extraRemoteApp
   }
   
   task buildExtraRemoteApp
   task forceDeploy
   task zipExtraRemoteApp(type: Zip)
   
   String extraRemoteAppName = "com.stealtKart.default.site.initializer.Classic.extra.remote.app"
   String extraRemoteAppVersion = "20230801.1154"
   
   DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd.HHmm")
   
   dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"))
   
   String dateString = dateFormat.format(new Date())
   
   File extraRemoteAppDir = new File(projectDir, "extra/remote-app/")
   File fragmentsSrcDir = new File(projectDir, "src/main/resources/site-initializer/fragments/group")
   
   String webContextPath = ""

   if (GUtil.loadProperties(file("bnd.bnd"))["Web-ContextPath"] != null) {
   webContextPath = GUtil.loadProperties(file("bnd.bnd"))["Web-ContextPath"]
   
       webContextPath = webContextPath.replaceAll("\\s+", "-").toLowerCase()
   
       if (webContextPath.startsWith("/")) {
           webContextPath = webContextPath.substring(1)
       }
   }
   
   artifacts {
   extraRemoteApp zipExtraRemoteApp
   }
   
   dependencies {
   extraRemoteApp ext: "zip", group: "com.liferay", name: extraRemoteAppName, version: extraRemoteAppVersion
   }
   
   forceDeploy {
   finalizedBy deploy
   }
   
   node {
   global = false
   nodeVersion = "16.15.1"
   useNpm = false
   yarnVersion = "1.22.5"
   }
   
   processResources {
   doLast {
   copy {
   from new File(projectDir, "src/main/resources/site-initializer/thumbnail.png")
   into new File(projectDir, "classes/META-INF/resources")
   }
   }

    ResolvedConfiguration resolvedConfiguration = configurations.extraRemoteApp.getResolvedConfiguration()

    if (gradle.startParameter.taskNames.contains("forceDeploy") || gradle.startParameter.taskNames.contains("uploadExtraRemoteApp") || resolvedConfiguration.hasError()) {
        dependsOn buildExtraRemoteApp


        File packageJSONFile = new File(fragmentsSrcDir, "package.json")

        if (packageJSONFile.exists()) {
            exclude "site-initializer/fragments/**"
   
   /*To add / copy main build folder from fragment's build folder */
    /*<-----START---->*/
            doLast {
                copy {
                    from new File(fragmentsSrcDir, "build/liferay-fragments/src")
                    into new File(projectDir, "build/resources/main/site-initializer/fragments/group")
                }
    /*<-----END---->*/
   
        }
   
    }
    else {
        File packageJSONFile = new File(fragmentsSrcDir, "package.json")

        if (packageJSONFile.exists()) {
            exclude "site-initializer/fragments/**"

            doLast {
                copy {
                    from zipTree(configurations.extraRemoteApp.singleFile)
                    include "fragments/**"
                    into new File(projectDir, "classes/site-initializer")
                }
            }
        }
    }
   }

   uploadExtraRemoteApp {
   doLast {
   File buildGradleFile = file("build.gradle")

        String content = buildGradleFile.getText("UTF-8")

        content = content.replaceFirst(~/String extraRemoteAppVersion = "(\w+\.\w+)"/) {
            String all, String versionString ->

                all.replace versionString, dateString
        }

        buildGradleFile.setText content, "UTF-8"
    }


   }

   zipExtraRemoteApp {
   if (!System.getenv("JENKINS_HOME")) {
   dependsOn buildExtraRemoteApp

        archiveName "extra-remote-app.zip"
        destinationDir new File(buildDir, "dist")

        File packageJSONFile = new File(fragmentsSrcDir, "package.json")

        if (packageJSONFile.exists()) {
            into("fragments/group/src") {
                from(new File(fragmentsSrcDir, "build/liferay-fragments/src"))
            }
        }
    }
   }

   _createExtraTasks([ fragmentsSrcDir])
   
   private String _camelCase(String dirName) {
   String suffix = dirName.replaceAll(/\-(\w)/) {
   String s = it[1]

        s.toUpperCase()
    }

    return StringUtil.capitalize(suffix)
   }

   private void _createExtraTasks(List<File> dirs) {
   dirs.each {
   File dir ->

            File packageJSONFile = new File(dir, "package.json")

            if (!packageJSONFile.exists()) {
                return
            }

            Task yarnInstallTask = tasks.create(name: "yarnInstall" + _camelCase(dir.name), type: Exec) {
                if (OSDetector.windows) {
                    executable "cmd.exe"

                    args "/c"
                    args new File(node.nodeDir, "node.exe")
                    args new File(node.nodeDir, "node_modules/yarn/yarn-" + node.yarnVersion + ".js")
                }
                else {
                    executable new File(node.nodeDir, "bin/node")

                    args new File(node.nodeDir, "lib/node_modules/yarn/yarn-" + node.yarnVersion + ".js")
                }

                args "install"
                dependsOn downloadNode
                workingDir dir
            }

            Task yarnBuildTask = tasks.create(name: "yarnBuild" + _camelCase(dir.name), type: Exec) {
                if (OSDetector.windows) {
                    executable "cmd.exe"

                    args "/c"
                    args new File(node.nodeDir, "node.exe")
                    args new File(node.nodeDir, "node_modules/yarn/yarn-" + node.yarnVersion + ".js")
                }
                else {
                    executable new File(node.nodeDir, "bin/node")

                    args new File(node.nodeDir, "lib/node_modules/yarn/yarn-" + node.yarnVersion + ".js")
                }

                args "build"
                dependsOn yarnInstallTask
                workingDir dir
            }

            buildExtraRemoteApp.dependsOn yarnBuildTask
    }
   }
   ```

8. Run Gradle Build
9. `.jar` file will be generated in `project dir -> build -> lib` folder.
