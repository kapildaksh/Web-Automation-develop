# Steps to run the Web-Automation script


1. Install JDK (e.g. See http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) -- run javac -version to check the installation
2. Install Maven (e.g. See https://maven.apache.org/install.html) -- run mvn -v to check the installation
3. Clone the repository from GitHub https://github.com/Prenetics/Web-Automation  Run mvn test to run tests
4. Run sh swagger.sh
5. Run **mvn clean test -Dbrowser=CH -Dexecution=LOCAL to run tests**

      If we want to run the scripts on firefox browser then use -Dbrowser =FF similarly for IE browser user -Dbrowser=IE but make sure internet explorer would run on window machine.

To run the script in continuous integration we need to pass **-Dexecution=remote** 


## How to create a new Automation script


1. Firstly we have to create a gherkins feature file with the filename.feature extension for the test scenario, If we already had feature file created for the functionality for which we want to add scenario then existing feature should be utilized by just adding testing scenario in it. 

Folder to create a feature and look for a feature file: ${Base.dir}src/test/resources/feature  Please follow the link to see how to write cucumber gherkins test scenario: http://docs.behat.org/en/v2.5/guides/1.gherkin.html  
 
2. The second step would be, create a class file for the web page we want to write the test scenario in src/main/java/com/prenetics/pagefactory/cirlce under respective product folder If page class file is already created then the existing class file should be utilized. Now find all the web element would be required to perform the action and create methods to perform the operation on the web elements. Also class has to be initialized with web driver using PageFactory.initElements() by calling the class parameterized constructor 


### To run remotely on docker images

1. Install and run  docker image of selenium selenium/hub on ubuntu docker image

2. register the docker on the port 4446 

3. Grid URL:  http://localhost:4446/wd/hub which is an ubuntu docker image

4. Install docker: **docker pull selenium/node-chrome-debug**

5. Run and register docker hub on port 4446: **docker run -d -p 4446:4444 --name selenium-hub -P selenium/hub**

6. Now  linking selenium-node-debug docker image to hub: **docker run -d -P --link selenium-hub:hub selenium/node-chrome-   debug**

To run remotely we need to pass command at run time **clean test -Dbrowser=CH -Dexecution=REMOTE -DisHeadless=true**

### You can run the specific scenarios with the help of Cucumber tags

To use the cucumber tags first you need add the tags in CucumberTestRunnerFile at src/test/java/com/prenetics/testscript/CucumberTestRunner.java 

**tags ={"@tagName"}**

You can add any number of tags by separating them with "," 
Ex: **tags={"@firstTag","@secondTag","@thirdTag"}**

Tag name should the same as provided in the scenarios 

To run specific scenario use the tag name in command line 

Ex **-Dcucumber.options="--tags @tagName"**
