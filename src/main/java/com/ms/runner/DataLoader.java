/**
 * 
 */
package com.ms.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ms.entity.CitizenPlan;
import com.ms.repo.CitizenPlanRepo;

/**
 * @author Sawant
 *
 */
@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private CitizenPlanRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
				repo.deleteAll();
				//Cash plan data --> Approved
				CitizenPlan c1 = new CitizenPlan();
				c1.setCitizenName("Pritam");
				c1.setGender("Male");
				c1.setPlanName("Cash");
				c1.setPlanStatus("Approved");
				c1.setPlanStartDate(LocalDate.now());
				c1.setPlanEndDate(LocalDate.now().plusMonths(6));
				c1.setBenefitAmt(5000.00);
				
				//Cash plan Data --> Denied
				
				CitizenPlan c2 = new CitizenPlan();
				c2.setCitizenName("Smith");
				c2.setGender("Male");
				c2.setPlanName("Cash");
				c2.setPlanStatus("Denied");
				c1.setDenialReason("Rental Income");
				
				CitizenPlan c3 = new CitizenPlan();
				c3.setCitizenName("Sanem");
				c3.setGender("Female");
				c3.setPlanName("Cash");
				c3.setPlanStatus("Terminated");
				c3.setPlanStartDate(LocalDate.now().minusMonths(4));
				c3.setPlanEndDate(LocalDate.now().plusMonths(2));
				c3.setBenefitAmt(5000.00);
				c3.setTerminatedDate(LocalDate.now());
				c3.setTerminationReson("Employed");
				
						//Food plan data --> Approved
						CitizenPlan c4 = new CitizenPlan();
						c4.setCitizenName("Karan");
						c4.setGender("Male");
						c4.setPlanName("Food");
						c4.setPlanStatus("Approved");
						c4.setPlanStartDate(LocalDate.now());
						c4.setPlanEndDate(LocalDate.now().plusMonths(6));
						c4.setBenefitAmt(4000.00);
						
						//Food plan Data --> Denied
						
						CitizenPlan c5 = new CitizenPlan();
						c5.setCitizenName("Nia");
						c5.setGender("Female");
						c5.setPlanName("Food");
						c5.setPlanStatus("Denied");
						c5.setDenialReason("Property Income");
						
						//Food plan Data --> Terminated
						CitizenPlan c6 = new CitizenPlan();
						c6.setCitizenName("Sid");
						c6.setGender("Male");
						c6.setPlanName("Food");
						c6.setPlanStatus("Terminated");
						c6.setPlanStartDate(LocalDate.now().minusMonths(4));
						c6.setPlanEndDate(LocalDate.now().plusMonths(2));
						c6.setBenefitAmt(5000.00);
						c6.setTerminatedDate(LocalDate.now());
						c6.setTerminationReson("Employed");
			
						
						//Medical plan data --> Approved
						CitizenPlan c7 = new CitizenPlan();
						c7.setCitizenName("Krishna");
						c7.setGender("Male");
						c7.setPlanName("Medical");
						c7.setPlanStatus("Approved");
						c7.setPlanStartDate(LocalDate.now());
						c7.setPlanEndDate(LocalDate.now().plusMonths(6));
						c7.setBenefitAmt(4000.00);
						
						//Medical plan Data --> Denied
						
						CitizenPlan c8 = new CitizenPlan();
						c8.setCitizenName("Inshwari");
						c8.setGender("Female");
						c8.setPlanName("Medical");
						c8.setPlanStatus("Denied");
						c8.setDenialReason("Property Income");
						
						//Medical plan Data --> Terminated
						CitizenPlan c9 = new CitizenPlan();
						c9.setCitizenName("Aaryak");
						c9.setGender("Male");
						c9.setPlanName("Medical");
						c9.setPlanStatus("Terminated");
						c9.setPlanStartDate(LocalDate.now().minusMonths(4));
						c9.setPlanEndDate(LocalDate.now().plusMonths(2));
						c9.setBenefitAmt(5000.00);
						c9.setTerminatedDate(LocalDate.now());
						c9.setTerminationReson("Gov Plan");
						
						//Medical plan data --> Approved
						CitizenPlan c10 = new CitizenPlan();
						c10.setCitizenName("Akshay");
						c10.setGender("Male");
						c10.setPlanName("Employement");
						c10.setPlanStatus("Approved");
						c10.setPlanStartDate(LocalDate.now());
						c10.setPlanEndDate(LocalDate.now().plusMonths(6));
						c10.setBenefitAmt(4000.00);
						
						//Medical plan Data --> Denied
						
						CitizenPlan c11 = new CitizenPlan();
						c11.setCitizenName("Navya");
						c11.setGender("Female");
						c11.setPlanName("Employement");
						c11.setPlanStatus("Denied");
						c11.setDenialReason("Property Income");
						
						//Medical plan Data --> Terminated
						CitizenPlan c12 = new CitizenPlan();
						c12.setCitizenName("Manali");
						c12.setGender("Female");
						c12.setPlanName("Employement");
						c12.setPlanStatus("Terminated");
						c12.setPlanStartDate(LocalDate.now().minusMonths(4));
						c12.setPlanEndDate(LocalDate.now().plusMonths(2));
						c12.setBenefitAmt(5000.00);
						c12.setTerminatedDate(LocalDate.now());
						c12.setTerminationReson("Gov Plan");
						
						List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
						repo.saveAll(list);

	}

}
