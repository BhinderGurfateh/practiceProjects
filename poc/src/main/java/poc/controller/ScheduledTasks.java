package poc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import poc.entity.FileInfo;
import poc.entity.Student;
import poc.service.FileService;
import poc.service.StudentService;

@Component
public class ScheduledTasks {
	
	
	@Autowired
    private FileService fileService;
	
	@Autowired
    private StudentService studentService;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate =100000)
    public void processAllPendingFiles() {        
    	log.info("The time is now {}", dateFormat.format(new Date()));
    	List<FileInfo> fileInfos =fileService.listAllPendingFiles();
    	
    	if(!fileInfos.isEmpty()){
    		for (FileInfo fileInfo : fileInfos) {
    			this.readAndLoadDataOfAFile(fileInfo.getFilePath());
    			fileService.updateFileStatus(fileInfo.get_id());
			}    		
    	}

    }
    
    public void readAndLoadDataOfAFile(String path) {        
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
        InputStream inputStream=null;
		
        try {
			inputStream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
       
        csvReader = new CSVReader(
        		new InputStreamReader(inputStream)); 
        
        CsvToBean csvToBean = new CsvToBean(); 
  
        // call the parse method of CsvToBean 
        // pass strategy, csvReader to parse method 
		List<Student> list = csvToBean.parse(strategy, csvReader); 
  
    	if(!list.isEmpty()) {
		studentService.saveAllStudents(list);
    	}
    	
    	
    }
    
}