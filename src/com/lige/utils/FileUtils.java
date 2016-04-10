package com.lige.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtils {

	/**
	 * ��ȡָ���ļ������ݣ�����������
	 * 
	 * @param file
	 * @return
	 */
	public static int getLineConnt(File file) {

		if (!file.isFile()) {
			throw new RuntimeException("�ļ�������Ч");
		}
		try {
			BufferedReader buf = new BufferedReader(new FileReader(file));
			// ��������
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
