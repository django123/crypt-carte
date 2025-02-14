## Introduction au CI/CD, MONITORING et OBSERVABILITÉ

### Introduction

Dans ce tutoriel, nous allons voir comment utiliser les outils de CI/CD, de MONITORING et d'OBSERVABILITÉ pour améliorer la qualité de notre code.

### Objectifs
- Découvrir les outils de CI/CD, de MONITORING et d'OBSERVABILITÉ
- Déployer notre application avec les outils de CI/CD
- Déployer notre application avec les outils de MONITORING
- Déployer notre application avec les outils d'OBSERVABILITY
- Déployer notre application avec les outils de CI/CD et de MONITORING
- Déployer notre application avec les outils de CI/CD, de MONITORING et d'OBSERVABILITY
- Déployer notre application avec les outils de CI/CD, de MONITORING et d'OBSERVABILITY
  
## CI/CD
## Introduction au CI/CD

![image](https://user-images.githubusercontent.com/107435692/232263168-5e313482-4b53-4824-88f3-fa2a71cfca66.png)

## Flux de travail pour le processus CI/CD

![image](https://user-images.githubusercontent.com/107435692/233944846-55258b13-337d-4768-a828-b2461597a477.png)


##  **ÉTAPES POUR LE PIPELINE CI/CD UTILISANT JENKINS**

## 1) Mise en place de Jenkins

Run jekins setup script

## 1.1) obtenir le mot de passe pour la connexion
```
cat /var/lib/jenkins/secrets/initialAdminPassword
```
## 1.2) Créer un utilisateur

## 2) Lancer le premier job

Click new item > Name: Hello world > select freestyle project > Build Steps > Select Execute on shell > echo "Hello World!" && uptime > Save.

## 2.1) GÉRER VOTRE PREMIER Job
Click on Build now > Check build history > See output.

## 2.2) SSH dans la machine pour vérifier le répertoire des travaux, tous les travaux sont listés dans le répertoire.
```
cat /var/lib/jenkins/workspace/
```
## 3) Intégrer Git à Jenkins

![image](https://user-images.githubusercontent.com/107435692/232690489-50066483-f6ef-411d-9122-0e0b29e814b3.png)

## 3.1) Renommer le nom d'hôte en jenkins-server
```
echo "jenkins-server" > /etc/hostname
```
## 3.2) Installer git
```
yum install git -y & git -v
```
## 3.3) Installer le plugin github sur l'interface graphique de jenkins

Click Dashboard > manage jenkins > manage pulgins > Avaliable > Search for github > check and click on install without restart.

## 3.4) configurer git

Click Dashboard > manage jenkins > click tools > go for git > name git > Path to Git executable: /usr/bin/git (Exceute cmd **whereis git** to get path)> save
## 4) Exécuter une tâche Jenkins pour extraire du code de GitHubRun une tâche Jenkins pour extraire du code de GitHub

Click Dashboard > new item > Name: PUllcodefromgitRepo > source code management > select git > Enter git url name > credential none > click save.

## 4.1) Exécutez le job et vérifiez le dépôt pullé.

Click on build now > check the build history successfull.
```
cd /var/lib/jenkins/workspace/PullcodefromGitRepo
```
## 5) Integrer Maven à Jenkins

![image](https://user-images.githubusercontent.com/107435692/232700535-6415afa6-399b-423f-99ca-6c4ccf42f6ad.png)

## 5.1) INSTALLER MAVEN

Search maven install & maven download > copy link from the maven download **Binary tar.gz archive**.
# Aller au terminal
```
cd /opt
```
# télécharger maven

wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz

# unzip le fichier téléchargé
```
tar xzvf apache-maven-3.9.1-bin.tar.gz
```
# Renommer le répertoire dir en maven
```
mv apache-maven-3.9.1 maven
```
# check la version de maven
```
/opt/maven/bin/mvn -v
```
# set JAVA HOME PATH pour le définir comme variable d'environnement
```
M2_HOME=/opt/maven
M2=/opt/maven/bin
JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.18.0.10-3.el9.x86_64
```
# chercher le chemin d'accès du java
```
find / -name java-11*  
```
OUTPUT= /usr/lib/jvm/java-11-openjdk-11.0.18.0.10-3.el9.x86_64

## exporter la variable dans .bash_profile (vérifiez avant d'exécuter le fichier qu'il n'y a pas d'entrée de chemin)
```
echo -e "M2_HOME=/opt/maven\nM2=/opt/maven/bin\nJAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.18.0.10-3.el9.x86_64\nPATH=b\$PATH:b\$HOME:bin:b\$JAVA_HOME:b\$M2_HOME:b\$M2\nexport PATH" >> .bash_profile && source .bash_profile
```
## valider le chemin
```
echo $PATH
```
# check la version de maven
```
mvn -v
```

## 5.2) Ajouter le plugin Maven

Click Dashboard > manage jenkins> plugins > Available > search maven > check **maven integration** > install withour restart

## 5.3) CONFIGURER MAVEN

Click Dashboard > manage jenkins> TOOLS >

1. jdk > Name: Java-11 > JAVA_HOME: /usr/lib/jvm/java-11-openjdk-11.0.18.0.10-3.el9.x86_64 > MAVEN ADD > Name: Maven-3.9.1 MAVEN_HOME: /opt/maven > apply & save.

## 6)  Build le projet Java en utilisant Jenkins

# il faut créer un job de build pour construire le code source pullé du dépôt git.

1. Click Dashboard > new item > Name:Build_Maven_Artifact > select maven project > Source_code_management:check Git,
2. repo url:https://github.com/Pruthvi360/ci-cd-hello-world.git
3. Build > Root POM: pom.xml> Goals and options: clean install  (Check maven lifecycle)
4. Apply & save

## 6.1) Lancer le job et cliquer sur l'historique de build

## 6.2) **Click Build_Maven_Artifact JOB** and navigate workspace > webapp > target > webapp.war

## Monitoring & Observabilité

### 7) Monitoring
#### 7.1) Install loki and grafana
1. pour cela, on va utiliser le docker-compose.yml
2. on va lancer le docker-compose.yml
 ```
 docker-compose up -d
 ```
3. on va aller sur http://localhost:29000 pour voir le dashboard grafana
4. on va aller sur http://localhost:29145 pour voir le dashboard alloy
5. on va aller sur http://localhost:29100 pour voir le dashboard loki
6. on va aller sur http://localhost:3100 pour voir le dashboard loki
7. on va aller sur http://localhost:9090 pour voir le dashboard prometheus
