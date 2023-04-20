/**
 * 
 */
package com.ms.controller;

import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.entity.CitizenPlan;
import com.ms.request.SearchRequest;
import com.ms.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Sawant
 *
 */
@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response,Model model) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		
	  boolean status = 	reportService.exportPdf(response);
	  if(status == true) {
		  model.addAttribute("msg", "Pdf Report send to your email");
	  }
		
	}

	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response,Model model) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		
		boolean status = reportService.exportExcel(response);
		  if(status == true) {
			  model.addAttribute("msg", "Excel Report send to your email");
		  }
			
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}
	@PostMapping("/search")
	public String handlesearch(@ModelAttribute("search") SearchRequest search, Model model) {
		//System.out.println(request);
		List<CitizenPlan> plans = reportService.search(search);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}
	private void init(Model model) 
	{	
		model.addAttribute("names", reportService.getPlanName());
		model.addAttribute("status", reportService.getPlanStatus());
	}

}
