# practiceProjects

Spring boot project with spring JPA and postgresql 

POC has following Student APIs:

1)"/students" , Method: GET  => It checks if student table is created or not , if not created it will create student table else it will returns list of all students present in student table.

2)"/students/{id}" , Method: GET  => It will return student info for the id specified in URI. Eg- "/students/1"  will return information for student having id as 1 .

3)"/student" , Method: POST  =>  It will add the student info mentioned in request body as JSON to the student table.
Eg: { "studentName" : "gurfateh", "studentClass" : "first"} is the JSON object in request body then this info will be saved in student table.

4)"/students/{id}" ,Method: DELETE => It will delete record of student having the specified id.

5)"/students", Method: DELETE => It will drop student table from db.

6) "/uploadFile , Method: POST => It will recieve csv file in request body and will parse that file , save the student records 
mentioned on the csv file.
