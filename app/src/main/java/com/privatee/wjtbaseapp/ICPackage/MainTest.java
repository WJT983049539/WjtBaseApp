package com.privatee.wjtbaseapp.ICPackage;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		String test="123356";
		 String[] cds=test.split(",");
	        String currentCode="",nextCode="";
	        if(cds.length==2){
	            currentCode=cds[0];
	            nextCode=cds[1];
	        }else{
	            currentCode=cds[0];
	        }
	        System.out.println(currentCode);
	}

}
