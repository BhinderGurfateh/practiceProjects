package poc.main;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import poc.controller.DynamicSchedular;

@SpringBootApplication
@ComponentScan(basePackages = {"poc.controller","poc.dao","poc.service"})
@EntityScan("poc.entity")
@EnableJpaRepositories("poc.dao")
@EnableScheduling
@EnableAsync
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler() {
	    return new ConcurrentTaskScheduler(); //single threaded by default
	}
	
	 /* @Bean(name = "dynamicSchedular", initMethod = "beanInit")
	    public DynamicSchedular getDynamicSchedular(){
	        return new DynamicSchedular();
	    }*/
	
	/*@Bean
    public Executor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
   }*/
}

