package com.mediaservice.MediaService.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mediaservice.MediaService.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Value("${files.path}")
	private String filesPath;

	@Override
	public byte[] getFile(String fileName) throws IOException {

		File file = new File(String.format("%s%s", filesPath, fileName));
		byte[] media = Files.readAllBytes(file.toPath());

		return media;
	}
}
