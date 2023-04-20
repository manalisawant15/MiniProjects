/**
 * 
 */
package com.ms.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ms.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Sawant
 *
 */
@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File f) throws DocumentException, IOException {
		
		Document doc =new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		PdfWriter.getInstance(doc, new FileOutputStream(f));
		doc.open();
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
				
		Paragraph p= new Paragraph("Citizen Plans", fontTitle);
		p.setAlignment(p.ALIGN_CENTER);
		doc.add(p);
		
		PdfPTable table = new PdfPTable(6);
		
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		
	//	List<CitizenPlan> plans = repo.findAll();
		
		for(CitizenPlan plan : plans)
		{
			table.addCell(plan.getCitizenId().toString());
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			if(null != plan.getPlanStartDate()) {
			table.addCell(plan.getPlanStartDate().toString());
			}else {
				table.addCell("N/A");
			}
			if(null != plan.getPlanEndDate()) {
			table.addCell(plan.getPlanEndDate().toString());
			}
			else {
				table.addCell("N/A");	
			}
		}
		
		doc.add(table);
		doc.close();
	}

}
