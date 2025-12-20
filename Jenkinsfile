pipeline {

    agent any

    tools {
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: '*/main',
                    url: 'https://github.com/wail-ait/TP-1-jenkins'
            }
        }

        stage('Build') {
            steps {
                echo 'Compilation du projet'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Exécution des tests unitaires'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging du projet'
                bat 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Déploiement de l’application'
                bat 'echo Déploiement simulé'
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécutée avec succès'
        }
        failure {
            echo 'Pipeline échouée'
        }
    }
}
