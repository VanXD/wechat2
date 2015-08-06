package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
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
	
	/**
	 * <p>利用接收到的InputStream保存文件，暂时未写完全
	 * @param InputStream
	 */
	public static void saveNewFile(InputStream in) {
		// 使用本地文件系统接受网络数据并存为新文件
		File file = new File("newFile.jpg");
		RandomAccessFile raf;
		try {
			file.createNewFile();
			raf = new RandomAccessFile(file, "rw");
			byte[] buf = new byte[2048];

			int num = in.read(buf);

			while (num != (-1)) {// 是否读完所有数据
				raf.write(buf, 0, num);// 将数据写往文件
				raf.skipBytes(num);// 顺序写文件字节
				num = in.read(buf);// 继续从网络中读取文件
			}
			in.close();
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
