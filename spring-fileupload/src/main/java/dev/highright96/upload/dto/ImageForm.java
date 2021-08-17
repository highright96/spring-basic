package dev.highright96.upload.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageForm {

    private Long itemId;
    private String itemName;
    private MultipartFile image;
}
