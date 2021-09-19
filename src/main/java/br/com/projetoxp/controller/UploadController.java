package br.com.projetoxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetoxp.service.FileUploadService;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class UploadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping(method = RequestMethod.POST, path = "{local}")
	public void uploadLocal(@PathVariable String local, @RequestParam("file")MultipartFile multipartFile) {
		fileUploadService.uploadToLocal(multipartFile, local);
	}

}
