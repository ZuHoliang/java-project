package cart.util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashUtil {
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	
	public static String generatSalt() throws Exception {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);	
		return bytesToHex(salt);
	}
	
	public static String hashPasseord(String password, String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest((password+salt).getBytes());
		return bytesToHex(hashBytes);
	}

}
