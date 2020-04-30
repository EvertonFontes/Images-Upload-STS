package com.api.comercio.empresa.model.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.comercio.empresa.model.Company;
import com.api.comercio.empresa.model.exception.CompanyException;
import com.api.comercio.empresa.model.exception.CompanyExceptionNotFound;
import com.api.comercio.empresa.model.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;  
	
	 public Company storeFile(MultipartFile file,String name_company,String address,String phone) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new CompanyException("Desculpe! o arquivo contem erros " + fileName);
	            }

	            Company dbFile = new Company(fileName, file.getContentType(), file.getBytes(),name_company,address,phone);  
	            
	            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/downloadFile/")
		                .path(dbFile.getFileName())
		                .toUriString();
	            
	            Company teste = new Company(dbFile.getFileName(), dbFile.getFileType(), dbFile.getData(),dbFile.getNameCompany(),
	            		dbFile.getAddress(),dbFile.getPhone(),fileDownloadUri); 

	            return companyRepository.save(teste);      
	            
	        } catch (IOException ex) {
	            throw new CompanyException("Arquivo não encontrado " + fileName + ". Por favor tente de novo!", ex);
	        }
	    }

	 	public Company getFile(String fileId) {
	        return companyRepository.findById(fileId)
	                .orElseThrow(() -> new CompanyExceptionNotFound("File not found with id " + fileId));      
	    }
}
