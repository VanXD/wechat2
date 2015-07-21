package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.ienum.MessageTypeEnum;

public class FileUtil {
	private final static String regexFileSuffix = "\\.(\\w+)$";

	// bmp/png/jpeg/jpg/gif
	// mp3/wma/wav/amr
	// avi/mpeg4/mp4/wmv/
	public static String getFileType(String suffix) {
		switch (suffix) {
		case "bmp":
		case "png":
		case "jpeg":
		case "jpg":
		case "gif":
			return MessageTypeEnum.IMAGE.toString();
		case "mp3":
		case "wma":
		case "wav":
		case "amr":
			return MessageTypeEnum.VOICE.toString();
		case "avi":
		case "mpeg4":
		case "mp4":
		case "wmv":
			return MessageTypeEnum.VIDEO.toString();
		default:
			return null;
		}
	}

	public static String getFileSuffix(String fileName) {
		Pattern pattern = Pattern.compile(regexFileSuffix);
		Matcher matcher = pattern.matcher(fileName);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

}
