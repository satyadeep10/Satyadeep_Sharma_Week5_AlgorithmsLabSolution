package com.gl.week5.graded_assignment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MoneyDenomination 
{
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
	
	public void mergeSort(int[] valueArray, int left, int right)
	{
		if(left<right) 
		{
			int mid =(left+right)/2;
			
			mergeSort(valueArray,left,mid);
			mergeSort(valueArray,mid+1,right);
			
			merge(valueArray,left,mid,right);
		}
	}
	
	public void merge(int[] valueArray, int left, int mid, int right) 
	{
	    int length1=mid-left+1;
	    int length2=right-mid;
	    
	    int[] leftarray  = new int[length1];
	    int[] rightarray = new int[length2];
	    
	    for(int i=0;i<length1;i++) 
	    {
	    	leftarray[i]=valueArray[left+i];
	    }
	    
	    for(int i=0;i<length2;i++) 
	    {
	    	rightarray[i]=valueArray[mid+1+i];
	    }
	    
	    int i=0;
	    int j=0;
	    int k=left;
	    
	    while(i < length1 && j < length2)
	    { 
	    if(leftarray[i]<=rightarray[j]) 
	    {
	    	valueArray[k]=leftarray[i];
	    	i++;
	    }
	    else 
	    {
	    	valueArray[k]=rightarray[j];
	    	j++;
	    }
	     k++;
	    }
	    
	    while(i<length1) 
	    {
	    	valueArray[k]=leftarray[i];
	    	i++;
	    	k++;
	    }
	    while(j<length2) 
	    {
	    	valueArray[k]=rightarray[j];
	    	j++;
	    	k++;
	    }
	    
	    //return valueArray;
	}
	
	public static int denomninations(int[] valueArray, int[] count, int amount) 
	{
        for (int i=valueArray.length-1;i>-1;i--) 
        {
        	if (amount>=valueArray[i]) 
        	{
        		count[i]=amount/valueArray[i];
        		//System.out.println("Value of count: "+ count[i]);
        		amount=amount%valueArray[i];
        		//System.out.println("Value of amount:" + amount);
        	}
        }		
		return amount;
	}

	
	public static void main(String[] args) 
	{
		System.out.println("Enter the Size of currency denomination : ");
		sc = new Scanner(System.in);
		int size= sc.nextInt();
		System.out.println("Enter the currency denomination value :");
		
		MoneyDenomination md = new MoneyDenomination();
		int valueArray[]=md.getValues(size);
		
		System.out.println("Unsorted value array : " + Arrays.toString(valueArray));
		
		md.mergeSort(valueArray,0,valueArray.length-1);
		
		System.out.println("Sorted value array : " + Arrays.toString(valueArray));
		
		int count[]= new int[size];
		
		System.out.println("Enter the amount you want to pay");
		
		int amount=sc.nextInt();
		
		int remaining_amt = denomninations(valueArray,count,amount);
		
		System.out.println("Remaining amount value after deductions: "+remaining_amt +"\n");
		
		if(remaining_amt>0)
		{
			System.out.println("Amount can not be paid");
			return;
		}
		
		System.out.println("Payment approach in order to give minimum number of notes: "+"\n");
		
		System.out.println("Currency"+ "::" +"Count" +"\n");
		
		for(int j=valueArray.length-1;j>=0;j--) 
		{
			
			if(count[j]>0)
			{
			System.out.println(valueArray[j]+ "::"+ count[j]);
			}
		
		}
		
		
	}

	}
