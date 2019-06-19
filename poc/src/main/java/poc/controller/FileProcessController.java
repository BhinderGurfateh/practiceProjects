package poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import poc.entity.FileInfo;
import poc.entity.Student;
import poc.service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class FileProcessController {
	
	@Autowired
    private FileService fileService;
	
	
    public static final String uploadingDir = System.getProperty("user.dir") + "/uploadingDir/";
    //System.getProperty("jboss.server.data.dir") in case of server deployment
    //or use this String pathDir = request.getSession().getServletContext().getRealPath("/upload/" + DateUtils.currentTime());
   

    //@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles for multiple files at a time
    @PostMapping("/uploadCsv")
    public ResponseEntity<String>  uploadingPost( @RequestParam("file") MultipartFile uploadedFile) throws IOException {
      //      File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
        	long millis = System.currentTimeMillis();

            File dirFile = new File(uploadingDir);
            if (!dirFile.isDirectory()) {
                dirFile.mkdirs();
            }
            File file = new File(uploadingDir +millis+ uploadedFile.getOriginalFilename());

            
            uploadedFile.transferTo(file);
            System.out.println(file.getPath());
            
            FileInfo fileInfo=new FileInfo();
            fileInfo.setDateOfUpload(new Date());
            fileInfo.setFilePath(file.getPath());
            fileInfo.setIsDeleted(false);
            fileInfo.setIsProcessed(false);
            
            FileInfo savedFile=fileService.saveOrUpdate(fileInfo);
            return new ResponseEntity("Successfully uploaded , File reference Id: "+savedFile.get_id(), HttpStatus.OK);
    }
    

    @GetMapping(value = "/Files", produces = "application/json")
    public List<FileInfo> listFiles(){
    	
        return fileService.listAll();
    }

    @GetMapping(value = "/Files/{id}", produces = "text/plain" )
    public ResponseEntity<String> getAFileStatus(@PathVariable String id){
        FileInfo savedFile= fileService.getById(Long.valueOf(id));
        String status="";
        if(savedFile.getIsProcessed()) {
        	status="File successfully processed !";
        }else {
        	status="File yet to be processed !";
	
        }
    	return new ResponseEntity("File reference Id: "+savedFile.get_id()+". " +status, HttpStatus.OK);
    }
    

    
    
    
    }