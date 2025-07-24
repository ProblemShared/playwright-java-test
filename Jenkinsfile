pipeline {
    // Playwright with Java, see https://playwright.dev/java/docs/ci#jenkins
    agent {
        docker {
            // See https://mcr.microsoft.com/en-us/artifact/mar/playwright/java
            image 'mcr.microsoft.com/playwright/java:v1.54.0-noble'
            args '-u root:root'
        }
    }

    // Playwright with Java, see https://playwright.dev/java/docs/ci#jenkins
    stages {
        stage('Install Dependencies') {
            steps {
                // Build and Install
                sh 'mvn -B install -D skipTests --no-transfer-progress'
                // Install Playwright browsers and dependencies
                sh 'mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --with-deps"'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Tests failed! Check the report for details.'
        }
    }
}
