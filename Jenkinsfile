pipeline {
  agent any
  stages {
    stage('run test') {
      steps {
        bat "mvn clean verify"
      }
    }
  }
  post {
    success {
      archiveArtifacts artifacts: 'target/jmeter/**/*.log, target/jmeter/**/*.csv', followSymlinks: false
    }
  }
}
