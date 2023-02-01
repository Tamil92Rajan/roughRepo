package com.ipt.octbatch.IPT_Project_Zoho;

public class Exception_Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			throw new Zoho_Exception();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("catch block executed because of excception occured in try block");
		}
	}

}
