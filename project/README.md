# SCS_Programming_Task



## CONTRIBUTOR: HEMIN DESAI

## INTRODUCTION:
	
	The whole SCS Programming Task is divided into two different type of projects, a. RESTful Webservice & b. HTML Web Project, for the convinience. Web Project consumes the web service to list the data on the HTML page. Explanation of each project is mentioned below.

## EXPLANATION:

	a. RESTful Webservice Project:
		#Technologies and Libraries used: Maven, Spring Boot for RESTful web service, Kohsuke JAVA GitHub API, gson for JSON parsing.

		#Working: The project packaging is a jar file. GithubCommitsApplication is the main class which initializes the application. GhCommitsRestController is a rest controller, where the actual HTTP request mapping is done. Commit is a model class which has the getter and setter methods of mentioned parameters.
		The RESTful web service will be accessible at <ip>:8080/list. This web service has the GitHub API integration with the rails/rails repository and will give the list of the latest 30 commits with the mentioned details. 

	b. Web Project:
		#Technologies and Libraries used: HTML, JQuery and JQuery datatable.
		
		#Working: On requesting the page, it will call the RESTful web service to fetch the data and will list in a tabular format which is composed of JQuery datatable. It has features like sorting, searching and pagination.

## STEPS TO RUN THE PROJECT:

	1. Start the web service by executing the following command in command promt:
		java -jar <file_name>.jar
	   - This will start the RESTful web service at port 8080.
	
	2. Deploy this project on any web server (I used TOMCAT), and change the server port number to other than 8080.


################################### END ##################################### 