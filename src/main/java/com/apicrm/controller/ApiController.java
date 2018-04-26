package com.apicrm.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.entity.DoorKnockTeam;
import com.apicrm.entity.Tlc;
import com.apicrm.entity.TlcProject;
import com.apicrm.entity.Token;
import com.apicrm.service.DoorKnockTeamService;
import com.apicrm.service.TlcProjectService;
import com.apicrm.service.TlcService;
import com.apicrm.service.TokenService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping(value = "/api/crm")
public class ApiController {
	
	@Autowired
	private TlcService tlcService;
	
	@Autowired
	private TlcProjectService tlcProjectService;
	
	@Autowired
	private DoorKnockTeamService doorKnockTeamService;
	
	@Autowired
	private TokenService tokenService;
	
	Gson gson = new Gson();

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendEmailChangeCode(HttpSession session) {

		return ResponseEntity.ok(gson.toJson("hello"));
	}

	@RequestMapping(value = "/extract", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> extractDataFromCsv(HttpSession session, @RequestBody String file) {
		JsonObject obj = new JsonParser().parse(file).getAsJsonObject();
		Path path = null;
		try {
			path = toExcel(obj.get("file").getAsString());
			String filePathName = path.getFileName().toAbsolutePath().toString();
			tlcService.saveTlcCsvFile(filePathName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(gson.toJson(path.getFileName().toAbsolutePath().toString()));
	}

	@RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TlcProject getProject(@PathVariable("projectId") String projectId) {
		return tlcProjectService.findProjectById(Long.valueOf(projectId));
	}

	@RequestMapping(value = "/team/{teamId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public DoorKnockTeam getTeam(@PathVariable("teamId") String teamId) {
		return doorKnockTeamService.findByTeamId(Long.valueOf(teamId));
	}

	@RequestMapping(value = "/tlc/{tlcId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Tlc getTlcByTlcId(@PathVariable("tlcId") String tlcId) {
		return tlcService.getTlcByTlcId(tlcId);
	}
	
	@RequestMapping(value = "/token/{secretKey}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Token getToken(@PathVariable("secretKey") String secretKey) {
        return tokenService.getToken(secretKey);
    }
	
	public Path toExcel(String value) throws IOException {
		return Files.write(Paths.get("temp.csv"), DatatypeConverter.parseBase64Binary(value));

	}

}
