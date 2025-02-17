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
