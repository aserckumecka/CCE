# CCE
Cloud Correlation Engine

CCE is a Cloud-based SIEM Correlation Engine that processes and correlates events using a stateless FaaS model while retaining the architecture of traditional SIEMs. CCE’s design comprises three main stages:
Modelling - Transforming the stateful SIEM correlation engine into a stateless design for serverless functions. 
Automation - Translating textual rules into executable serverless functions. 
Optimization - Optimizing function grouping, execution, and hardware configuration for cost-efficiency.
CCE is the first cloud-based SIEM correlation engine capable of generating code for filter and correlation rules, deploying them as FaaS; processing events and generating alerts; and correlating alerts over time to produce alarms.
This is a prototype, under construction. More details are described in our paper, published in SRDS-2025.

Requirements to test CCE:

* AWS account and IAM credentials
* User with permissions policies: AmazonDynamoDBFullAccess, AWSLambdaFullAccess, AmazonS3FullAccess.
* An IAM Role named LambdaFullAccess (arn:aws:iam::<your_account_id>:role/LambdaFullAccess), including the policy names [AmazonDynamoDBFullAccess, AWSLambda_FullAccess, CloudWatchLogsFullAccess].
* S3 bucket (to store deployed lambdas)
* AWS-CLI (https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
* AWS SAM CLI (https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)
* Maven (https://maven.apache.org/install.html)
* Java 11 (Newer versions are also supported by AWS Lambda, such as 17 or 21, but need to be tested with CCE)

Configuring CCE:

After the requirements have been installed, open a terminal and set your credentials (aws_access_key_id and aws_access_key_id) using "aws configure" command. It will be placed at "~/.aws/credentials" file (Ubuntu path example).

After cloning the code, in "CCE-engine" folder, you will find the "CCE.conf" file, with the main parameters used by CCE.
The parameters you must change before running are the S3 bucket (you create before), the AWS region you want to use, and your AWS account ID. Others are optional and used to set how long you want to run CCE (in millis); the Lambda hardware Level (the default value is 1024, the best cost-bennefit in our tests); and the Response Time Limit (RTL), which sets the interval that the user will tolerate wait (aprox.) to get the events processed.

The devices' data are located at "../CCE-engine/devices/". The config folder contains a "yml" file per device, which sets their most important parameters, used by CCE.
The folders "eps" and "ins" are used to collect processing data and recalculate the parameters of regression analysis for each device, estimating their processing cost.

The folder rule_template_code stores the last generated and deployed code for lambdas. Each lambda code contains the instructions of devices grouped by CCE Bin Packing algorithm (Detection Rules) and the code for Correlation Rules.

The folder "rules_yml" contain all the rules CCE will use for processing events.

The "events" folder holds the generated events for each lambda, according to the devices in each one.
For practical reasons, CCE is configured to process events created by our event generator (DataProducer).

Running CCE:

You can compile CCE code using maven (e.g. typing "mvn clean compile assembly:single" at the CCE-engine directory).
To run just execute the jar file placed at target/ folder.

Beyond the informations shown at the terminal, you can see more data accessing the CloudWatch Log Groups, as well as the DynamoDB tables, containing the alerts and alarms created.

As mentioned before, this is the first version (under construction) and any feedback is very welcome!
