# Weather forecast 


Steps to deploy the application locally

# Step 1: Build docker image 

docker build -t springio/dharshan-weather-forecast .

# Step 2: Run docker container 

docker run -p 8090:8090 -t springio/dharshan-weather-forecast


# Step 3: URL to acces the service 

http://localhost:8090/forecast?cityName=London
