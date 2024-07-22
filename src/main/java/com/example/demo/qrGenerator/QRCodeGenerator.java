package com.example.demo.qrGenerator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

@Service
public class QRCodeGenerator {

    public void generateQRCodeImage(String fleetNo, String filePathSource, String fileName) throws WriterException, IOException {

        // Creating a JSON string with fleetNo and redirecting URL
        Map<String, String> obj = new HashMap<>();
        obj.put("fleetNo", fleetNo);
        obj.put("redirectingUrl", "/form");
        String jsonText = JSONValue.toJSONString(obj);
        System.out.print(jsonText);
        // Encoding the JSON data
        String encodedData = URLEncoder.encode(jsonText, StandardCharsets.UTF_8.toString());
        String qrUrl = "https://mtcreact.onrender.com/formData?data=" + encodedData;

        // Constructing the file path for the QR code image
        String filePath = filePathSource + "/" + fileName + ".png";
        int width = 300;
        int height = 300;
        String additionalText = "Fleet No: " + fleetNo;

        try {
            // Generating QR code
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrUrl, BarcodeFormat.QR_CODE, width, height);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Adding additional text to the QR code image
            BufferedImage combined = addTextToImage(qrImage, additionalText, width, height);

            // Ensuring the directory exists
            File dir = new File(filePathSource);
            if (!dir.exists()) {
                dir.mkdirs(); // Create the directory if it does not exist
            }

            // Writing the final image to the specified file path
            Path path = FileSystems.getDefault().getPath(filePath);
            ImageIO.write(combined, "PNG", path.toFile());
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add text to the QR code image
    private BufferedImage addTextToImage(BufferedImage qrImage, String text, int qrWidth, int qrHeight) {
        int padding = 20;
        int fontSize = 16;
        int textHeight = fontSize + padding;

        // Creating a new image with space for text at the bottom
        BufferedImage newImage = new BufferedImage(qrWidth, qrHeight + textHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();

        // Set the background color to white for the text area
        g.setColor(Color.WHITE);
        g.fillRect(0, qrHeight, qrWidth, textHeight);

        // Draw the QR code on the new image
        g.drawImage(qrImage, 0, 0, null);

        // Set font and color for the text
        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        g.setColor(Color.BLACK);

        // Calculate the position of the text to center it horizontally
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(text);
        int x = (qrWidth - textWidth) / 2;
        int y = qrHeight + padding - 5; // Adjusting to place text nicely within the area

        // Draw the text
        g.drawString(text, x, y);
        g.dispose();

        return newImage;
    }
}


