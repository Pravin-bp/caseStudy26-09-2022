package com.gl.casestudy;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffMain {
	public static Double totalCalculation(Applicant applicant)
	{
		double total;
		if(applicant.getSubject1Mark()<50 || applicant.getSubject2Mark()<50  || applicant.getSubject3Mark()<50)
		{
			return 0.0;
		}
		else
		{
			total=applicant.getSubject1Mark()+applicant.getSubject2Mark()+applicant.getSubject3Mark();
			return total;
		}
	}
	public static Double percentageCalculation(Double total)
	{
		double percentage;
		percentage=(total/300)*100;
		return percentage;
	}


	public static void main(String[] args) {
		ArrayList<Applicant> arr=new ArrayList<Applicant>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of applicants:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		System.out.println("Enter applicant details:");
		String s=sc.next();
		String str[]=s.split(",");
		double mark1=Double.parseDouble(str[1]);
		double mark2=Double.parseDouble(str[2]);
		double mark3=Double.parseDouble(str[3]);
		Applicant a=new Applicant(str[0],mark1,mark2,mark3);
		double total=totalCalculation(a);
		double percentage=percentageCalculation(total);
		try
		{
		if(mark1<0 || mark1>100 || mark2<0 || mark2>100 || mark3<0 || mark3>100)
		{
			throw new MarksException("Subject marks were less than zero or greater than 100");
		}
		}
		catch(MarksException me)
		{
			System.out.println(me.getMessage());
		}
		a.setTotal(total);
		a.setPercentage(percentage);
		if(total!=0)
		{
			arr.add(a);
		}
		}
		for(Applicant f:arr)
		{
			System.out.println(f);
		}

	}

}
