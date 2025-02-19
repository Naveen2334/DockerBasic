##Docker Guide for Product Service

#Key Docker Concepts

#Docker Image

A Docker image is a lightweight, standalone, and executable package that includes everything required to run an application—such as the code, runtime, dependencies, environment variables, and configuration files. It serves as a blueprint for creating a running environment.

#Docker Container

A Docker container is a running instance of a Docker image. Similar to how an object is an instance of a class in programming, a container is an instance of an image. Multiple containers can be created from the same image, each running independently.

#Dockerfile

A Dockerfile is a text file that contains a series of commands to define how a Docker image should be built. Each command represents a step in setting up the environment. For example, a Dockerfile can specify the base image, copy application files, and define the execution command.

Example Dockerfile

FROM openjdk:17
COPY target/product-service.jar /app.jar
CMD ["java", "-jar", "/app.jar"]

#Setting Up and Using Docker

#1. Creating a Dockerfile

The Dockerfile defines how to build the environment for your application. In the example above:

We use openjdk:17 as the base image.

Copy the compiled JAR file (product-service.jar) into the container.

Specify the command to run the application.

#2. Building a Docker Image

Once the Dockerfile is ready, you can build a Docker image using the following command:

docker build -t your-username/product-service:1.0 .

The -t flag assigns a tag (name) to the image, making it easy to reference later.

#3. Running a Docker Container

After building the image, you can create and run a container from it:

docker run -d -p 8080:8080 your-username/product-service:1.0

-p 8080:8080 maps the container’s port 8080 to the host machine’s port 8080, making the service accessible.

-d runs the container in detached mode, meaning it runs in the background.

#4. Pushing the Docker Image to Docker Hub

To share the image, you can push it to Docker Hub:

docker push your-username/product-service:1.0

Once uploaded, anyone can pull and run the image on their machine.

#5. Pulling and Running the Image from Docker Hub

To run the same image on another machine:

docker pull your-username/product-service:1.0
docker run -d -p 8080:8080 your-username/product-service:1.0

3Additional Commands

List running containers: docker ps

Stop a container: docker stop <container_id>

Remove a container: docker rm <container_id>

Remove an image: docker rmi your-username/product-service:1.0





Here’s a complete step-by-step guide for creating a Dockerized Spring Boot application, running it, and pushing it to Docker Hub. I’ve included all the commands that are important for developers, as requested.
Step 1: Create the Dockerfile in your application folder

In your Spring Boot application's root directory, create a file named Dockerfile with the following content:

FROM openjdk:11

# Expose port for the application
EXPOSE 8080

# Copy the built JAR file into the container
COPY ./target/app.jar app.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

Step 2: Build the Application (if not already built)

Open your command prompt or terminal in the Spring Boot project folder and run the following Maven command to build the .jar file.

mvn clean package

This will create the JAR file (e.g., app.jar) in the target/ folder of your project.
Step 3: Start Your Application on the Server

Make sure your Spring Boot application is running. If you want to test it before Dockerizing:

mvn spring-boot:run

This should start the application on port 8080.
Step 4: Build the Docker Image

Now, build the Docker image using the docker buildx command:

docker buildx build -t springdemodocker -f Dockerfile .

This will create the image springdemodocker with the Dockerfile in the current directory.
Step 5: Add a Tag to the Docker Image

To add a version tag (e.g., 1.0.0) to your Docker image, run:

docker buildx build -t springdemodocker:1.0.0 -f Dockerfile .

Step 6: List Docker Images

To check all available Docker images on your local machine:

docker images

This will show a list of all images, including springdemodocker.
Step 7: Remove the Docker Image

To remove the Docker image from your local machine:

docker rmi springdemodocker

This command deletes the image springdemodocker from your local Docker cache.
Step 8: Check Running Docker Containers

To list the currently running Docker containers:

docker ps

This command shows all active containers.
Step 9: Remove Docker Container

To remove a running or stopped container, use the docker rm command. However, you need the container ID or name, which can be found using the docker ps or docker ps -a command.

docker rm <container_id_or_name>

For example, if the container name is springdemodocker, you can run:

docker rm springdemodocker

Step 10: Clear the Terminal Screen

Clear your terminal screen to keep it neat:

cls

Step 11: Run the Docker Container

Now, you can run the Docker container locally with the following command, mapping the container's port 8080 to your machine’s 8080:

docker run -p 8080:8080 springdemodocker

This will start the Spring Boot application inside the Docker container and expose it on port 8080 of your host machine.
Step 12: Push Docker Image to Docker Hub

Now that the Docker image is built, it’s time to push it to Docker Hub. Before you can push, make sure you're logged into your Docker Hub account.

    Log in to Docker Hub:

docker login

Enter your Docker Hub credentials when prompted.

Tag the Image for Docker Hub (Optional):

If you haven't tagged your image for Docker Hub yet, use:

docker tag springdemodocker:1.0.0 yourusername/springdemodocker:1.0.0

Replace yourusername with your Docker Hub username.

Push the Image to Docker Hub:

Finally, push your image to Docker Hub:

    docker push yourusername/springdemodocker:1.0.0

    This command uploads the image to your Docker Hub repository under the specified tag (1.0.0).

Step 13: Verify the Image on Docker Hub

Go to Docker Hub and log in to your account. You should see your image under the "Repositories" section with the tag 1.0.0.
Full CMD Script (For Reference):

# Build the application (if not built already)
mvn clean package

# Build the Docker image
docker buildx build -t springdemodocker -f Dockerfile .

# Add a version tag to the Docker image
docker buildx build -t springdemodocker:1.0.0 -f Dockerfile .

# List the images
docker images

# Remove the Docker image
docker rmi springdemodocker

# Check running containers
docker ps

# Remove the Docker container (if needed)
docker rm springdemodocker

# Clear terminal screen
cls

# Run the Docker container on localhost
docker run -p 8080:8080 springdemodocker

# Log in to Docker Hub
docker login

# Tag the image (optional)
docker tag springdemodocker:1.0.0 yourusername/springdemodocker:1.0.0

# Push the image to Docker Hub
docker push yourusername/springdemodocker:1.0.0

This sequence of commands covers the complete process of Dockerizing your Maven-based Spring Boot application, running it locally, removing the image/container, and pushing it to Docker Hub for distribution.
