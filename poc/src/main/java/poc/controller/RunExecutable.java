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
public class RunExecutable {


    @GetMapping(value = "/runCppExecutable", produces = "application/json")
    public ResponseEntity<String> listStudents(){
    	try {
//    		ProcessBuilder processBuilder = new ProcessBuilder();
//    		processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");
//    		Process process = processBuilder.start();
    	Process process = Runtime.getRuntime().exec("C:\\Users\\gurfateh.bhinder\\Desktop\\test\\test.exe", null, new File("C:\\Users\\gurfateh.bhinder\\Desktop\\test\\"));

    	System.out.println("passed path");
    	
		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}

		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			System.exit(0);
		} else {
			//abnormal...
			System.out.println("Something went wrong");
		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
        return new ResponseEntity("Successfully uploaded ", HttpStatus.OK);
    }



}
