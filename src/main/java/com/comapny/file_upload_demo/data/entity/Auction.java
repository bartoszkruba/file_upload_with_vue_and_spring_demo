package com.comapny.file_upload_demo.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "images")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Image> images;

    public void addImage(Image image) {
        if (this.images == null) {
            this.images = new HashSet<>();
        }
        this.images.add(image);
        image.setAuction(this);
    }

}
