node {
    // Détection du système d'exploitation
    def mvnCmd = isUnix() ? 'sh' : 'bat'

    stage('Build') {
        steps {
            "$mvnCmd" 'mvn clean install'
        }
    }
    stage('Test') {
       steps {
           "$mvnCmd" 'mvn test'
       }
    }
    stage('Package') {
        steps {
            "$mvnCmd" 'package'
        }
    }
}