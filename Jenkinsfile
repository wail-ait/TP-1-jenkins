pipeline {

    agent any

    environment {
        IMAGE_NAME = "tp3-java-app"
        IMAGE_TAG  = "latest"
        CONTAINER_NAME = "tp3-java-container"
        HOST_PORT = "8081"
        CONTAINER_PORT = "8080"
    }

    tools {
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/wail-ait/TP-1-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Deploy (Local Docker)') {
            steps {
                bat '''
                echo Checking existing container...

                docker ps -a --format "{{.Names}}" | findstr %CONTAINER_NAME% >nul
                if %ERRORLEVEL%==0 (
                    echo Container exists, stopping and removing...
                    docker stop %CONTAINER_NAME%
                    docker rm %CONTAINER_NAME%
                ) else (
                    echo Container does not exist, first deployment.
                )

                docker run -d ^
                  --name %CONTAINER_NAME% ^
                  -p %HOST_PORT%:%CONTAINER_PORT% ^
                  %IMAGE_NAME%:%IMAGE_TAG%
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline exécutée avec succès'
        }
        failure {
            echo '❌ Pipeline échouée'
        }
    }
}
