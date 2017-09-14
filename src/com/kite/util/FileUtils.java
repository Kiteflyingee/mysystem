package com.kite.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件工具类
 * 
 * @author KITE
 * 
 */
public class FileUtils {
	/**
	 * 生成日期形式文件名保证不重复，生成文件名方法（不带文件后缀名）
	 * 
	 * @return 文件名
	 */
	public static String generateFileName() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sf.format(new Date());
	}

	/**
	 * 获得文件名
	 * 
	 * @return 文件名(不带文件类型)
	 */
	public static String getFileName(String filename) {
		String[] names = filename.split("\\.");
		return names[0];
	}

	/**
	 * 获得文件类型
	 * 
	 * @return 文件类型
	 */
	public static String getFileType(String filename) {
		String[] names = filename.split("\\.");
		if (names.length < 2) {
			throw new RuntimeException("文件无类型");
		} else if (names.length > 2) {
			throw new RuntimeException("文件名错误,过多'.'");
		}
		return names[1];
	}

	/**
	 * 获取路径并且创建路径
	 * @param name 学生名
	 * @return pathl类似f:\images\name最后结尾不带\
	 */
	public static String getPath(String id) {
		String path = "D:\\images";
		if (id != null && !("".equals(id)))
			path = path + "\\" + id;
		File file = new File(path);
		file.mkdirs();
		return path;
	}
}
