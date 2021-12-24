import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class RSA{
		private BigInteger p,q,n,phi,e,d;
		private Random r;
		private int blength=1024;
		RSA(){
			r=new Random();
			p=BigInteger.probablePrime(blength,r);
			q=BigInteger.probablePrime(blength,r);
			n=p.multiply(q);
			phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
			e=BigInteger.probablePrime(blength/2,r);
			
			while(phi.gcd(e).compareTo(BigInteger.ONE)>0&& e.compareTo(phi)<0)
			{
				e.add(BigInteger.ONE);
			}
			d=e.modInverse(phi);
			
		}
		
		public RSA(BigInteger e,BigInteger d,BigInteger n)
		{
			this.e=e;
			this.n=n;
			this.d=d;
		}
		
		public static void main(String args[])throws Exception{
			RSA rsa=new RSA();
			
			DataInputStream in=new DataInputStream(System.in);
			System.out.println("Enter a text messase:");
			String textString=in.readLine();
			
			System.out.println("Encrypted message:" + textString);
			System.out.println("string in bytes"+ byteToString(textString.getBytes()));
			
			byte[] encrypted=rsa.encrypted(textString.getBytes());
			byte[] decrypted=rsa.decrypted(encrypted);
			
			System.out.println("Decrypted byte:"+byteToString(decrypted));
			System.out.println("Decrypted String:"+new String(decrypted));
		}
		
		private static String byteToString(byte[] encrypted){
			String text="";
			for(byte b:encrypted)
			{
				text=text+Byte.toString(b);
			}
			return text;
		}
		
		public byte[] encrypted(byte[] message){
			return new BigInteger(message).modPow(e,n).toByteArray();
		}
		
		public byte[] decrypted(byte[] message){
			return new BigInteger(message).modPow(d,n).toByteArray();
		}
	
}
		
