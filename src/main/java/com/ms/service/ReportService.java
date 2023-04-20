/**
 * 
 */
package com.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.entity.CitizenPlan;
import com.ms.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Sawant
 *
 */
@Service
public interface ReportService {

	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
}
