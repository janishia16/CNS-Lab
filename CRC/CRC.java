import java.util.Scanner;
import java.io.*;
import java.util.*;
public class CRC
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the message in binary form:");
		String data=sc.nextLine();
		
		System.out.println("enter the generator pattern:");
		String gen=sc.nextLine();
		
		String code=data;
		while(code.length()<data.length()+(gen.length()-1))
		{
			code+='0';
		}
		code=data+div(code,gen);
		System.out.println("code trasmitted is"+code);
		String rem=div(code,gen);
		
		if(Integer.parseInt(rem)==0)
		{
			System.out.println("reminder "+rem);
			System.out.println("No error");
		}
		else
		{
			System.out.println("reminder "+rem);
			System.out.println("Error in data received");
		}
		
		System.out.println("enter the position of the bit to be alter:");
		int pos=sc.nextInt();
		
		if(code.charAt(pos)=='0')
		{
			code=code.substring(0,pos)+'1'+code.substring(pos+1);
		}
		else
		{
			code=code.substring(0,pos)+'0'+code.substring(pos+1);
		}
		
		rem=div(code,gen);
		if(Integer.parseInt(rem)=='0')
		{
			System.out.println("reminder "+rem);
			System.out.println("Code received is "+code);
			System.out.println("No error detected");
		}
			
		else{
			System.out.println("reminder "+rem);
			System.out.println("Code received is "+code);
			System.out.println("ERROR DETECTED");
		}
	}
	 static String div(String str1,String str2)
	{
		int pointer=str2.length();
		String result=str1.substring(0,pointer);
		String reminder="";
		for(int i=0;i<pointer;i++)
		{
			if(result.charAt(i)==str2.charAt(i))
				reminder+='0';
			else
				reminder+='1';
		}
		while(pointer<str1.length())
		{
			if(reminder.charAt(0)=='0')
			{
				reminder=reminder.substring(1,reminder.length());
				reminder=reminder+String.valueOf(str1.charAt(pointer));
				pointer++;
			}
			result=reminder;
			reminder="";
			
			if(result.charAt(0)!='0')
			{
				for(int i=0;i<str2.length();i++)
				{
					if(result.charAt(i)==str2.charAt(i))
						reminder+='0';
					else
						reminder+='1';
				}
			}
			else 
				reminder=result;
		}
		
			
		return reminder.substring(1,reminder.length());
	}
}

				
