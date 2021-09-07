package com.example.chipawaybackend.demo.models;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public class Link {

    public Link(ResponseEntity ok) {
    }

    public Link(String linkString) {
        this.linkString = linkString;
    }

    public String getLinkString() {
        return linkString;
    }

    public void setLinkString(String linkString) {
        this.linkString = linkString;
    }

    private String linkString;

}
