package com.example.SellerWeb.service;

import jakarta.servlet.ServletContext;

public class DeleteFileService {
    private final ServletContext servletContext;

    public DeleteFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void handleDeleteFile(String fileName, String target) {

    }
}
