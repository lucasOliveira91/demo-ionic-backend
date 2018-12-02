package com.example.demo.service;

import com.example.demo.exception.FileException;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by loliveira on 02/12/18.
 */
@Service
public class ImageService {

    @Value("${img.profile.size}")
    private int size;

    public BufferedImage getJpgImageFromFile (MultipartFile multipartFile) {
        String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        if(!ext.equals("jpg") && !"png".equals(ext)) {
            throw new FileException("Only images jpg and png are allow");
        }

        try {
            BufferedImage img = ImageIO.read(multipartFile.getInputStream());

            if("png".equals(ext)) {
                img = pngToJpg(img);
            }

            return img;
        } catch (IOException e) {
            throw new FileException("Error to read the file.");
        }
    }

    public BufferedImage pngToJpg(BufferedImage img) {
        BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        jpgImage.createGraphics()
                .drawImage(img, 0, 0, Color.WHITE, null); // To fill backgroud png to white.
        return jpgImage;
    }

    public InputStream getInputStream(BufferedImage bufferedImage, String extension) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, extension, os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            throw new FileException("Error to read file.");
        }
    }

    public BufferedImage cropSquare(BufferedImage sourceImg) {
        int min = sourceImg.getHeight() <= sourceImg.getWidth() ? sourceImg.getHeight() : sourceImg.getWidth();
        return Scalr.crop(sourceImg,
                (sourceImg.getHeight() / 2) - (min / 2),
                (sourceImg.getHeight() / 2) - (min / 2),
                min,
                min);
    }

    public BufferedImage resize(BufferedImage sourceImg, int size) {
        return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, size);
    }


    public BufferedImage cropAndResize(BufferedImage sourceImg){
        BufferedImage bufferedImage = cropSquare(sourceImg);
        return resize(bufferedImage, size);
    }
}
