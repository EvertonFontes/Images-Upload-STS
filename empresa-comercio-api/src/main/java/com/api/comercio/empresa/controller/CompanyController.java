package com.api.comercio.empresa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.comercio.empresa.model.Company;
import com.api.comercio.empresa.model.repository.CompanyRepository;
import com.api.comercio.empresa.model.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;  
	
	@Autowired
	private CompanyRepository companytRepository;  
	
	 @PostMapping
	    public Company uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("nameCompany") String nameCompany,
	    		@RequestParam("address") String address, @RequestParam("phone") String phone) {
		 

	        return  companyService.storeFile(file,nameCompany,address,phone);     
	    }

	 	/*
	    @PostMapping("/uploadMultipleFiles")
	    public List<CompanyResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return Arrays.asList(files)
	                .stream()
	                .map(file -> uploadFile(file))
	                .collect(Collectors.toList());   
	    }
	    */  
	 
	 @GetMapping("/{fileName:.+}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
		 	var databaseFile = companyService.getFile(fileName);

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))  
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
	                .body(new ByteArrayResource(databaseFile.getData()));  
	    }
	 
	 @GetMapping
	 public List<Company> getCompany(){
		 return companytRepository.findAll();        
	 }

}
