node {
    stage('Build') {
        bat 'mvn clean install'
    }
    stage('Test') {
        bat 'mvn test'
    }
    stage('Package') {
        bat 'mvn package'
    }
}