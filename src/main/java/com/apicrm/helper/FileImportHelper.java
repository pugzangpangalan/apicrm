package com.apicrm.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

}
