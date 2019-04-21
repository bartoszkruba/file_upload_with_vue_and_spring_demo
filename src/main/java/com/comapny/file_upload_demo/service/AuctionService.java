package com.comapny.file_upload_demo.service;

import com.comapny.file_upload_demo.data.entity.Auction;
import com.comapny.file_upload_demo.data.entity.Image;
import com.comapny.file_upload_demo.data.json_classes.JsonAuction;
import com.comapny.file_upload_demo.data.repository.AuctionRepository;
import com.comapny.file_upload_demo.data.repository.ImageRepostiory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.beans.Transient;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;


@Service
public class AuctionService {

    private final AuctionRepository auctionRepository;

    private final ImageRepostiory imageRepostiory;

    private static String uploadDir = System.getProperty("user.dir") + "/target/classes/static/images";


    @Autowired
    public AuctionService(AuctionRepository auctionRepository, ImageRepostiory imageRepostiory) {
        this.auctionRepository = auctionRepository;
        this.imageRepostiory = imageRepostiory;
    }

    @PostConstruct
    void createDefaultFolderIfMissing() {
        File f = new File(uploadDir);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    @Transient
    public void postAuction(JsonAuction auction) {
        Auction DBauction = Auction.builder().title(auction.getTitle()).images(new HashSet<>()).build();
        auctionRepository.save(DBauction);

        Arrays.stream(auction.getPictures()).forEach(p -> {
            Image image = Image.builder().build();
            DBauction.addImage(image);
            image = imageRepostiory.save(image);
            String filePath = uploadDir + "/" + image.getId() + ".jpg";

            try {
                byte[] imageByte = Base64.decodeBase64(p.split(",")[1]);
                new FileOutputStream(filePath).write(imageByte);
                image.setFilepath("images/" + image.getId() + ".jpg");
            } catch (Exception e) {

            }

        });
        auctionRepository.save(DBauction);
    }
}
