package poc.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestThread {

   @GetMapping(value = "/singleThreadTask", produces = "application/json")
   public static void testThread() throws InterruptedException {
      ExecutorService executor = Executors.newSingleThreadExecutor();

      try {
    	  
         executor.submit(new Task());
         executor.shutdown();
        
         
      } catch (Exception e) {
         System.err.println("tasks interrupted");
      } finally {
         executor.shutdownNow();
         System.out.println("shutdown finished");
      }
   }

   static class Task implements Runnable {
      
      public void run() {

         try {
        	 
            System.out.println("Running Service to be executed !"); 
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}