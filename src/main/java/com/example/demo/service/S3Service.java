package com.example.demo.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by loliveira on 02/12/18.
 */
@Service
@Slf4j
public class S3Service {

    @Autowired
    private AmazonS3 s3Client;

    @Value("${s3.bucket}")
    private String bucketName;

    public URI uploadFile(MultipartFile multipartFile) {
        try{
            String fileName = multipartFile.getOriginalFilename();
            InputStream is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();
            return uploadFile(fileName, is, contentType);
        }catch (IOException ex) {
            throw new RuntimeException("IO Error" + ex.getMessage());
        }
    }

    private URI uploadFile(String fileName, InputStream is, String contentType) {
        try{
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(contentType);
            s3Client.putObject(bucketName, fileName, is, objectMetadata);
            return s3Client.getUrl(bucketName, fileName).toURI();
        }catch (URISyntaxException ex){
            throw new RuntimeException("Error to convert URL to URI. " + ex.getMessage());
        }
    }
}
