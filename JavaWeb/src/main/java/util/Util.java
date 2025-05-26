package util;

public class Util {
	// 判斷是否為是數字
	public static boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 判斷是否為是數字(正則表示式)
	public static boolean isNumber2(String data) {
		if (data == null)
			return false;
		return data.matches("\\d+");
	}

	// 判斷是否為是浮點數
	public static boolean isDouble(String data) {
		try {
			Double.parseDouble(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
