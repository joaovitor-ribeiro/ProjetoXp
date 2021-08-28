package br.com.projetoxp.service.implement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetoxp.service.FileUploadService;

@Service
public class FileUploadServiceImplement implements FileUploadService{
	
	private String uploadFolderPath = "C:\\Users\\joaos\\Downloads\\projetoxp\\projetoxpFront\\src\\assets\\";
	
	@Override
	public void uploadToLocal(MultipartFile file) {
		
		try {
			byte[] data = file.getBytes();
			Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
			Files.write(path, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
