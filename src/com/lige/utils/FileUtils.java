package com.lige.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtils {

	/**
	 * 读取指定文件的内容，返回总行数
	 * 
	 * @param file
	 * @return
	 */
	public static int getLineConnt(File file) {

		if (!file.isFile()) {
			throw new RuntimeException("文件对象无效");
		}
		try {
			BufferedReader buf = new BufferedReader(new FileReader(file));
			// 计算行数
			int count = 0;
			while (buf.readLine() != null) {
				count++;
			}
			
			buf.close();
			return count;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
