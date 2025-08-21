package com.cachedInsights.briefly.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PdfUtil {

    public static String extractTextFromPdf(MultipartFile file) {
        PDDocument document = null;
        String fileContent = null;
        try {
            document = PDDocument.load(file.getInputStream());
            PDFTextStripper stripper = new PDFTextStripper();
            fileContent = stripper.getText(document);
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }
}
