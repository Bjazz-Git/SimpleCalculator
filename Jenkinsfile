pipeline {
  agent any
  stages {
    stage('run test') {
      steps {
        sh './mvnw clean verify'
      }
    }
  }
  post {
    success {
      archiveArtifacts artifacts: 'target/jmeter/**/*.log, target/jmeter/**/*.csv', followSymlinks: false
    }
  }
}
