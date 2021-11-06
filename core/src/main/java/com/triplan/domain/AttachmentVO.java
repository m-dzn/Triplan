package com.triplan.domain;

import com.triplan.enumclass.AboutTableType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AttachmentVO {

    // 식별자 필드
    private Integer attachmentId;

    // 필수 입력 필드 : Default 없는 NOT NULL 필드
    private AboutTableType aboutTableType;
    private Integer idInTableType;
    private String originFileName;
    private String serverFileName;
    private String fileExtension;
    private String uploadPath;

    // Default 값이 있는 NOT NULL 필드
    private LocalDateTime createdAt;

    // Nullable 필드
    private Long fileSize;

    // 외래키

    // 생성자
    public AttachmentVO(
            AboutTableType aboutTableType,
            Integer idInTableType,
            String originFileName,
            String serverFileName,
            String fileExtension,
            String uploadPath,
            Long fileSize) {
        this.aboutTableType = aboutTableType;
        this.idInTableType = idInTableType;
        this.originFileName = originFileName;
        this.serverFileName = serverFileName;
        this.fileExtension = fileExtension;
        this.uploadPath = uploadPath;
        this.fileSize = fileSize;
    }

}