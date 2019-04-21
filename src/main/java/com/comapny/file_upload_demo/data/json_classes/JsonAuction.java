package com.comapny.file_upload_demo.data.json_classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonAuction {

    @NotEmpty
    private String title;

    private String[] pictures;
}
