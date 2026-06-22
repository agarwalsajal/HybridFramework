pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK26'
    }

    stages {

        stage('checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/agarwalsajal/HybridFramework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Execute Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                echo 'Extent Report Generated'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'reports/**'
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}
