/*
pipeline {
    agent any
    envirorment{
        DOCKER_IMAGE = 'final_pipeline_john_sapp'
        DOCKER_REGISTRY = 'johnsappdev/final_pipeline_johnsapp'
    }
    tools{maven 'Maven'}
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/JohnSapp-Dev/Final-Calculator-webapp', branch: 'main' // Replace with your repo
                refspec: '+refs/heads/:refs/remotes/origin/'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvn clean install'
            }
        }
        stage('Test') {
            steps {
                //  Run TestNG (assuming you have a surefire-plugin configuration in Maven)
                sh 'mvn test'
                //  Publish JUnit test results
                junit 'target/surefire-reports */
/*.xml'
            }
        }
        stage('Build Docker Image') {
            steps {
                //  Build the Docker image
                script {
                    def image = docker.build("your-docker-image-name:${BUILD_NUMBER}", '.') // Tag with build number
                    env.DOCKER_IMAGE_NAME = image.imageName
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                //  Push the Docker image
                script {
                    docker.withRegistry('https://your-docker-registry', 'your-docker-credentials-id') { // Replace
                        docker.push("${env.DOCKER_IMAGE_NAME}")
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                //  Use kubectl to deploy (you'll need to configure your K8s deployment YAML)
                sh 'kubectl apply -f deployment.yaml'
                //You might need to set the image.
                sh "kubectl set image deployment/your-app-deployment your-app-container=${env.DOCKER_IMAGE_NAME} -n your-namespace"
            }
        }
    }
} */

pipeline {
    agent any
    tools {
        maven 'Maven 3.9.9'  //  Ensure 'Maven' is configured in Jenkins Global Tool Configuration
    }
    stages {
        stage('Checkout') {
            steps {
                git(
                    url: 'https://github.com/JohnSapp-Dev/Final-Calculator-webapp',
                    credentialsId: 'github',
                    branch: 'main',

                )
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'  //  Maven command to clean and build
            }
        }

        stage('Build Docker Image') {
                    steps {
                        script {
                            //  Use a more robust way to define the image name
//                             def imageName = "johnsappdev/final-calculator-webapp:${BUILD_NUMBER}"
//                             // Wrap docker commands in a withRegistry block
//                             docker.withRegistry('https://registry-1.docker.io', 'your-docker-credentials-id') {
//                                 docker.build(imageName, '.')
//                                 env.DOCKER_IMAGE_NAME = imageName
                                sh 'docker build -t johnsappdev/CalculatorWebApp.war'


                             }
                        }
                    }
                }
        stage('Push Docker Image') {
            steps {
                script {
                    // Push the Docker image to your registry
                    docker.withRegistry('https://your-docker-registry', 'your-docker-credentials-id') {
                        docker.push("${env.DOCKER_IMAGE_NAME}")
                    }
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                //  Deploy to Kubernetes
                sh "kubectl apply -f kubernetes/deployment.yaml" //example
                sh "kubectl set image deployment/final-calculator-deployment final-calculator-container=${env.DOCKER_IMAGE_NAME} -n your-kubernetes-namespace"

            }
        }
    }
}
