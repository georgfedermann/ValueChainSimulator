pipeline {
    agent { docker 'maven:3.3.3' }
    
    environment {
        MASTER_KEY='c7d51fc4-e032-11e7-80c1-9a214cf093ae'
        SLAVE_KEY='no remorse!'
    }
    
    stages {
        stage('build') {
            steps {
                sh 'mvn clean javadoc:javadoc cobertura:cobertura package'
                sh 'echo Hello, World!'
                sh 'echo $MASTER_KEY - $SLAVE_KEY ++-'
                cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/**/*.xml'
            echo 'One way or the other, the build was finished.'
        }
        success {
            echo 'The build was successful!'
            mail to: 'georg.federmann@gmail.com', subject: "Build was successful: ${currentBuild.fullDisplayName}",
            body: "Everything is ok with ${env.BUILD_URL} - grin :->"
        }
        unstable {
            echo 'Some unit tests might have failed, or some other reason why the build was classified unstable'
        }
        failure {
            echo 'The build has failed.'
            mail to: 'georg.federmann@gmail.com', subject: "Build FAILED (argl): ${currentBuild.fullDisplayName}",
            body: "This build failed, take a look at it: ${env.BUILD_URL}."
        }
        changed {
            echo 'Things were different before ... either changed to the better, or to the worse.'
        }
    }
}
