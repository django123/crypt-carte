node {
    def mvnCmd = isUnix() ? 'sh' : 'bat'
    def mavenHome = "C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn"

    stage('Build') {
        "$mvnCmd" "\"${mavenHome}\" clean install"
    }

    stage('Test') {
        "$mvnCmd" "\"${mavenHome}\" test"
    }

    stage('Package') {
        "$mvnCmd" "\"${mavenHome}\" package"
    }
}