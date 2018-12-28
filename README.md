## Getting Started
The following instructions will get you a copy of Project Name up and running on your local machine.
### Prerequisites
* [NodeJS](https://nodejs.org/en/) (version 10.15+) _npm is installed with Node.js
npm is distributed with Node.js- which means that when you download Node.js, you automatically get npm installed on your computer._
* [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (version 8, may require an update to your system environment variables)
* Your favorite IDE!
    * For the Java and Spring development I use [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)
    * And the Angular/Typescript development I use [VSCode](https://code.visualstudio.com/download)
* [Git] (https://git-scm.com/downloads)
* [Google Chrome](https://www.google.com/chrome/)
### Setting up Local Environment
1. Set up a directory/file on your computer for pulling down this repository.
2. Open the `Group2/client` directory and run the following command ```npm install```. This command will install the third party libraries in a folder called `node_modules`, which allows `Node` to find these libraries easily at runtime.
3. Once the third parties have been installed the frontend portion of the project should be good to go. Go ahead and run ```npm start``` Finally open Chrome browser at `localhost:4200`.
4. If your still reading, open Chrome's Developer Tools and click on the console tab. You will notice a failed HTTP request!
5. I will use [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) as the example for setting up the backend. 
    * Select `Import Project`
    * Navigate to the `Group2/` directory and select the `server` folder for the project to be imported.
    * The next dialogue window we will select the radio button `import project from external model`.
    * Select `Maven` We use a maven wrapper so no need to install it :)
    * Click `Next` ~3 times (stop when you need to select the SDK)
    * Remember we used jdk1.8 for this project!
        * Insert Image  HERE
        * Click `Next`
    * Click `Finish`
* Once the project is imported into your favorite IDE run the following command in the `Group2/server` ```./mvnw spring-boot:run```
* CONGRATULATIONS you have successfully started the backend!
* Now refresh your Chrome tab and check the Developer Tools once more and you should see a successful HTTP POST and a GET request!
