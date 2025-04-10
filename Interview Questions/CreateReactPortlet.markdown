# Deploying React Fragments Using Site Initializer [](id=deploying-react-fragments-using-site-initializer-guide)

This module is used to deploy react fragments using Extender API's `(Site Initializer)`.

1. Create Package as per below structure.

   ![React Fragments Folder Structure](../../Images/react-fragments-folder-structure.png)

2. Add below script in `package.json` file.
   
   ```json
   {
   "name": "stealth-kart-classic-fragements",
   "description": "Liferay Fragments project",
   "version": "1.0.0",
   "scripts": {
   "build": "yo liferay-fragments:build"
   },
   "dependencies": {
   "react": "16.12.0",
   "react-dom": "16.12.0",
   "yo": "4.3.1"
   },
   "devDependencies": {
   "css-loader": "^5.0.0",
   "generator-liferay-fragments": "2.0.2",
   "sass-loader": "^13.3.2",
   "style-loader": "^2.0.0"
   }
   }

   ```
3. Add below script in `build.gradle`

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

4. Run Gradle Build
5. `.jar` file will be generated in `project dir -> build -> lib` folder.
