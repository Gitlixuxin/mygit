package com.lxx.Jdbc;

import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		for(int i=0;i<10;i++) {
			
			int index=r.nextInt(5);
			System.out.println(index);
		}
	}

}
