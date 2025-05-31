package case04;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class SimplePasswordHash {
	
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
	
	
	
	public static void main(String[] args) throws Exception {
		String salt = generatSalt();
		String password = "1234";
		String hash = hashPasseord(password, salt);
		System.out.printf("password: %s hash: %s %n", password, hash);
		System.out.printf("salt: %s hash: %d %n", salt, salt.length());
	}

}
