pipeline {
  agent any
  stages {
    stage('run test') {
      steps {
        bat "mvn -Dmaven.test.failure.ignore=true clean verify"
      }
    }
  }
  post {
    success {
      archiveArtifacts artifacts: 'target/jmeter/**/*.log, target/jmeter/**/*.csv', followSymlinks: false
    }
  }
}
