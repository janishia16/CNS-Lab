import java.io.*;
import java.util.*;
public class bucket{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of bucket:");
		int size=sc.nextInt();
		int a[]=new int[size];
		int prev;
	
		
		System.out.println("Enter the number of packet:");
		int p=sc.nextInt();
		
		System.out.println("Enter the packet:");
		for(int i=0;i<p;i++)
			a[i]=sc.nextInt();
		
		System.out.println("enter the output rate:");
		int out=sc.nextInt();
		for(int i=0;i<p;i++)
		{
			if(a[i]>size)
				System.out.println(a[i]+" causes overflow of the bucket");
			else if(a[i]<out)
			{
				System.out.println(a[i]+" packet transmitted");
			}
			else
			{
				if(a[i]==out)
					System.out.println(a[i]+" packet transmitted");
				else
				{
					while(a[i]!=0 && a[i]>out)
					{
						System.out.println(out+" packet  transmitted");
						a[i]=a[i]-out;
					}
					System.out.println(a[i]+"  packet  transmitted");
				}
			}
		}
	}
}
				
