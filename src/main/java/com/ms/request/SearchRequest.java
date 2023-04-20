/**
 * 
 */
package com.ms.request;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author Sawant
 *
 */
@Data
public class SearchRequest {

	private String planName;
	
	private String planStatus;
	 
	private String gender;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
}
