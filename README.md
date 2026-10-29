# ☁️ CCE: Cloud Correlation Engine

**A Cloud-based SIEM Correlation Engine using a stateless FaaS model.**

CCE reimagines traditional SIEM architecture by processing and correlating events through serverless functions, offering a modern, scalable, and cost-efficient approach to security event management.

## Key Design Stages
CCE's design is built upon three foundational stages:
1. **⚙️ Modelling:** Transforming the stateful SIEM correlation engine into a stateless design perfectly suited for serverless functions (FaaS).
2. **⚙️ Automation:** Automatically translating textual security rules into executable, deployable serverless functions.
3. **⚙️ Optimization:** Efficiently optimizing function grouping, execution parameters, and hardware configuration to ensure maximum cost-efficiency.

## Core Capabilities
CCE is a cloud-based SIEM correlation engine capable of:
* ✅ Generating code for filter and correlation rules.
* ✅ Deploying these rules dynamically as FaaS (AWS Lambda).
* ✅ Processing events and generating alerts in near real-time.
* ✅ Correlating alerts over time to produce high-level alarms.

> **Note:** This is an early-stage prototype currently under active development. Technical details and the architectural evaluation will be published in **SRDS-2025**.

## 🚀 Getting Started

### Prerequisites
* **AWS Account & IAM Credentials:**
  * An IAM User with: `AmazonDynamoDBFullAccess`, `AWSLambda_FullAccess`, `AmazonS3FullAccess`.
  * An IAM Role named `LambdaFullAccess` containing the policies: `AmazonDynamoDBFullAccess`, `AWSLambda_FullAccess`, `CloudWatchLogsFullAccess`. *(The ARN will look like this: `arn:aws:iam::<your_account_id>:role/LambdaFullAccess`)*
* **An S3 Bucket:** Required to store and deploy Lambda function code.
* **Development Tools:** AWS CLI, AWS SAM CLI, Apache Maven, and Java 11 (newer versions supported by Lambda but not fully tested with CCE).

### Configuration
1. **Configure AWS Credentials:** Run `aws configure` and provide your access keys.
2. **Edit Configuration File:** Open `CCE-engine/CCE.conf` and update the mandatory fields:
   * `s3_bucket_name`
   * `aws_region`
   * `aws_account_id`
3. **Optional Parameters:** Adjust `CCE Runtime`, `Lambda Hardware Level` (default 1024MB), and `RTL` (Response Time Limit).

## 📁 Project Structure
* `CCE-engine/devices/`: `.yml` configuration files defining key parameters for each device.
* `CCE-engine/rules_yml/`: Filter and correlation rules processed by CCE.
* `CCE-engine/events/`: Generated events for each Lambda function.
* `CCE-engine/rule_template_code/`: The most recently generated and deployed Lambda code.

*For practical testing, CCE is configured to process events created by our internal event generator (DataProducer).*

## ▶️ Running CCE
**1. Compile the Code:**
Navigate to the `CCE-engine/` directory and run:
```bash
mvn clean compile assembly:single
