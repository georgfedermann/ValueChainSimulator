pipeline {
    agent { docker 'maven:3.3.3' }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'echo Hello, World!'
                sh 'echo Make a change at 2017-12-11 12:10:11 and look how long it will take Jenkins to rebuild.'
            }
        }
    }
}
