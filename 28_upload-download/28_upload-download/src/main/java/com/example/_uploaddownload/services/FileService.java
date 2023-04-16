package com.example._uploaddownload.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
    String imgPath = desktopPath + File.separator + "filerepository";

    public String upload(MultipartFile file)throws IOException {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newName = UUID.randomUUID().toString();
        String fileFullName = newName+"."+fileExtension;

        File folder = new File(imgPath);
        if(!folder.exists()) throw new IOException("folder does not exist");
        if(!folder.isDirectory()) throw new IOException("folder is not a directory");

        File finalDestination = new File(imgPath+File.separator+fileFullName);

        if(finalDestination.exists()) throw new IOException("file already exists");

        file.transferTo(finalDestination);
        return fileFullName;
    }


    public byte[] download (String fileName) throws IOException {
        File fileToDownload = new File(imgPath+File.separator+fileName);
        if(!fileToDownload.exists())throw new IOException("file does not exist");
        return IOUtils.toByteArray(new FileInputStream(fileToDownload));
    }







}
