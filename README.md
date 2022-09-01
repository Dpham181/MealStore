# MealStore

The application we’re expecting to be written is quite simple, for what we’ll be expecting is a simple Grails web application written under the web profile which for the purposes of this exercise you can name anything you want is expected to be able to search for meals based on the different criterion as outlined within the API documentation and display the results onto a page. Once the results have been displayed onto the page the user should then be able to either view further information on the meal or save the meal to a database to be viewed later. There are one of two options you must use as a database:
H2
An in-memory SQL database which is built into the Grails framework, and in my opinion, for the purposes of completing this assignment would be the most logical choice.
MySQL
If you go this route the data source that your application references must either be publicly accessible, meaning I can connect to it running your code locally, or include the SQL script(s) used to create it so I can create my own instance of the database.
In terms of what I am expecting of this application I am expecting something along the lines of the following:
The application that is to be written must be written in Grails 3.3.6 or higher.
Employ the usage of a modern front-end framework Bootstrap or Skeleton, but I’ll ultimately leave the choice of the front-end framework up to you.
Ability to search for meals.
Display the search results or inform the end user that no results were found.
Include the ability to save, edit, and delete a meal from the database via the usage of GORM the built-in Object Relational Mapping (ORM) protocol that comes standard in Grails. You have plenty of leeway in terms of how you want to design the database to store the data, but your application must be database driven and use at least one Grails Domain Class.
