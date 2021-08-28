package br.com.projetoxp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUploadService {
	
	public void uploadToLocal(MultipartFile file);

}
