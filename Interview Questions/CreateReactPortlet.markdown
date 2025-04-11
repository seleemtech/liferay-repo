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
   npm install -g generator-liferay-js

5. Run the generator with the command below, and it will create a normal JavaScript React component.

   ```bash
   yo liferay-js

   ? What type of project do you want to create? React Widget
   ? What name shall I give to the folder hosting your project? sample-react-portlet
   ? What is the human readable description of your project? Sample React Portlet
   ? Do you want to add localization support? Yes
   ? Do you want to add configuration support?

   💡 Needs Liferay DXP/Portal CE 7.1 with JS Portlet Extender 1.1.0 or
     Liferay DXP/Portal CE 7.2+.

   Yes
   ? Under which category should your widget be listed? category.sample
   ? Do you have a local installation of Liferay for development? Yes
   ? Where is your local installation of Liferay placed?
   D:\Liferay-servers\liferay-ce-portal-tomcat-7.4.3.106-ga106-20231207073813307\liferay-ce-portal-7.4.3.106-ga106
   ? Do you want to generate sample code? Yes
   create package.json
   create README.md
   create .gitignore
   create .npmbuildrc
   create .npmbundlerrc
   create .npmignore
   create assets\.placeholder
   create features\localization\Language.properties
   create features\configuration.json
   create assets\css\styles.css
   create .babelrc
   create src\index.js
   create src\AppComponent.js


   I'm all done. Running npm install for you to install the required dependencies. If this fails, try running the command yourself.

6. Creating a TypeScript React component.

   ```bash
   npx create-react-app <portlet_name> --template typescript

7. After Creating react project, we are going to adapt it to a Liferay project style using it.

   ```bash
   cd <portlet_name> && yo liferay-js:adapt

The adaptation process will start and you’ll be asked about some changes that Yo will do.


