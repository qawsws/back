package practice2;

public class p5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a = 3;
//		 for (int i = 0; i < 4; i++) {
//			 String space = "";
//			 for(int j = 0; j <a; j++) {
//				 space += " ";
//			
//		 }
//			 for(int b=0; b<2*i+1; b++) {
//				 space +="*";
//			 }
//			 System.out.println(space);
//			 a--;
//		 }
//
//	}
//}
		int count=3;
		for(int i=0; i<7; i+=2) {
			for(int j=0; j<count; j++ ) {
				System.out.print(" ");
			}
			count--;
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	}