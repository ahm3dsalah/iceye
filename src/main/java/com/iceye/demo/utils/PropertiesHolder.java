package com.iceye.demo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "customproperties")
@Component
public class PropertiesHolder {

    private String uri;
    private String baseDownloadUrl;
    private String fileRepository;

    public String getFileRepository() {
        return fileRepository;
    }

    public void setFileRepository(String fileRepository) {
        this.fileRepository = fileRepository;
    }

    public String getBaseDownloadUrl() {
        return baseDownloadUrl;
    }

    public void setBaseDownloadUrl(String baseDownloadUrl) {
        this.baseDownloadUrl = baseDownloadUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
