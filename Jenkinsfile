pipeline {
  agent any
  tools { maven 'Maven3' }

  stages {
    stage('Checkout') {
      steps { git branch: 'main', url: 'https://github.com/Raviteja7659/spring-app-test' }
    }
    stage('Build') {
      steps { sh 'mvn clean package -DskipTests' }
    }
    stage('Test') {
      steps { sh 'mvn test' }
      post {
        always { junit 'target/surefire-reports/*.xml' }
      }
    }
    stage('Archive JAR') {
      steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
    }
  }
}
