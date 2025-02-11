node {
    // Détection du système d'exploitation
    def mvnCmd = isUnix() ? 'sh' : 'bat'

    stage('Build') {
        "$mvnCmd" 'mvn clean install'
    }
    stage('Test') {
        "$mvnCmd" 'mvn test'
    }
    stage('Package') {
        "$mvnCmd" 'mvn package'
    }
}