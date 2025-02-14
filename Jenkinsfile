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

def excuteCommand(cmd) {
    // Pour les commandes Docker, on normalise les slashes sur Windows
  def normalizedCmd = cmd.replaceAll("\\\\", "/")

  if (isUnix()) {
        sh normalizedCmd
  } else {
        // Sur windows, certaines commandes doivent être adaptées
    if(cmd.startsWith("docker ")) {
            bat normalizedCmd
    } else {
            // Pour les autres, on exécute la commande normalement
      bat "cmd /c ${normalizedCmd}"
    }
  }
}

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                excuteCommand("mvn clean install")
            }
        }

        stage('Test') {
            steps {
                excuteCommand("mvn test")
            }
        }

        stage('Package') {
            steps {
               excuteCommand("mvn package")
            }
        }
    }
}
