pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/SwapnilSalvi/bajajkart']])                  }
            }

         stage('Build'){
            steps {
                  sh 'mvn clean install -DskipTests'
                }
            }

         stage("Deploy"){
              steps{
                  sh 'docker compose up --build'
                   }
            }
    }
}