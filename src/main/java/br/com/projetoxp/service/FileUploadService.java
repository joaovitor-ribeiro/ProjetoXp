package br.com.projetoxp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private String uploadFolderPath = "C:\\Users\\vitor\\Documents\\bla bla\\projetoxp\\projetoxpFront\\src\\assets\\";
	
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
