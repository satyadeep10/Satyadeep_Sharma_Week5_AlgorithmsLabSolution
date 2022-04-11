package com.gl.week5.graded_assignment;

import java.util.Scanner;

public class PayMoney {
	
	
	
	private static Scanner sc;

	public int[] getValues(int size) 
	{
		int[] array=new int[size];
		for (int i=0;i<size;i++) 
		{
			int a=sc.nextInt();
		    array[i]=a;
		}
		return array;
	}
	
	public void printArray(int[] array) 
	{
		System.out.print("Transaction Value array: ");
		
		for(int j=0;j<array.length;j++) 
		{
			System.out.print(array[j]+" ");
		}
		
		System.out.println("\n");
	}
	
	public int[] getTargetValues(int t) 
	{
		int[] tar=new int[t];
		
		for(int j=0;j<t;j++) 
		{
			tar[j]=sc.nextInt();
		}
		
		return tar;	
	}
	
	public void valueFinder(int[] valueArray, int[] target_values) 
	{	
		for(int j=0;j<target_values.length;j++) 
		{
			int sum=0;
			
			for (int i=0;i<valueArray.length;i++) 
			{
				sum =sum+valueArray[i];
				//System.out.println("Target value is:  "+ target_values[j] +" and sum is " + sum);
				if(sum >= target_values[j])
				{
					System.out.println("Target "+ target_values[j] + " is achieved after "+ (i+1) + " transaction");
					break;
				} 
				else if (sum < target_values[j] && i==(valueArray.length-1))
				{
					System.out.println("Target "+ target_values[j]+ " is not achieved ");
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Enter the Size of transaction array: ");
		sc = new Scanner(System.in);
		int size= sc.nextInt();
		System.out.println("Enter the Values of transaction array: ");
		
		PayMoney pm = new PayMoney();
		int valueArray[]=pm.getValues(size);
		
		pm.printArray(valueArray);
		
		System.out.println("Enter the total no of targets that need to be achieved: ");
		int target=sc.nextInt();
		
		System.out.println("Enter Target Values: ");
		
		int[] target_values=pm.getTargetValues(target);
		System.out.print("Target Value: ");
		for (int i=0;i<target;i++) 
		{
			System.out.print(target_values[i]+" ");
		}
		System.out.println("\n");
	
		System.out.println("*****Logic triggered to find target achieve logic*****");
		System.out.println("\n");
		
		pm.valueFinder(valueArray,target_values);
	
	}

}
