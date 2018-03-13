package com.iceye.demo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "resources")
@Component
public class ResourceReader {

    private String uri;
    private String baseDownloadUrl;

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
