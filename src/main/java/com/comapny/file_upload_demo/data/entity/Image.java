package com.comapny.file_upload_demo.data.entity;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "auction")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filepath;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
