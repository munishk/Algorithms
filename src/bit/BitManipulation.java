package bit;

public class BitManipulation {
	
	public static void main(String[] args) {
		//int num = 5255;
		float num = -.625F;
		//System.out.println(ByteUtil.toHexString(num));
		/*System.out.println(ByteUtil.toBinaryString(num));
		System.out.println(ByteUtil.toBinaryString(num>>>8));
		System.out.println(ByteUtil.toBinaryString(1<<8));
		System.out.println(ByteUtil.toBinaryString((1<<8) -1));
		System.out.println(ByteUtil.toBinaryString(num & ((1<<8) -1)));
		*/
		
		
		//System.out.println(ByteUtil.toBinaryString(num));
	//	System.out.println(ByteUtil.toBinaryString(num & (-1 << 8)));
	//	System.out.println(ByteUtil.toBinaryString(num & ~(-1 >>> (31-8))));
	//	System.out.println(ByteUtil.toBinaryString( (-1 >>> (31-8))));
	//	System.out.println(ByteUtil.toBinaryString(~(-1 >>> (31-8))));
		
		//System.out.println(ByteUtil.toBinaryString(num<<<1));
		//System.out.println((int)Math.pow(2, 30));
		
		
		
		System.out.println(ByteUtil.toBinaryString(num));
		System.out.println(ByteUtil.toBinaryStringUsingByte(num));
		
	}

}
