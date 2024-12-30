pipeline{
    agent any
    tools{
        jdk 'jdk23'
        maven 'maven'
    }
    stages {
        stage('clean workspace'){
            steps{
                cleanWs()
            }
        }
        stage('Checkout From Git'){
            steps{
                git branch: 'main', url: 'https://github.com/omprakash1882/spring-boot-application.git'
            }
        }
        stage('mvn compile'){
            steps{
                sh 'mvn clean compile'
            }
        }
        stage('mvn build'){
            steps{
                sh 'mvn clean install -DskipTests'
            }
        }  
        stage("OWASP Dependency Check"){
            steps{
                dependencyCheck additionalArguments: '--scan ./ --format HTML ', odcInstallation: 'DP-Check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.html'
            }
        }
        stage("Docker Build & Push"){
            steps{
                script{
                   withDockerRegistry(credentialsId: 'docker', toolName: 'docker'){   
                       sh "docker build -t java-edstruments ."
                       sh "docker tag java-edstruments omprakashkami/final-java-application-edstruments:latest "
                       sh "docker push omprakashkami/final-java-application-edstruments:latest "
                    }
                }
            }
        }
        stage("TRIVY"){
            steps{
                sh "trivy image mprakashkami/final-java-application-edstruments:latest > trivy.txt" 
            }
        }
    }
}
