pipeline {
    agent { docker 'maven:3.3.3' }
    
    environment {
        MASTER_KEY='c7d51fc4-e032-11e7-80c1-9a214cf093ae'
        SLAVE_KEY='no remorse!'
    }
    
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
                sh 'echo Hello, World!'
                sh 'echo $MASTER_KEY - $SLAVE_KEY ++-'
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
        }
    }
}
