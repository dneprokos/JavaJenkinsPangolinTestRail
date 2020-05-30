pipeline {
  triggers {
    pollSCM('* * * * *')
  }
  options {
    timestamps()
    buildDiscarder(logRotator(numToKeepStr: '10'))
  }
  agent {
    docker {
        image 'maven:3-alpine'
        args '-v /root/.m2:/root/.m2'
    }
  }
  stages {
    stage('Build') {
        steps {
                sh 'mvn -B -DskipTests clean package'
              }
    }
    stage('Test Run') {
        steps {
                sh 'mvn test'
              }
        post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
        }
    }
  }
  post {
          always {
              pangolinTestRail([
                   testRailProject: 'AIT-TestRuns',
                      configs:[[
                       testPath: 'Master\\TestSection',
                       format: 'JUNIT',
                       resultPattern:'**/surefire-reports/*.xml',
                       testRun:'Regression',
                       failIfUploadFailed: true
                       ]],
                     ])
          }
      }
}