# Cron Expression Parser
Cron Expression Parser to parse standard cron expressions.

## Requirements to run this Project:
* Java 8 or higher run time setup in host OS env
* Gradle 8 configured in the env

## Supported CRON Format:
![image](https://github.com/dhaval-panjwani/cron-expression-parser/assets/16946179/ceeaf227-3496-4027-b3ad-b3a15ab160a8)


## How to Run this CRON Parser ?
* Please make sure Java 8 or higher & Gradle 8 is setup on the host OS env
* Clone this repo into your local
* Go to root project folder for the above project in /CronExpParser
* Run this command in root directory of project "./gradlew jar". This would compile and create a runnable java jar for our use in "CronExpParser\build\libs" folder with name "cron-parser-0.1.0.jar"
* We can run this jar with this command -  `java -jar cron-parser-0.1.0.jar "*/15 0 1,15 * 1-5 /usr/bin/find"` `java -jar cron-parser-0.1.0.jar "<cron expression>"`


## To Do's:
* Can be augmented to handle less than 31 days months
* Can improve test coverage to make it exhaustive
* Can be augmented to handle @yearly type special expressions 
* Enhanced validation capabilities on Cron expression


## Some CLI examples below for reference:

* `java -jar cron-parser-0.1.0.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`
* `java -jar cron-parser-0.1.0.jar "*/30 0 1,15 * 1-5 grep hello.txt | wc -l"`
