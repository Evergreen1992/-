package qrcode;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class CreateQRCode {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		int width = 300 ;
		int height = 300 ;
		String format = "png";
		String content = "this is Evergreen from UESTC!熊枭雄学习嘻嘻嘻嘻嘻嘻";
		//定义二维码参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			BitMatrix bitmatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
			
			Path path = new File("d://text.png").toPath();
			MatrixToImageWriter.writeToPath(bitmatrix, format, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
