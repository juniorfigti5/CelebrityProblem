<h1>CELEBRITY PROBLEM</h1>

This is an application to find a celebrity in a team of n people, a celebrity is known by everyone but he/she doesn't know anybody.

<h3>SOFTWARE REQUIRED</h3>

- Maven
- Java

<h3>INPUT:</h3>

csv file must be in "./src/main/resources" and must be called "team.csv"

csv file is a matrix that describes the members of the team about if that each member knows. If member a knows member b the value should b 1, otherwise should be 0. it is obvious that each member knows at least himself.

<b>Example:</b>

Each row represents a member and describes if he knows or not other members. Each one knows at least himself. 

```Input
1° row: 1,0,0,0,0,1 </br>
2° row: 0,1,0,0,0,1 </br>
3° row: 0,0,1,0,0,1 </br>
4° row: 0,0,0,1,0,1 </br>
5° row: 0,0,0,0,1,1 </br>
6° row: 0,0,0,0,0,1 </br>
```

In previous example everyone knows the sixth member and the application will return <b>"5"</b> (0 to n-1).

<h3>BUILD and run </h3>

- Open terminal and navigate to the project root folder.
- Run command "mvn install" in terminal.
- Run command "mvn spring-boot:run" in terminal.

You will see something like:

``` Response
CELEBRITY PROBLEM!!</br>
Team loaded: [[1, 0, 0, 0, 0, 1], [0, 1, 0, 0, 0, 1], [0, 0, 1, 0, 0, 1], [0, 0, 0, 1, 0, 1], [0, 0, 0, 0, 1, 1], [0, 0, 0, 0, 0, 1]]</br>
Posible celebrities are: [[0, 0, 0, 0, 0, 1]]</br>
The Celebrity´s Id is: 5</br>
THANK YOU!
```