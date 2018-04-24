pipeline {
  agent any
  stages {
    stage('compiling, test, packaging') {
      steps {
        bat 'gradle clean build'
      }
    }
    stage('archival') {
      steps {
        junit '\'**/build/test-results/**/TEST-*.xml\''
        archiveArtifacts '\'build/libs/demo-0.0.1-SNAPSHOT.jar\''
      }
    }
  }
}