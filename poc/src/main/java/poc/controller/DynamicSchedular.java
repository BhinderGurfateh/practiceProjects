package poc.controller;


import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import poc.bean.CronScheduleBean;

@RestController
public class DynamicSchedular  implements Runnable{
	
    @Autowired
    private TaskScheduler taskScheduler;

	private ScheduledFuture scheduledFuture;

    private String cron="* */1 * * * ?"; 
      
    @PostMapping( value = "/resetCron", consumes = "application/json")
	public void setCronToRescheduleTask( @RequestBody CronScheduleBean cron) {
    	System.out.println("received cron:"+cron.getCron());
    	
		this.cron = cron.getCron();
		
		 if(taskScheduler== null){
			 System.out.println("*************taskschedular***********");  
			 this.taskScheduler = new ConcurrentTaskScheduler();
		    }

		 if(this.scheduledFuture != null) {
			 System.out.println("*************reschdule***********");
		        this.scheduledFuture.cancel(true);
		    }
		 System.out.println("nothing j");
		this.initialise();
	}

    @PostConstruct
    public void initialise() {
        System.out.println("schedule initized for cron: "+cron);
        this.scheduledFuture = this.taskScheduler.schedule(this, new CronTrigger(cron));
    }

    //Task to be executed 
	@Override
	public void run() {
        System.out.println("task to be done is going to be coded here");

		
	}
}

