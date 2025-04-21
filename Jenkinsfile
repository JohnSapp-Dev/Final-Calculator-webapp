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
        maven '3.9.9'  //  Ensure 'Maven' is configured in Jenkins Global Tool Configuration
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
                        sh 'docker build -t johnsappdev/calculator-web-app.war .'
                        }
                    }
                }

        stage('Push Docker Image') {
            steps {
                script {
                    // Push the Docker image to your registry

                    sh 'docker login -u sappjohn1994@gmail.com -p zD6vMlrKIEpfum2e6*T44H7'

                    sh 'docker push johnsappdev/calculator-web-app.war'
                    }
                }
            }
        stage('Deploy to Kubernetes') {
            steps {
                script{
                    sh 'kubectl apply -f deployment.yaml'
                    sh 'kubectl apply -f service.yaml'
                    echo "Waiting for deployment to roll out..."
                    sh 'kubectl rollout status deployment/calculator-web-app-deployment --timeout=120s --watch'

                    echo "Service details:"
                    sh 'kubectl get service calculator-web-app-service'
                }

            }
        }
        stage('Run JMeter'){
            steps{
                dir('D:\\programs\\apache-jmeter-5.6.3\\bin'){
                    script{
                        echo "clearing log directory"
                        sh 'pwd'
                        echo "trying to run load test"
                        sh '".\\jmeter" -n -t "D:\\programs\\apache-jmeter-5.6.3\\bin\\Plans\\Calculator_load_test.jmx" -l "D:\\programs\\apache-jmeter-5.6.3\\bin\\logs\\calculator_app.jtl" -e -o "D:\\programs\\apache-jmeter-5.6.3\\bin\\calculator_results"'
                    }
                }
            }
        }
    }
}
