package com.example.SellerWeb.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // Lấy rootpath đến folder image
        String rootPath = this.servletContext.getRealPath("/resources/image");
        String finalPath = "";
        String fileName = "";
        try {
            // Lấy file data dưới dạng byte
            byte[] bytes = file.getBytes();
            // get fileName
            fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            // get file's path
            finalPath = rootPath + File.separator + targetFolder + File.separator + fileName;
            // create file object
            File serverFile = new File(finalPath);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            System.out.println("error in IO with file");
            e.printStackTrace();
        }
        return fileName;
    }
}
