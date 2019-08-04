Introduction:

The objective of my application is to diminish the risk for the bank and the client, by predicting and monitoring the payment, 
as well as all the expenses for fulfilling a loan. The software is able to accurately predict the final result and the customer’s payment potential, 
by providing the users the most relevant information.


The algorithm is based on a classifier, which “classifies” the test data accordingly to the validated one. For the classification columns, 
2 columns are taken in consideration the score (and integer value) and the eligibility which is a 2 class component (yes/no). Firstly, 
the accuracy was 57%, but after long struggles, the accuracy became 98% (as a mean). In order to make the algorithm more efficient I used crossValidation, 
as a resampling procedure (K-paramater=10). 

Data:
There are 10000 rows in the DB. The eligibility of each client is splitted useing the classiffier mentioned above. 



The programmer has 2 options: 1. To store the eligibiity value based on a scoring condition (as it is already done).
			      2. Every new input is classified based on the previous attempts (data already validated) and after that, stored in the DB.


Used Technologies: Java,Hibernate ORM, JAVAFX, Weka Library, MYSQL

All the needed connectors are added inside the project.

Thank you!