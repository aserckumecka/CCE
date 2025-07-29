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
* An IAM Role named LambdaFullAccess (arn:aws:iam::<your_account_id>:role/LambdaFullAccess), including the policy names [AmazonDynamoDBFullAccess, AWSLambda_FullAccess, CloudWatchLogsFullAccess].
* S3 bucket (to store deployed lambdas)
* AWS-CLI (https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
* AWS SAM CLI (https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)
* Maven (https://maven.apache.org/install.html)
* Java 11 (Newer versions are also supported by AWS Lambda, such as 17 or 21, but need to be tested with CCE)

After the requirements have been installed, open a terminal and set your credentials (aws_access_key_id and aws_access_key_id) using "aws configure". Confirm they are placed in ~/.aws/credentials file (Ubuntu path example).



At the "engine" directory you can find the CCE.java, the main class.

At the same folder, you will find the CCE.conf, used to set: how long you want to test CCE (in millis); the Lambda hardware Level (the default value is 1024, the best cost-bennefit, as explained in our paper - published in SRDS-2025); and the Response Time Limit (RTL), which sets the intervals (approx.) the user should wait untill triggering new lambdas (Detection and Correlation).

The devices data are located at "../engine/devices/". The config folder contains a yml file per device, which sets the main data and parameters used by CCE.
The folders "eps" and "ins" are used to collect processing data and recalculate the main parameters of regression analysis for each device.

The folder rule_template_code stores the last generated and deployed code for lambdas. Each lambda code contains the instructions of devices grouped by CCE Bin Packing algorithm (Detection Rules) and the code for Correlation Rules.

The folder "rules_yml" contains all the rules CCE will use for processing events.

