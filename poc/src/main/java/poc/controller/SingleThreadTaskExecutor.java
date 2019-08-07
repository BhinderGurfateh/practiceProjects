package poc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.dao.StudentRepository;

@RestController
public class SingleThreadTaskExecutor {

	@Autowired
	 private  StudentRepository studentRepository;
	
	private static ExecutorService executor = Executors.newSingleThreadExecutor();

	private static Integer counter=0;
    
   @GetMapping(value = "/singleThreadTask", produces = "application/json")
   public  void testThread() throws InterruptedException {
      try {

         executor.submit(new Task(studentRepository));
         //executor.shutdown();
    	 System.out.println("Task Added in queue"); 

         
      } catch (Exception e) {
         System.err.println("tasks interrupted");
      } finally {
//         executor.shutdownNow();
//         System.out.println("shutdown finished");
      }
   }

    class Task implements Runnable {     
		
	   private StudentRepository studentRepository;
	   
	   
   
      public Task(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public void run() {

         try {
        	 
            System.out.println("Running Service to be executed !"); 
            runExe();
            
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
  	public synchronized ResponseEntity<String> runExe(){
		try {
	          counter++;

	    	System.out.println("Nth RUN STARTED : "+counter); 

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
   

	
}