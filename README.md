# **☁️ CCE: Cloud Correlation Engine**

**A Cloud-based SIEM Correlation Engine using a stateless FaaS model.**  
CCE reimagines traditional SIEM architecture by processing and correlating events through serverless functions, offering a modern, scalable, and cost-efficient approach to security event management.

### **Key Design Stages**

CCE's design is built upon three foundational stages:

1. **📐 Modelling**  
   * Transforming the stateful SIEM correlation engine into a stateless design perfectly suited for serverless functions (FaaS).  
2. **⚙️ Automation**  
   * Automatically translating textual security rules into executable, deployable serverless functions.  
3. **💡 Optimization**  
   * Efficiently optimizing function grouping, execution parameters, and hardware configuration to ensure maximum cost-efficiency.

### 

### **Core Capabilities**

CCE is a cloud-based SIEM correlation engine capable of:

* ✅ Generating code for filter and correlation rules.  
* ✅ Deploying these rules dynamically as FaaS.  
* ✅ Processing events and generating alerts.  
* ✅ Correlating alerts over time to produce high-level alarms.

**Note:** This is an early-stage prototype and is currently under active construction. More technical details are described in our paper, to be published in **SRDS-2025**.

## 

## **🚀 Getting Started**

### **Prerequisites**

Before you begin, ensure you have the following installed and configured:

* **AWS Account & IAM Credentials**  
  * You'll need an IAM User with the following policies attached:  
    * AmazonDynamoDBFullAccess  
    * AWSLambda\_FullAccess  
    * AmazonS3FullAccess  
  * You must also have an IAM Role named LambdaFullAccess with the following policies:  
    * AmazonDynamoDBFullAccess  
    * AWSLambda\_FullAccess  
    * CloudWatchLogsFullAccess  
    * The ARN will look like this: arn:aws:iam::\<your\_account\_id\>:role/LambdaFullAccess  
* **An S3 Bucket** to store deployed Lambda functions.  
* **AWS CLI:** [Installation Guide](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)  
* **AWS SAM CLI:** [Installation Guide](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)  
* **Apache Maven:** [Installation Guide](https://maven.apache.org/install.html)  
* **Java 11:** Newer versions (like 17 or 21\) are supported by AWS Lambda but have not yet been fully tested with CCE.

### 

### **Configuration**

1. **Configure AWS Credentials:**  
   * Open a terminal and run aws configure.  
   * Enter your aws\_access\_key\_id and aws\_secret\_access\_key. This will store them in the \~/.aws/credentials file.  
2. **Edit CCE Configuration File:**  
   * After cloning the repository, navigate to the CCE-engine/ folder.  
   * Open the CCE.conf file.  
   * You **must** change the following parameters to match your environment:  
     * s3\_bucket\_name  
     * aws\_region  
     * aws\_account\_id  
3. **Optional Parameters (in CCE.conf):**  
   * CCE Runtime: How long you want CCE to run (as long as you set, more cost will be incurred).  
   * Lambda Hardware Level: The memory allocation for the Lambda functions (default is 1024).  
   * RTL: The Response Time Limit, which sets the approximate interval the user will tolerate waiting for results.

### 

### **Project Structure**

* CCE-engine/devices/: Contains .yml configuration files for each device, defining their key parameters.  
* CCE-engine/devices/eps/ & ..ins/: Used internally to collect processing data for cost-estimation models.  
* CCE-engine/rules\_yml/: Contains all the filter and correlation rules that CCE will process.  
* CCE-engine/events/: Holds the generated events for each Lambda function.  
* CCE-engine/rule\_template\_code/: Stores the most recently generated and deployed Lambda code.

For practical testing, CCE is configured to process events created by our event generator, **DataProducer**.

## 

## **▶️ Running CCE**

1. **Compile the Code:**  
   * Navigate to the CCE-engine/ directory in your terminal.  
   * Run the Maven command to compile the project and package it into a single JAR file:  
     mvn clean compile assembly:single

2. **Execute CCE:**  
   * Run the generated JAR file located in the target/ directory:  
     java \-jar target/CCE-1.0-SNAPSHOT-jar-with-dependencies.jar

3. **Monitor the Output:**  
   * Beyond the information shown in the terminal, you can view detailed logs in **AWS CloudWatch Log Groups** and see the generated alerts and alarms in your **Amazon DynamoDB** tables.

### 

### **Feedback**

As mentioned, this is the first version and is under construction. Any feedback is very welcome\!