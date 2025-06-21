pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/Bjazz-Git/SimpleCalculator.git'

                // Executes the command mvn clean package, which creates/recreates a new maven build and tests the Junit code
                bat "mvn -Dmaven.test.failure.ignore=true clean package"

                //Creates a Docker image of the maven build, this image can be used to make a docker container
                bat "docker build -t simplecalculator ."
            }

            post {
                success {
                    echo "Success"
                }
            }
        }
    }
}
