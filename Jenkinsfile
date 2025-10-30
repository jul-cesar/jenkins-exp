pipeline {
  agent any
  options { timestamps() }   // <- quitamos ansiColor

  tools { maven 'Maven 3' }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }
    stage('Build') {
      steps { sh 'mvn -B -DskipTests clean package' }
    }
    stage('Test') {
      steps { sh 'mvn -B test' }
      post { always { junit '**/target/surefire-reports/*.xml' } }
    }
    stage('Archive') {
      steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true }
    }
  }

  post {
    success { echo "Build OK #${env.BUILD_NUMBER}" }
    failure { echo "Build FAILED #${env.BUILD_NUMBER}" }
  }
}
