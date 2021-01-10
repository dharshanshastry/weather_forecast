node {
     
    def mvnHome = tool 'maven-3.6.1'
    def dockerImage
    def dockerRepoUrl = "springio"
    def dockerImageName = "weather-forecast"
    def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}"
    
    stage('Clone WeatherForecast repor') { 
      git 'https://github.com/dharshanshastry/weather_forecast.git'
    
    }    
  
    stage('Build Docker Image') {

      dockerImage = sh './mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/weather-forecast'
    }
	
   
    stage('Deploy Docker Image'){
      echo "Docker Image Tag Name: ${dockerImageTag}"

      sh "docker login -u admin -p admin123 ${dockerRepoUrl}"
      sh "docker tag ${dockerImageName} ${dockerImageTag}"
      sh "docker push ${dockerImageTag}"
    }
}
