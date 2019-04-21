package com.comapny.file_upload_demo.controller;

import com.comapny.file_upload_demo.data.json_classes.JsonAuction;
import com.comapny.file_upload_demo.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping
    public String uploadAuction(@Validated @RequestBody JsonAuction auction) {
        System.out.println(auction);

        return "OK";
    }
}
