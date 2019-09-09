package com.mediaservice.MediaService.service;

import java.io.IOException;

public interface FileService {

	public byte[] getFile(String fileName) throws IOException;
}
