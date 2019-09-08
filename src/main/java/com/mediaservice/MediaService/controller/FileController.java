package com.mediaservice.MediaService.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediaservice.MediaService.service.FileService;

@RestController
@RequestMapping(value = "/file")
public class FileController {

	@Autowired
	private FileService fileService;

	@GetMapping("/{fileName}")
	public ResponseEntity<byte[]> download(@PathVariable String fileName) throws IOException {
		byte[] media = fileService.getFile(fileName);

		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

}
