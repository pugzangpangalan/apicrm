package com.apicrm.helper;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apicrm.common.ApiCrmUtil;
import com.apicrm.entity.Tlc;
import com.apicrm.service.DoorKnockTeamService;
import com.apicrm.service.TlcProjectService;
import com.apicrm.service.TlcStatusService;

@Component
public class FileImportHelper {
	
	@Autowired
	private TlcProjectService tlcProjectService;

	@Autowired
	private TlcStatusService tlcStatusService;
	
	@Autowired
	private DoorKnockTeamService doorKnockTeamService;
	

	private static final String COMMA_DELIMITER = ","; 
	private static final String HEADER_TLC_ID = "TLC ID"; 
	private static final String HEADER_LOC = "Location / Address"; 
	private static final String HEADER_CUST_NAME = "End Customer Name"; 
	private static final String HEADER_CONT_NUM = "Contact Number"; 
	private static final String HEADER_SITE_ACC_INFO = "Site Access Information"; 
	private static final String HEADER_TLC_DATE = "Date";;
	private static final String HEADER_TLC_TIME = "Time"; 
	private static final String HEADER_SCOPE_DOC_SENT = "Scope Document Sent"; 
	private static final String HEADER_PROJ_NAME = "Project Name";
	private static final String HEADER_CHORUS_PORTAL_ORDER = "Chorus Portal Order"; 
	private static final String HEADER_ICMS_SERV_ORD = "ICMS Service Order";
	private static final String HEADER_DOOR_KNOCK_TEAM = "Door-knock Team";
	private static final String HEADER_STATUS = "Status";
	private static final String HEADER_SITE_VISIT_OUT = "Site Visit Outcome";
	private static final String HEADER_ADD_COMMENTS = "Additional Comments";
	private static final String HEADER_SCHED_ONCE = "Schedule Once";
	private static final String HEADER_SCOP_DOC= "Scoping Document";
	private static final String HEADER_DOOR_KNOCK_APP_DT = "Door-knock Appointment Date";
				
	private static final String[] HEADERS = { HEADER_TLC_ID, HEADER_LOC, HEADER_CUST_NAME, HEADER_CONT_NUM,
			HEADER_SITE_ACC_INFO, HEADER_TLC_DATE, HEADER_TLC_TIME, HEADER_SCOPE_DOC_SENT, HEADER_PROJ_NAME,
			HEADER_CHORUS_PORTAL_ORDER, HEADER_ICMS_SERV_ORD, HEADER_DOOR_KNOCK_TEAM, HEADER_STATUS,
			HEADER_SITE_VISIT_OUT, HEADER_ADD_COMMENTS, HEADER_SCHED_ONCE, HEADER_SCOP_DOC, HEADER_DOOR_KNOCK_APP_DT };
	

	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<Tlc> traverseTlcCsv(String path) {
		List<Tlc> tlcList = new ArrayList<Tlc>();
		
		int successRowCount = 0;
		int failedRowCount = 0;
		String line = "";
		String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

		try {

			BufferedReader br = new BufferedReader(new FileReader(path));
			boolean headerColumn = true;
			while ((line = br.readLine()) != null) {
				if(headerColumn){
					headerColumn = false;
					continue;
				}
				String[] col = line.split(cvsSplitBy, -1);
				if(col.length == 18) {
					Tlc tlc = new Tlc();
					tlc.setTlcId(removeUnecessaryChar(col[0]));
					tlc.setAddress(removeUnecessaryChar(col[1]));
					tlc.setCustomerName(removeUnecessaryChar(col[2]));
					tlc.setContactNumber(removeUnecessaryChar(col[3]));
					tlc.setSiteAccessInfo(removeUnecessaryChar(col[4]));
					
					if(!ApiCrmUtil.isNullOrEmpty(col[5])) {
						tlc.setDate(ApiCrmUtil.parseDate(removeUnecessaryChar(col[5])));
					}
					
					tlc.setTime(removeUnecessaryChar(col[6]));
					
					if(!ApiCrmUtil.isNullOrEmpty(col[7])) {
						tlc.setScopeDocSent(Integer.parseInt(removeUnecessaryChar(col[7])));
					}
					
					tlc.setProject(tlcProjectService.findByProjectName(removeUnecessaryChar(col[8])));
					tlc.setChorusPortalOrder(removeUnecessaryChar(col[9]));
					tlc.setIcmsServiceOrder(removeUnecessaryChar(col[10]));
					tlc.setTeam(doorKnockTeamService.findByTeamName(removeUnecessaryChar(col[11])));
					tlc.setStatus(tlcStatusService.findByStatusName(removeUnecessaryChar(col[12])));
					tlc.setSiteVisitOutcome(removeUnecessaryChar(col[13]));
					tlc.setComments(removeUnecessaryChar(col[14]));
					
					if(!ApiCrmUtil.isNullOrEmpty(col[15])) {
						tlc.setScheduleOnce(Integer.parseInt(removeUnecessaryChar(col[15])));
					}
					
					if(!ApiCrmUtil.isNullOrEmpty(col[16])) {
						tlc.setScopingDocCount(Integer.parseInt(removeUnecessaryChar(col[16])));
					}
					
					if(!ApiCrmUtil.isNullOrEmpty(col[17])) {
						tlc.setAppointmentDate(ApiCrmUtil.parseDate(removeUnecessaryChar(col[17])));
					}
					
					tlcList.add(tlc);
					successRowCount++;
				} else {
					// TODO: Implement logger
					failedRowCount++;
					System.out.println("Incorrect size for " + col[0]);
				}
			}
			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Logger
		System.out.println("No of successful row import:" + successRowCount);
		System.out.println("No of failed row import:" + failedRowCount);
		return tlcList;
	}
	
	private static String removeUnecessaryChar(String val) {
		if (val.startsWith("\"") && val.endsWith("\"")) {
			return val.substring(1, val.length() - 1);
		} 
		
		return val;
	}
	
	public String generateCsvFile(List<Tlc> campaign, String fileName) {
		FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName+".csv");
			
            
            fileWriter.append(Arrays.asList(HEADERS).stream().collect(Collectors.joining(",")));
            
            fileWriter.append("\n");
            

            for (Tlc tlc : campaign) {
                fileWriter.append(tlc.getTlcId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("\""+tlc.getAddress()+"\"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getCustomerName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getContactNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getSiteAccessInfo());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(formatDate(tlc.getDate()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getTime());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(tlc.getScopeDocSent()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getProject().getProjectName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getChorusPortalOrder());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getIcmsServiceOrder());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getTeam().getTeamName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getStatus().getStatusName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getSiteVisitOutcome());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(tlc.getComments());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(tlc.getScheduleOnce()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(tlc.getScopingDocCount()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(formatDate(tlc.getAppointmentDate()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("\n");
            }
			
			
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
			
            try {
                fileWriter.flush();
                fileWriter.close();
          
                
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
			
        }
		return fileName;
	}
	

	
	public void openFile(String fileName) {
		File file = new File(fileName);
        
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
            	desktop.open(file);
            }catch (IOException e) {
                System.out.println("Error opening file");
                e.printStackTrace();
            }
        }
	}
	
	private String formatDate(Date date) {
		if(date != null) {
			return formatter.format(date);
		}else {
			return "";
		}
	}
	

}
