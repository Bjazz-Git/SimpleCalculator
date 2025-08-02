pipeline {
    agent any
    stages {
        //Build and verify maven build
        stage('Build Maven Project'){
          steps{
            git branch: 'main', url: 'https://github.com/Bjazz-Git/SimpleCalculator.git'

              // Executes the command mvn clean package, which creates/recreates a new maven build and tests the Junit code
              bat "mvn clean verify"

          }
        }

        //Test Project's Junit Code
        stage('Run Jmeter-junit tests'){
          steps{
              //Goes to local Jmeter Installation and executes bat. Uses jmx file located in github and creates a jtl file based on the jmeter test results.
              bat 'C:/Users/Braxt/Tools/Jmeter/apache-jmeter-5.6.3/bin/jmeter.bat -n -t "SimpleCalculator.jmx" -l SimpleCalcTestResults.jtl'
              bat jmeter -g "SimpleCalculator.jmx" -o "jmeter-reports"
          }
        }
        stage('Publish Jmeter Report'){
          steps{
              publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                reportDir: 'jmeter-reports',
                keepAll: true,
                reportFiles: 'index.html',
                reportName: 'Jmeter Results'
              ])
          }
        }
        stage('Approve Docker Push'){
          steps{
            input(
              id: 'ApprovePush',
              message: 'Push Project to Docker?'
              // ok: 'Create and Push Docker Image'
            )
          }
        } 
        stage('Create and Push Docker Image') {
            steps {
                // git branch: 'main', url: 'https://github.com/Bjazz-Git/SimpleCalculator.git'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'braxtonjazz-dockerhub') {
                    //Creates a Docker image of the maven build, this image can be used to make a docker container
                    def appImage = docker.build("braxtonjazz/simplecalculator")
                    appImage.push()
                    }
                }
            }
        }
     } 
}