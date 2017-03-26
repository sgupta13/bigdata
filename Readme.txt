Steps to run the application:



1) We should first download the NetworkSparkStream.scala file which has the source code.  Please try to compile and package the program file using sbt.
   I would recommend to do the process manually so we learn more. 



2) I am facing some issues with virtualbox so I am using Cloudera VM.  


3) We should create a folder and may name as per choice and create a file named simple.sbt in that and we should create two sub-folder src/main/scala and target and should keep the NetworkSparkStream.scala in 
   src/main/scala folder and package it to get jar file using command sbt package.  If the packaging is successful, it will create jar file in target folder.

4) We should copy this jar file to /usr/spark/bin 


5) Now we should open one more terminal window and use the following command to create a connection:

   nc -lk localhost portnumber
   
   portnumber can be anything like: 9999, 9989 or anything

6) In another terminal direct the control to /usr/spark/bin folder and execute the NetworkSparkStream program using the following command:

   spark-submit --class <class name> <jar file name> hostname port-number

   e.g., spark-submit --class NetworkSparkStream streaming-programs_2.10-1.0.jar localhost 9979   

7) Once the program is executing, we can start typing something in the other terminal window, what ever words we type will be counted and will be displayed
   in the terminal window where our program is executing


