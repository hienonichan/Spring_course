package com.example.SellerWeb.service;

import java.io.File;

import org.springframework.stereotype.Service;

import jakarta.servlet.ServletContext;

@Service
public class DeleteFileService {
    private final ServletContext servletContext;

    public DeleteFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void handleDeleteFile(String fileName, String target) {
        String rootPath = this.servletContext.getRealPath("/resources/image");
        String finalPath = rootPath + File.separator + target + File.separator + fileName;
        File file = new File(finalPath);
        if (file.delete()) {
            System.out.println("deleled file at " + finalPath);
        } else {
            System.out.println("delete file at " + finalPath + " failed");
        }
    }
}
