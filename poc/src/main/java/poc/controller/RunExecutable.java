package poc.controller;

import org.apache.tomcat.jni.Time;
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

import poc.dao.StudentRepository;
import poc.entity.Student;
import poc.service.StudentService;

import java.util.List;

@RestController
public class RunExecutable {

	@Autowired
    private StudentRepository studentRepository;


	@GetMapping(value = "/runCppExecutable", produces = "application/json")
	public  ResponseEntity<String> listStudents(){
		try {
			System.out.print("Entry time: " +new java.util.Date());

			//	creating 10 tables with 20 column each.	
			studentRepository.createStudentTableA();
			studentRepository.createStudentTableB();
			studentRepository.createStudentTableC();
			studentRepository.createStudentTableD();
			studentRepository.createStudentTableE();
			studentRepository.createStudentTableF();
			studentRepository.createStudentTableG();
			studentRepository.createStudentTableH();
			studentRepository.createStudentTableI();
			studentRepository.createStudentTableJ();
			studentRepository.createStudentTableK();
			studentRepository.createStudentTableL();
			studentRepository.createStudentTableM();
			studentRepository.createStudentTableN();
			studentRepository.createStudentTableO();
			studentRepository.createStudentTableP();
			studentRepository.createStudentTableQ();
			studentRepository.createStudentTableR();
			studentRepository.createStudentTableS();
			studentRepository.createStudentTableT();



			Process process = Runtime.getRuntime().exec("C:\\Users\\gurfateh.bhinder\\Desktop\\test\\test.exe", null, new File("C:\\Users\\gurfateh.bhinder\\Desktop\\test\\"));

			System.out.println("\nRead the executable file ");

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			/*
			 * int exitVal = process.waitFor(); if (exitVal == 0) {
			 * System.out.println("Success!"); System.out.println(output); System.exit(0); }
			 * else { //abnormal... System.out.println("Something went wrong"); }
			 */
			System.out.println("Success!"); 
			System.out.println(output);

			if(process.isAlive()) {
				process.destroy();
			}
			
			//Droping 10 tables with 20 column each.	
			studentRepository.dropTableA();
			studentRepository.dropTableB();
			studentRepository.dropTableC();
			studentRepository.dropTableD();
			studentRepository.dropTableE();
			studentRepository.dropTableF();
			studentRepository.dropTableG();
			studentRepository.dropTableH();
			studentRepository.dropTableI();
			studentRepository.dropTableJ();
			studentRepository.dropTableK();
			studentRepository.dropTableL();
			studentRepository.dropTableM();
			studentRepository.dropTableN();
			studentRepository.dropTableO();
			studentRepository.dropTableP();
			studentRepository.dropTableQ();
			studentRepository.dropTableR();			
			studentRepository.dropTableS();
			studentRepository.dropTableT();
			
			
			System.out.print("Exit time: " +new java.util.Date());

		} catch (IOException e) {
			e.printStackTrace();
		} /*
		 * catch (InterruptedException e) { e.printStackTrace(); }
		 */

		return new ResponseEntity("Success", HttpStatus.OK);
	}



}
