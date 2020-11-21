# FileManipulation
Instruction for the creating a new action/
1. Implement Interface ActionHandler/
1.1 Override getName() - the method will return name of the action theinput parm for cmd (like Shuffle)/
1.2 Override execute(String source, String dest) - here write the logic for a new action./
(Create local variable for the path where your source and dest files placed)

2. In the class ActionsContainer/
2.1 Add new action into the actionsList in the constractor/
2.2 In the checkIfExists method add new if (similar to the existing actions), so the program could find a new action according to the parameter entered in cmd

---------/
How to use the programm/
I use mySQL d.b for saving the actions into the table and mysql-connector jar inside the project to use JDBC Driver.

MYsql creates sequences in the table automaticaly, so I didn't created the sequences of the rows in the code

It will be run from a command prompt

Compiling the class

javac FilesManipulations.java

Executing the class

java -cp .;completePathOfProject(C:\myProject\workspace2\)\FilesManipulations\src\mysqlconnector\mysql-connector-java-5.1.49-bin.jar  FilesManipulations aaa bbb Sort

D.B.:

JDBC_DRIVER = "com.mysql.jdbc.Driver";

DB_URL = "jdbc:mysql://localhost:3306/FilesDB";

USER = "myuser";
PASS = "xxxx";

TABLE = actions
