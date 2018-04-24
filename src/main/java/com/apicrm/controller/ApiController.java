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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apicrm.service.TlcService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/api/crm")
public class ApiController {
	
	@Autowired
	private TlcService tlcService;
	
	Gson gson = new Gson();

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> sendEmailChangeCode(HttpSession session) {

		return ResponseEntity.ok(gson.toJson("hello"));
	}

	@RequestMapping(value = "/extract", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> extractDataFromCsv(HttpSession session, @RequestBody File file) {
		Path path = null;
		try {
			path = toExcel(file.getFile());
			String filePathName = path.getFileName().toAbsolutePath().toString();
			tlcService.saveTlcCsvFile(filePathName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(gson.toJson(path.getFileName().toAbsolutePath().toString()));
	}

	public Path toExcel(String value) throws IOException {
		return Files.write(Paths.get("temp.csv"), DatatypeConverter.parseBase64Binary(value));

	}

}

class File {

	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
