/**
 * 
 */
package com.ms.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ms.entity.CitizenPlan;
import com.ms.repo.CitizenPlanRepo;
import com.ms.request.SearchRequest;
import com.ms.util.EmailUtils;
import com.ms.util.ExcelGenerator;
import com.ms.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Sawant
 *
 */
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired 
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getPlanName() {
	
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null != request.getStartDate() && !"".equals(request.getStartDate())) {
			entity.setPlanStartDate(request.getStartDate());
		}
		if(null != request.getEndDate() && !"".equals(request.getEndDate())) {
			entity.setPlanEndDate(request.getEndDate());
		}
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws IOException {
	 
	 File f =new File("plans.xls");
	 List<CitizenPlan> plans = 	repo.findAll();
	 excelGenerator.generate(response, plans, f);
	 
	 String subject ="Test Mail Subject";
	 String body = "<h2>Test mail body</2>";
	 String to = "manalisawant037@gmail.com";
	 
	 emailUtils.sendMail(subject, body, to, f);
	 f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f =new File("plans.pdf");
		 List<CitizenPlan> plans = 	repo.findAll();
		 pdfGenerator.generate(response, plans,f  );
		 String subject ="Test Mail Subject";
		 String body = "<h2>Test mail body</2>";
		 String to = "manalisawant037@gmail.com";
		 
		 emailUtils.sendMail(subject, body, to, f);
		 f.delete();
		return true;
	}

}
