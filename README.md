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

* S3 bucket, named "cce-bucket" (to store deployed lambdas)

* AWS-CLI (https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)

* Maven (https://maven.apache.org/install.html)

* Java 11 (used, 17 or 21 need to be tested -- versions supported by AWS Lambda)


After the requirements have been installed, confirm your credentials (aws_access_key_id and aws_access_key_id) are set in ~/.aws/credentials text file (Ubuntu path example).

After downloading the code, you need to access the folder <path_to_CCE_project>/CCE_code/statefull-lambda-archetype and type mvn clean install. Do the same for stateless-lambda-archetype. It will compile the code and test the code.
