pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test scoverage:report'
            }
        }

        stage('Code Quality') {
            steps {
                script {
                    def scannerHome = tool 'sonarqube-scanner';
                    withSonarQubeEnv("sonarqube-container") {
                        sh "${tool("sonarqube-scanner")}/bin/sonar-scanner \
                        -Dsonar.host.url=http://192.168.1.92:9000 \
                        -Dsonar.login=ee6e4167ae3d0ea25a01c63723a070acd5b14be8"
                    }
                }
            }
        }
    }
}