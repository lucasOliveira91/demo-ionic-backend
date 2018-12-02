package com.example.demo.service;

import com.example.demo.exception.FileException;
import org.apache.commons.io.FilenameUtils;
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
}
