pipeline {
  options { disableConcurrentBuilds() }
  environment {
    DOCKER_URL = 'docker.byteandbit.cloud'
  }
    agent {
    kubernetes {
      label 'podman'
      defaultContainer 'jenkins-slave'
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  securityContext:
    runAsUser: 0
    runAsGroup: 0
  serviceAccountName: jenkins
  volumes:
      - name: shared-data
        emptyDir: {}
  containers:
    - name: java
      image: maven:3-openjdk-8-slim
      command:
      - cat
      tty: true
      volumeMounts:
        - name: shared-data
          mountPath: /shared
    - name: homebrew
      image: homebrew/brew:3.4.1
      args:
        - sleep
        - "1000000"
      securityContext:
        privileged: true
      volumeMounts:
        - name: shared-data
          mountPath: /shared
"""
}
   }
    stages {
        stage('Build Velociraptor API') {
          steps {
            container('java') {
              withCredentials([string(credentialsId: 'maven-username', variable: 'MAVEN_USERNAME')]) {
                withCredentials([string(credentialsId: 'maven-password', variable: 'MAVEN_PASSWORD')]) {
                  sh('sed -i \'s/123name/\'"$MAVEN_USERNAME"\'/g\' settings.xml')
                  sh('sed -i \'s/123password/\'"$MAVEN_PASSWORD"\'/g\' settings.xml')
                  sh('mvn -s settings.xml clean package javadoc:javadoc deploy')
                  sh 'cp target/velociraptor-api-b$BUILD_NUMBER.jar /shared/Velociraptor-API-b$BUILD_NUMBER.jar'
                  sh 'cp -r target/site /shared/docs'
                }
              }
            }
          }
          when {
            branch 'master'
          }
        }
        stage('Release Velociraptor API') {
            steps {
              container('homebrew') {
                  withCredentials([string(credentialsId: 'git-token', variable: 'GH_TOKEN')]) {
                      sh 'git clone https://$GH_TOKEN@github.com/ByteAndBit-Studio/Velociraptor-API.git temp-docs'
                      dir("temp-docs") {
                          sh 'git fetch origin'
                          sh 'git switch -c gh-pages origin/gh-pages'
                          sh 'git rm -rf .'
                          sh 'cp -r /shared/docs/* .'
                          sh 'git add -A'
                          sh "git config --global user.email 'no-reply@byteandbit.studio'"
                          sh "git config --global user.name 'Jenkins'"
                          sh "git commit -m 'update javadocs'"
                          sh 'git push'
                      }
                      sh 'brew install gh'
                      sh 'gh release create b$BUILD_NUMBER --title \'Build #' + env.BUILD_NUMBER + '\' /shared/*.jar'
                  }
              }
            }
            when {
                branch 'master'
            }
         }
    }
}
