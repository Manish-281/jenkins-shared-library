
pipeline {
    agent { label 'node1' }
    
    stages {
        stage('Code') {
            steps {
                echo 'Cloning the code'
                git url: 'https://github.com/Manish-281/Project-Node-Dockerapp.git', branch: 'main'
                echo 'Git clone successful'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the code'
                sh 'docker build -t node-app:latest .'
                
            }
        }
        stage('Test'){
            steps{
                echo 'Code being tested'
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploying the code'
                sh 'docker run -d --name my-node-app -p 3000:3000 node-app:latest'
            }
        }
    }
}
