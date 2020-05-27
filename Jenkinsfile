//change display name in jenkins
currentBuild.displayName = "sonar-integration-#${currentBuild.number}"

pipeline {
    agent any

    environment {
        //specify maven bin location and add it to the PATH variable
        PATH = "/opt/maven3/bin:$PATH"
    }

    stages {
        
        stage('Build') {
            steps {
                sh 'mvn -DskipTests clean package'
                /* withSonarQubeEnv('Sonar_Server') {
                    sh 'mvn clean package sonar:sonar'
                } */// SonarQube taskId is automatically attached to the pipeline context
                
            }
        }

        stage('Unit-Test') {
            steps {
                sh 'mvn verify -P utest'
            }
        }

        stage('Integration-Test') {
            steps {
                sh 'mvn verify -p itest'
            }
        }

        /* stage('Sonarqube') {
            // environment {
            //     scannerHome = tool 'SonarQubeScanner'
            // }
            steps {
                // withSonarQubeEnv('sonarqube') {
                //     sh "${scannerHome}/bin/sonar-scanner"
                // }
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        } */        

        /* stage('Quality-Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
                def qg = waitForQualityGate(); // Reuse taskId previously collected by withSonarQubeEnv
                    if (qg.status != 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                }
            }
        } */

        stage('Deploy') {
            steps {
                echo "Deploying the project";
            }
        }
    }
    post {
        always {
            echo "This will always run"
        }
        success {
            echo "This will run only if success"
        }
        failure {
            echo "This will run only if failed"
        }
        unstable {
            echo "This will run only if the run was marked as unstable"
        }
        changed {
            echo "This will run only if the state of the pipeline has changed"
            echo "For example, if the pipeline was previously failing but is now successful"
        }
    }
}

