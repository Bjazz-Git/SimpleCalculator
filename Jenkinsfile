pipeline {
    agent any
    stages {
        stage('Build and Push Docker Image') {
            steps {
                git branch: 'main', url: 'https://github.com/Bjazz-Git/SimpleCalculator.git'

                // Executes the command mvn clean package, which creates/recreates a new maven build and tests the Junit code
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'braxtonjazz-dockerhub') {
                        //Creates a Docker image of the maven build, this image can be used to make a docker container
                        def appImage = docker.build("braxtonjazz/simplecalculator:${env.BUILD_NUMBER}")
                        appImage.push()
                    }
                }
            }
        }
    }
}
