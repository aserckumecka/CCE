# CCE
Cloud Correlation Engine (under construction...)

CCE is a Cloud-based SIEM Correlation Engine that processes and correlates events using a stateless FaaS model while retaining the architecture of traditional SIEMs. CCE’s design comprises three main stages:
Modelling - Transforming the stateful SIEM correlation engine into a stateless design for serverless functions. 
Automation - Translating textual rules into executable serverless functions. 
Optimization - Optimizing function grouping, execution, and hardware configuration for cost-efficiency.
CCE is the first cloud-based SIEM correlation engine capable of generating code for filter and correlation rules, deploying them as FaaS; processing events and generating alerts; and correlating alerts over time to produce alarms.


Requirements to test CCE:

* AWS account and IAM credentials
* User with permissions policies: AmazonDynamoDBFullAccess, AWSLambdaFullAccess, AmazonS3FullAccess.
* S3 bucket (to store deployed lambdas)
* AWS-CLI (https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
* AWS SAM CLI (https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)
* Maven (https://maven.apache.org/install.html)
* Java 11 (Newer versions are also supported by AWS Lambda, such as 17 or 21, but need to be tested with CCE)

After the requirements have been installed, open a terminal and set your credentials (aws_access_key_id and aws_access_key_id) using "aws configure". Confirm they are placed in ~/.aws/credentials file (Ubuntu path example).

After downloading the code, you need to change some parameters at:
* ../CCE/CCE_code/engine/src/main/java/cce/ruleupload/Bins_DeployCode.java, change "cce-bucket" with the bucket name you created to store the deployed lambdas.

Also, change the bucket name at:
* ../CCE/CCE_code/statefull-lambda-archetype/target/classes/archetype-resources/pom.xml
* ../CCE/CCE_code/statefull-lambda-archetype/src/main/resources/archetype-resources/pom.xml
* ../CCE/CCE_code/stateless-lambda-archetype/target/classes/archetype-resources/pom.xml
* ../CCE/CCE_code/stateless-lambda-archetype/src/main/resources/archetype-resources/pom.xml

Set your AWS account ID at:
* ../CCE/CCE_code/statefull-lambda-archetype/target/classes/archetype-resources/template.yaml
* ../CCE/CCE_code/statefull-lambda-archetype/src/main/resources/archetype-resources/template.yaml
* ../CCE/CCE_code/stateless-lambda-archetype/target/classes/archetype-resources/template.yaml
* ../CCE/CCE_code/stateless-lambda-archetype/src/main/resources/archetype-resources/template.yaml

Following, access the folder ../CCE/CCE_code/statefull-lambda-archetype and type "mvn clean install". Do the same for stateless-lambda-archetype. It will delete an old version (if exists) and compile and test the code.

At the "engine" directory you can find the CCE.java, the main class.

At the same folder, you will find the CCE.conf, used to set: how long you want to test CCE (in millis); the Lambda hardware Level (the default value is 1024, the best cost-bennefit, as explained in our paper - published in SRDS-2025); and the Response Time Limit (RTL), which sets the intervals (approx.) the user should wait untill triggering new lambdas (Detection and Correlation).

The devices data are located at "../engine/devices/". The config folder contains a yml file per device, which sets the main data and parameters used by CCE.
The folders "eps" and "ins" are used to collect processing data and recalculate the main parameters of regression analysis for each device.

The folder rule_template_code stores the last generated and deployed code for lambdas. Each lambda code contains the instructions of devices grouped by CCE Bin Packing algorithm (Detection Rules) and the code for Correlation Rules.

The folder "rules_yml" contains all the rules CCE will use for processing events.

