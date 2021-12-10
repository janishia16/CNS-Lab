import java.net.*;
import java.io.*;
import java.util.Scanner;


public class bellman{
	public static final int MaxValue=999;
	private int noofvertices;
 	private int distance[];

	public static void main(String args[])
	{
		int noofvertices=0;
		System.out.println("Enter number of vertices:");
		
		Scanner sc=new Scanner(System.in);
		noofvertices=sc.nextInt();
		System.out.println("Enter the adjacency matric");
		
		int adj[][]=new int[noofvertices+1][noofvertices+1];
		
		for(int sn=1;sn<=noofvertices;sn++)
		{
			for(int dn=1;dn<=noofvertices;dn++)
			{
				adj[sn][dn]=sc.nextInt();
				if(sn==dn)
				{
					adj[sn][dn]=0;
					continue;
				}
				if(adj[sn][dn]==0)
				{
					adj[sn][dn]=MaxValue;
				}
			}
		}
		System.out.println("enter the source node:");
		int source=sc.nextInt();
		bellman bf=new bellman(noofvertices);
		bf.shortestpath(source,adj);
		sc.close();
	}
	public bellman(int noofvertices)
	{
		this.noofvertices=noofvertices;
		distance=new int[noofvertices+1];	
	}
	public void shortestpath(int source,int adj[][])
	{
		boolean a=true;
		for(int node=1;node<=noofvertices;node++)
		{
			distance[node]=MaxValue;
		}
		distance[source]=0;
		for(int node=1;node<=noofvertices;node++)
		{
			for(int sn=1;sn<=noofvertices;sn++)
			{
				for(int dn=1;dn<=noofvertices;dn++)
				{
					if(adj[sn][dn]!=MaxValue)
					{
						if(distance[dn]>distance[sn]+adj[sn][dn])
						{
							distance[dn]=distance[sn]+adj[sn][dn];
						}
					}
				}
			}
		}
		for(int sn=1;sn<=noofvertices;sn++)
		{
				for(int dn=1;dn<=noofvertices;dn++)
				{
					if(adj[sn][dn]!=MaxValue)
					{
						if(distance[dn]>distance[sn]+adj[sn][dn])
						{
							System.out.println("NEGATIVE EDGE CYCLE");
							 a=false;
						}
					}
				}
		}
		if(a){
			for(int vertice=1;vertice<=noofvertices;vertice++){
				System.out.println("distance from "+source+" to "+vertice+" is "+distance[vertice]);
			}
		}
	}
}
		
		
