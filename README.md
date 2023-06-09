# InsightIQ

InsightIQ is a personal project I've undertaken to explore the fascinating world of AI and Large Language Models (LLMs). The primary objective of this project is to develop a practical and valuable tool that not only assists me but also benefits others. It aims to create an intelligent knowledge management system that serves as a personal assistant.

Key Tenets of the Project:

1. **Privacy-First Architecture**: Implement robust security measures and adhere to best practices in data handling
and storage to prioritize user data privacy and security.
2. **Secure and Convenient Personal Storage**: Provide a secure storage solution for personal data, whether locally or in the cloud, ensuring ease of use and data protection.
3. **LLM Agnostic Approach**: Build a plugin architecture that supports various LLMs, enabling seamless integration with different models (e.g., ChatGPT or similar LLMs) without sacrificing functionality.
4. **Extensibility**: Allow the integration of personal data from diverse sources such as emails, calendar events, and documents, empowering users to expand and enhance the system's knowledge base.

These tenets guide the development of InsightIQ, ensuring a privacy-centric approach, a secure and intuitive user
experience, flexibility with LLMs, and the ability to incorporate personal data from multiple sources to enrich the
knowledge management capabilities

## Background

I have been using org-roam within Emacs to organize all my personal notes and documents securely. These notes are encrypted using gpg and git-crypt, and I store them on AWS using the CodeCommit service. This setup has provided me with a secure way to build a knowledge management system over the years.

Throughout my journey, I have accumulated hundreds of personal notes covering various topics such as finances, travel, and new things I've learned. While the system provides a secure and organized way to store my knowledge, it lacks intelligent management and data ingestion capabilities.

For instance, during my research on the best approach to creating a local service that can later be moved to the cloud, I came across numerous articles and queries to ChatGPT. Unfortunately, this valuable information is scattered and not easily accessible for future reference. It would be incredibly beneficial to have a system that allows me to easily ingest and classify such findings, building a comprehensive knowledge base for future queries.

Therefore, the aim of InsightIQ project is to bridge these gaps by:

1.    Enable easy ingestion of personal data, including research findings.
2.    Build a personal storage system using a vector database for efficient classification.
3.    Develop a Contextual Querying mechanism to retrieve relevant data based on techniques like keyword matching and semantic search.
4.    Integrate powerful Large Language Models (LLMs) to enhance accuracy and provide meaningful results to users.

The goal of InsightIQ is to create an intelligent knowledge management system that simplifies data ingestion, improves organization, and delivers accurate information to users.


## How?
#### Milestone 1:
Build a service that can be run locally (or in cloud in future) that ingests data into a vector db
#### Milestone 2:
Build contextual querying mechanism on top of data stored in the vector db
#### Milestone 3:
Integration with LLM to pass the queries and contextual data to get meaningful result


## Current state:
#### Git tag v0.1: ChatGPT integration complete
1. Setup `OPENAI_API_KEY` environment variable
2. Run the SpringBoot server by running command `./gradlew run`
3. A `test` thread is created by default for now
4. Run below curl command to make a call to ChatGPT.
    ```shell
    curl -X POST -H "Content-Type: application/json" -d '{
    "message": "Why do programmers prefer dark mode? Because light attracts bugs?",
    "threadId": "test"
    }' http://localhost:3001/chat/message
   ```
#### Run the server in Docker
1. Set the API key in as the env variable following the [best practices](https://help.openai.com/en/articles/5112595-best-practices-for-api-key-safety) by OpenAI
2. In the project root directory run below command to build the docker image.
   ```shell
   docker build --tag insightiq .
   ```
3. Run the image in Docker container using below command:
   ```shell
   docker run -e OPENAI_API_KEY=$OPENAI_API_KEY --publish 3001:3001 insightiq:latest
   ```
