/*
node {
    def mvnCmd = isUnix() ? 'sh' : 'bat'


    stage('Build') {
        "$mvnCmd"  "mvn clean install"
    }

    stage('Test') {
        "$mvnCmd" "mvn test"
    }

    stage('Package') {
        "$mvnCmd" " mvn package"
    }
}*/

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}
