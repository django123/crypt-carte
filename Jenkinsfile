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
    def mvnCmd = isUnix() ? 'sh' : 'bat'
    stages {
        stage('Build') {
            steps {
                "$mvnCmd"  "mvn clean install"
            }
        }

        stage('Test') {
            steps {
                "$mvnCmd"  "mvn test"
            }
        }

        stage('Package') {
            steps {
                "$mvnCmd"  "mvn package"
            }
        }
    }
}
