package poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*; 
  
import com.opencsv.CSVReader; 
import com.opencsv.bean.CsvToBean; 
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy; 

import poc.entity.Student;
import poc.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @GetMapping(value = "/students", produces = "application/json")
    public List<Student> listStudents(){
    	
        return studentService.listAll();
    }

    @GetMapping(value = "/students/{id}", produces = "application/json")
    public Student getStudent(@PathVariable String id){
        return studentService.getById(Long.valueOf(id));
    }
    

    @PostMapping( value="/student")
    public Long registerStudent(@RequestBody Student student) {
    	Student s=studentService.saveOrUpdate(student);   	
		return s.get_id();
    }
    
    
    @DeleteMapping(value = "/students/{id}", produces = "application/json")
    public void deleteAStudent(@PathVariable String id){
		studentService.delete(Long.valueOf(id));
        return ;
    }
	
     @DeleteMapping(value = "/students", produces = "application/json")
    public void dropTable(){
		studentService.dropTable();
        return ;
    }	
    
    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    	if (file.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }
    	System.out.println("path" +file.getContentType());
        try {
        	List<Student> allStudents=readCsv(file);
        	if(!allStudents.isEmpty()) {
    		studentService.saveAllStudents(allStudents);
        	}
        } catch (IOException e) {
			e.printStackTrace();
		}        	
        return new ResponseEntity("Successfully uploaded ", HttpStatus.OK);

    }
    

        private List<Student> readCsv( MultipartFile file) throws IOException 
        { 
      
            // Hashmap to map CSV data to  
            // Bean attributes. 
            Map<String, String> mapping = new 
                          HashMap<String, String>(); 
            mapping.put("id", "_id"); 
            mapping.put("name", "studentName"); 
            mapping.put("class", "studentClass"); 

      
            // HeaderColumnNameTranslateMappingStrategy 
            // for Student class 
            HeaderColumnNameTranslateMappingStrategy<Student> strategy = 
                 new HeaderColumnNameTranslateMappingStrategy<Student>(); 
            strategy.setType(Student.class); 
            strategy.setColumnMapping(mapping); 
      
            // Create castobaen and csvreader object 
            CSVReader csvReader = null;           
            csvReader = new CSVReader(
            		new InputStreamReader(file.getInputStream(),StandardCharsets.UTF_8)); 
            
            CsvToBean csvToBean = new CsvToBean(); 
      
            // call the parse method of CsvToBean 
            // pass strategy, csvReader to parse method 
			List<Student> list = csvToBean.parse(strategy, csvReader); 
      
            // print details of Bean object 
            for (Student e : list) { 
                System.out.println(e);  
        } 
            
            return list;
    } 



}
