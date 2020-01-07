package bit;

import java.nio.ByteBuffer;

public class ByteUtil {

	/** A table of hex digits */
	public static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	public static String toHexString(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(toHexString((byte)(num >> 24)));
		sb.append(toHexString((byte)(num >> 16)));
		sb.append(toHexString((byte)(num >> 8)));
		sb.append(toHexString((byte)(num)));
		return sb.toString();
	}

	private static String toHexString(byte aByte) {
		StringBuilder sb = new StringBuilder();
		sb.append(toHexChar(aByte >> 4));
		sb.append(toHexChar(aByte));
		return sb.toString();
	}

	public static char toHexChar(int nibble) {
		return hexDigit[nibble & 0x0F];
	}

	public static String toBinaryString(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 31; i >= 0; i--) {
			sb.append(getBit(num, i));
			if(i%8 == 0) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}
	
	public static String toBinaryString(float num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 31; i >= 0; i--) {
			sb.append(getBit((int) num, i));
			if(i%8 == 0) {
				sb.append(' ');
			}
		}
		return sb.toString();
	}
	
	public static String toBinaryStringUsingByte(float value) {
		byte[] byteArray = ByteBuffer.allocate(4).putFloat(value).array();
		StringBuilder sb = new StringBuilder();
		for(byte aByte:byteArray) {
			sb.append(toBinaryString(aByte)).append(' ');
		}
		return sb.toString();
	}
	
	public static String toBinaryString(byte aByte) {
		StringBuilder sb = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			sb.append(getBit(aByte, i));
		}
		return sb.toString();
	}

	private static char getBit(int num, int pos) {
		return (num & (1 << pos)) != 0 ? '1' : '0';
	}
	

	

	private static Byte[] toByteArray(int num) {
		Byte[] b = new Byte[4];
		b[0] = (byte) num;
		b[1] = (byte) (num >> 8);
		b[2] = (byte) (num >> 16);
		b[3] = (byte) (num >> 24);
		return b;
	}

}
