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

* Maven (https://maven.apache.org/install.html)

* Java 11 (used, newer options 17 or 21 need to be tested -- both versions are supported by AWS Lambda)


After the requirements have been installed, confirm if your credentials (aws_access_key_id and aws_access_key_id) are placed in ~/.aws/credentials file (Ubuntu path example).

After downloading the code, you need to access the folder <path_to_CCE_project>/CCE_code/statefull-lambda-archetype and type mvn clean install. Do the same for stateless-lambda-archetype. It will delete an old version (if exists) and compile and test the code.

The CCE code is found at "engine" folder, where you can compile the project (/CCE.java is the main class).

At the same folder, you will find the CCE.conf, used to set how long you want to test CCE (in millis); the Lambda hardware Level (the default value is 1024, the best cost-bennefit, as explained in our paper - published in SRDS-2025); and the Response Time Limit (RTL), which sets the intervals (approx.) the user should wait untill triggering new lambdas (Detection and Correlation).

The devices data are located at "../engine/devices/". The config folder contains a yml file per device, which sets the main data and parameters used by CCE.
The folders "eps" and "ins" are used to collect processing data and recalculate the main parameters of each device.

The folder rule_template_code stores the last generated and deployed code for lambdas. Each lambda code contains the instructions of devices grouped by CCE Bin Packing algorithm (Detection Rules) and the code for Correlation Rules.

The folder "rules_yml" contains all the rules CCE will use for processing events.

