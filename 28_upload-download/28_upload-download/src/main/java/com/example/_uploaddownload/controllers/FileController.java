package com.example._uploaddownload.controllers;

import com.example._uploaddownload.services.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public List<String> fileUpload(@RequestParam MultipartFile[] files) throws IOException {
       List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            String singleFile = fileService.upload(file);
            fileNames.add(singleFile);
        }
        return fileNames;
    }


    @GetMapping("/download")
    public @ResponseBody byte[]download(@RequestParam String fileName, HttpServletResponse response) throws IOException {
        String extension = FilenameUtils.getExtension(fileName);
        switch(extension){
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition","attachment; filename= \"" +fileName+"\"");
        return fileService.download(fileName);

    }




}
