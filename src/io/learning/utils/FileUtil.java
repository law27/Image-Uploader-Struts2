package io.learning.utils;

import org.apache.commons.io.FileUtils;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.UUID;

public class FileUtil {

    private static final String compressedPath = "/home/lawrance/images/compressed";
    private static final String uncompressedPath = "/home/lawrance/images/uncompressed";

    public static void saveCompressedFile(File file, String id, String format) throws IOException {
        BufferedImage image = ImageIO.read(file);
        String compressedImageName = id + "_compressed." + format;
        File compressedImage = new File(compressedPath, compressedImageName);
        OutputStream os = new FileOutputStream(compressedImage);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(format);
        ImageWriter writer = writers.next();

        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(os);
        writer.setOutput(imageOutputStream);

        ImageWriteParam imageWriteParam = writer.getDefaultWriteParam();

        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(0.5F);
        writer.write(null, new IIOImage(image, null, null), imageWriteParam);

        os.close();
        imageOutputStream.close();
        writer.dispose();
    }

    public static String saveFile(String fileName, File file) throws IOException {
        String[] formatExtract = fileName.split("\\.");
        String format = formatExtract[formatExtract.length - 1];
        String id = UUID.randomUUID().toString();
        String newName = id + "." + format;
        File destination = new File(uncompressedPath, newName);
        FileUtils.copyFile(file, destination);
        saveCompressedFile(file, id, format);
        return id;
    }
}
