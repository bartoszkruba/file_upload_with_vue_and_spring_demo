package com.comapny.file_upload_demo.service;

import com.comapny.file_upload_demo.data.repository.AuctionRepository;
import com.comapny.file_upload_demo.data.repository.ImageRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    private final ImageRepostiory imageRepostiory;

    @Autowired
    public AuctionService(AuctionRepository auctionRepository, ImageRepostiory imageRepostiory) {
        this.auctionRepository = auctionRepository;
        this.imageRepostiory = imageRepostiory;
    }
}
