package com.example.demo.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PojoClass.QrCodePojo;
import com.example.demo.qrGenerator.QRCodeGenerator;
import com.google.zxing.WriterException;

@RestController
@RequestMapping("/qrGenerator")
public class QrGeneratorController {
	
	@Autowired
	private QRCodeGenerator qrCodeGeneratorObj;
	
	@PostMapping("/getQr")
	private void getQrCode(@RequestBody QrCodePojo qrObj)
	{
		System.out.println("00000000000000000000000");
		System.out.println(qrObj);
		try {
			qrCodeGeneratorObj.generateQRCodeImage(qrObj.getVehicleFleetNumber(),qrObj.getFilePath() , qrObj.getFileName());
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
