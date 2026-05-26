pipeline {
    agent any
    tools { maven 'Maven3' }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Raviteja7659/spring-app-test'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Archive JAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t spring-app:%BUILD_NUMBER% .'
                bat 'docker tag spring-app:%BUILD_NUMBER% spring-app:latest'
            }
        }
    }

    post {
        success { echo 'Docker image built successfully!' }
        failure { echo 'Build failed. Check logs.' }
    }
}