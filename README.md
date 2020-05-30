# JenkinsTestRailIntegration (Pangolin)

Project was designed to investigate integration between Jenkins and TestRail

# Preconditions
- Docker should be installed on you linux/windows machine
- TestRail and Pangolin server both require to have license
- TestRail should be installed separatelly
- The API is part of TestRail and can be enabled in TestRail's administration area under Administration > Site Settings > API.
- Current "JavaTestRailIntegration\jenkins_testrail_install\pangolin" directory contains expired license. So, you need to change it
in order to use Pangolin server

# Run docker containers
- Open "JavaTestRailIntegration\jenkins_testrail_install" folder and run the following cmd command 
"docker-compose up -d"

Note: This command will start jenkins and pangolin containers. 
You also need to configure Jenkins (localhost:8888) when you do a first run. Just look at the logs it will show you default password
and then follow further steps

# Pangolin plugin and configuration
Please follow the instruction in order to download and configure <b>pangolin-testrail-connector plugin https://plugins.jenkins.io/pangolin-testrail-connector/

  Note: Use "http://pangolin:9100" as <b>Pangolin URL

#Running tests and saving results to TestRail

Project contains configured jenkinsfile Jenkinsfile.
Everything you need to do is to change "testRailProject" and "testPath". 
  1) TestRailProject - name of the project where you want to create tests and add the results.
  2) testPath - Path to the test suite. For single suite project you can have "Master\\TestSection"

Then I would recommend to open BlueOcean (already added plugin) and follow the steps to repository with jenkinsfile. 
In other case you can configure it from old jenkins UI. Find hot to use Jenkinsfile.

  Note: Probably you need to fork the repository, because one of the steps require to generate api key for github. 


#Test results

If you have a valid license, test results will be exported to testrail

