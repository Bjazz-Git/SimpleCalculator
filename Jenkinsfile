pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
        git 'Default'
    }

    stages {
        stage('Get Source') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/Bjazz-Git/SimpleCalculator.git'

                // Run Maven on a Unix agent.
               // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Build and Run Tests'){
            steps{
                bat 'mvn clean test'
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    bat "echo Success"
                    junit '**/target/surefire-reports/TEST-*.xml'
                    //archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
