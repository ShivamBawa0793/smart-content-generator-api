Project README: Product Description Generator with Spring AI and Ollama
This document provides a guide for setting up a Spring Boot application that uses Spring AI to generate creative product descriptions. The application leverages the Phi-3 large language model running locally via Ollama.

1. Setting up Ollama for Local Computation
   Ollama is a powerful tool for running large language models on your local machine, allowing for offline computation and faster response times.

Installation
Follow the official installation instructions for your operating system:

macOS: Download the application from the Ollama website and follow the installation wizard.

Linux: Run the following command in your terminal:

curl -fsSL https://ollama.com/install.sh | sh


Windows: Download the installer from the Ollama website and run the .exe file.

Installing the Phi-3 Model
Once Ollama is installed and the server is running, you can download the Phi-3 model using the command-line interface. The phi3 model comes in different sizes; the phi3:mini version is a great starting point for local development.

The following command will download and run the Phi-3 Mini model:

ollama run phi3


This command will automatically download the model if it's not already on your machine.

RAM Requirements
To run the phi3:mini model effectively, your system should have at least 4 GB of available RAM. For the larger phi3:medium model, you will need approximately 8 GB or more of available RAM. A system with a total of at least 8 GB of RAM is recommended to run the smaller model smoothly alongside other applications.

2. Spring Boot Project Setup
   This section outlines how to configure your Spring Boot application to use the local Ollama instance with the Phi-3 model.

Prerequisites
Java 17 or higher

Maven or Gradle

A running Ollama instance with the phi3 model downloaded.

Step 1: Add Dependencies
Add the spring-ai-ollama-spring-boot-starter dependency to your project's build file.

Maven (pom.xml):

<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-ollama-spring-boot-starter</artifactId>
</dependency>


Gradle (build.gradle):

implementation 'org.springframework.ai:spring-ai-ollama-spring-boot-starter'


Step 2: Configure application.properties
Configure your Spring application to connect to the Ollama server and specify the Phi-3 model. Add the following properties to your src/main/resources/application.properties file:

# Ollama's default base URL
spring.ai.ollama.base-url=http://localhost:11434

# Specify the model to use
spring.ai.ollama.chat.options.model=phi3

# Optional: Set a specific pulling strategy for the model on startup
# 'when_missing' will download the model only if it's not present locally
spring.ai.ollama.init.pull-model-strategy=when_missing


3. Running the Application
   Start your Ollama server if it's not already running.

Ensure the phi3 model is downloaded using the ollama run phi3 command.

Run your Spring Boot application.

Open a web browser or use a tool like curl or Postman to make a GET request to the following endpoint:

http://localhost:8080/generate/description?product=Super-Duper%20Widget


The application will send the prompt to the local Ollama server, which will use the Phi-3 model to generate a catchy description for the "Super-Duper Widget." The response will be the generated text from the model.