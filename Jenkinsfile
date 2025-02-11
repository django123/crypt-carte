node {
    // Détection du système d'exploitation
    def mvnCmd = isUnix() ? 'sh' : 'bat'

    stage('Build') {
        "$mvnCmd" './mvnw clean install'
    }
    stage('Test') {
        "$mvnCmd" './mvnw test'
    }
    stage('Package') {
        "$mvnCmd" './mvnw package'
    }
}