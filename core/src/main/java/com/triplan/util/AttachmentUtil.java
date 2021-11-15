package com.triplan.util;

import com.triplan.domain.AttachmentVO;
import com.triplan.enumclass.AboutTableType;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AttachmentUtil {

    private static String PRE_FIX;

    @Value("${app.resources.location}")
    public void setPreFix(String PRE_FIX) {
        AttachmentUtil.PRE_FIX = PRE_FIX;
    }

    private static String FILE_PATH;



    public static List<AttachmentVO> getAttachments(List<MultipartFile> files, AboutTableType tableType, int id)
            throws IOException {

        FILE_PATH = PRE_FIX+tableType.getFilePath(); // 파일저장경로

        List<AttachmentVO> attachmentList = new ArrayList<>();

        // 리스트가 null이거나 비어 있으면 공집합 반환
        if (files == null || files.isEmpty())
            return attachmentList;

        for (MultipartFile file : files) {
                if (!file.getOriginalFilename().isEmpty() && !file.isEmpty()) {
                    AttachmentVO attachmentVO = getAttachment(file, tableType, id);
                    attachmentList.add(attachmentVO);
                }
        }

        return attachmentList;
    }




    public static AttachmentVO getAttachment(MultipartFile file, AboutTableType tableType, int id)
            throws IOException {

        // 확장자 위치 인덱스
        int extPosition = file.getOriginalFilename().indexOf(".");

        // 파일메타정보
        String originFileName = file.getOriginalFilename().substring(0,extPosition); // 원본파일이름
        String fileExtension = file.getOriginalFilename().substring(extPosition+1); // 확장자
        String serverFileName = UUID.randomUUID().toString(); // 서버에 저장될 파일이름
        String uploadPath = tableType.getFilePath(); // 저장될 폴더 경로
        Long fileSize = file.getSize(); // 파일 사이즈
        AboutTableType aboutTableType = tableType;
        Integer idInTableType = id;

        // 저장경로 + 파일 + 확장자 => 물리적으로 파일을 저장하기위함
        Path savePathServerNameExt = Paths.get(FILE_PATH + "/" +serverFileName + "." + fileExtension);

        // 저장할 디렉토리 생성
        File saveDir = new File(FILE_PATH);
        if (!saveDir.exists()) { // 저장할 디렉토리가 존재하지 않으면 생성
            saveDir.mkdirs();
        }

        // AttachVO에 파일데이터 저장
        AttachmentVO attachmentVO = new AttachmentVO(
                aboutTableType,
                idInTableType,
                originFileName,
                serverFileName,
                fileExtension,
                uploadPath,
                fileSize
        );

        // 파일을 물리적으로 저장
        try {
            Files.write(savePathServerNameExt, file.getBytes());
            return attachmentVO;

        } catch (IOException e) {

            try { // 파일 저장시 에러생기면 롤백
                Files.delete(savePathServerNameExt);
            } catch (IOException eDel) {
                throw new FileUploadException();
            }
            throw new FileUploadException();
        }
    }


    public static void deleteAttachments(List<AttachmentVO> attachmentList) {

        for(AttachmentVO attachmentVO : attachmentList) {
            deleteAttachment(attachmentVO);
        }

    }

    public static void deleteAttachment(AttachmentVO attachmentVO) {

        FILE_PATH = PRE_FIX + attachmentVO.getUploadPath() + "/" + attachmentVO.getServerFileName() + "." + attachmentVO.getFileExtension();

        File deleteFile = new File(FILE_PATH);
        if (deleteFile.exists()) {
            deleteFile.delete();
        }
    }

}
