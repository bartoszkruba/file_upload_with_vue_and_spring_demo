package com.comapny.file_upload_demo.data.repository;

import com.comapny.file_upload_demo.data.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepostiory extends CrudRepository<Image, Long> {
}
