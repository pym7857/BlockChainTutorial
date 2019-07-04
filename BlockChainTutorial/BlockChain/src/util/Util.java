package util;

import java.security.MessageDigest;

public class Util {
	/*
	 * String.substring(start) //���ڿ�  start��ġ���� ������ ���ڿ� �ڸ���
	   String.substring(start,end) //���ڿ�  start��ġ ���� end������ ���ڿ� ����
	 */
	public static String getHash(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(input.getBytes());
			byte bytes[] = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				result.append(
					Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1)
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
}
