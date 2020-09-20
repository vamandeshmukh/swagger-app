package com.imarticus.tutorial.management;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {

		ApplicationStatus status = getStatus();		
		if(status.isHealthy()) 			
			return Health.up()
		              .build();			
		else
			 return Health.down()
		              .withDetail(status.getMsg(), status.getErrorCode()).build();
			
		
	
	}

	public ApplicationStatus getStatus() {
		
		//Write logic here to check status of application
		//Database connection is checked by default , so test other external services
		
		int errorCode = -1;
		String message = "Error in Application";		
		return new ApplicationStatus(errorCode,message);
	}
}
