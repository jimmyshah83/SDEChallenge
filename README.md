# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.

<br />
## Solution
Solution to SDE Challenge provided by PayTM Labs (https://github.com/PaytmLabs/SDEChallenge)

## Coding Solution
An interface IMovingAverage would expose methods to calculate the moving average of the last n elements with complexity O(n). <br />

I have used array as the underlying data structure to maintain the insertion order as well as easy access to elements using indexes.

<br /> <br />
## Google Analytic like Backend System - Solution

I have utilized Amazon web serviecs extensively. <br />

1. From the clients web browser / mobile, Google Analytic events are sent to two or more Spring Boot based microservices, 
running on AWS Elastic cloud compute (EC2) instances, via Amazon API gateway which makes it easy for developers to create, publish, 
maintain, monitor, and secure APIs at any scale. <br />
Because of the API gateway and the high availability microservice architecure, our system would be able to handle billions of requests per day. <br />

2. The data, from these EC2 instances, is persisted onto Cassandra DB using Amazon Kinesis and Spark streams. <br />
Kinesis would easily integrate with out exisintg AWS EC2 instances and similar to Kafka, it makes it easy to collect, process, and analyze real-time, streaming data. <br />
We use Spark to achieve high performance for both batch and streaming data which would be persisted onto a non relational database such as Cassandra DB. <br />
Apache Cassandra is a highly scalable and available distributed database. In our scenario, we configure Apache spark streams to persist data onto Cassandra DB. <br />

3. Lastly, for the Analytics dashboard, we accept client queries, routed to the EC2 instances via API Gateway, which would present the data to the client via JSON. <br />
