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
	
	public List<Tlc> importCsv(String path) {
		List<Tlc> tlcList = new ArrayList<Tlc>();
		
		int successRowCount = 0;
		int failedRowCount = 0;
		String line = "";
		String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			while ((line = br.readLine()) != null) {

				String[] row = line.split(cvsSplitBy, -1);
				if(row.length == 17) {
					Tlc tlc = new Tlc();
					tlc.setTlcId(removeUnecessaryChar(row[0]));
					tlc.setAddress(removeUnecessaryChar(row[1]));
					tlc.setCustomerName(removeUnecessaryChar(row[2]));
					tlc.setContactNumber(removeUnecessaryChar(row[3]));
					tlc.setSiteAccessInfo(removeUnecessaryChar(row[4]));
					tlc.setDate(ApiCrmUtil.parseDate(removeUnecessaryChar(row[5])));
					tlc.setTime(removeUnecessaryChar(row[6]));
					tlc.setScopeDocSent(Integer.parseInt(removeUnecessaryChar(row[7])));
					tlc.setProject(tlcProjectService.findByProjectName(removeUnecessaryChar(row[8])));
					tlc.setChorusPortalOrder(removeUnecessaryChar(row[9]));
					tlc.setIcmsServiceOrder(removeUnecessaryChar(row[10]));
					tlc.setTeam(doorKnockTeamService.findByTeamName(removeUnecessaryChar(row[11])));
					tlc.setStatus(tlcStatusService.findByStatusId(removeUnecessaryChar(row[12])));
					tlc.setSiteVisitOutcome(removeUnecessaryChar(row[13]));
					tlc.setComments(removeUnecessaryChar(row[14]));
					tlc.setScheduleOnce(Integer.parseInt(removeUnecessaryChar(row[15])));
					tlc.setScopingDocCount(Integer.parseInt(removeUnecessaryChar(row[16])));
					tlc.setAppointmentDate(ApiCrmUtil.parseDate(removeUnecessaryChar(row[17])));
					tlcList.add(tlc);
					successRowCount++;
				} else {
					// TODO: Implement logger
					failedRowCount++;
					System.out.println("Incorrect size for " + row[0]);
				}
			}

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
