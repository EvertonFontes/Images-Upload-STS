package com.api.comercio.empresa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Company {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")  
	private String id;   
	
	private String fileName;
	private String fileType;
	private byte[] data; 
	
	private String nameCompany;  
	private String address;
	private String phone;
	private String fileDownloadUri;
	
	public Company() {}
	
	public Company(String fileName, String fileType, byte[] data, String nameCompany, String address, String phone) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.nameCompany = nameCompany;
		this.address = address;
		this.phone = phone;
	}
	
	public Company(String fileName, String fileType, byte[] data, String nameCompany, String address, String phone,String fileDownloadUri) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.nameCompany = nameCompany;
		this.address = address;
		this.phone = phone;
		this.fileDownloadUri = fileDownloadUri;  
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
