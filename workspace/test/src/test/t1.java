package test;

import java.util.Scanner;

class Circle {
	private int radius;
	
	public Circle(int radius) { 
		this.radius = radius;
	}
	
	public double getArea() { 
		return radius*radius*3.14; 
	}
}

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Circle[] circle = new Circle[4];
		
		for(int i=0; i < 4; i++) {
			System.out.print("반지름 >>");
			int a = sc.nextInt();   
            circle[i] = new Circle(a); 
		}
		System.out.println("저장하였습니다...");
		
		 double sum = 0;
		 for (int i = 0; i < 4; i++) {
			 sum+= circle[i].getArea();
	}
		 System.out.println("원의 면적 전체 합은 " + sum);
}
}