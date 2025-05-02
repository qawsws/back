package practice2;

public class p6 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int num = 7;
//		 for (int i = 0; i < 4; i++) {
//			 String space = "";
//			 for(int j = 0; j <= i; j++) {
//				 space += " ";
//			
//			 }
//			 System.out.print(space);
//
//				String space1 = "";
//				for (int b = 0; b < num; b++) {
//	                space1 += "*";
//	            }
//				num-=2;
//				System.out.println(space1);
//	}
//}
//	}
		int count=0;
		for(int i=7; i>0; i-=2) {
			for(int j=0; j<count; j++ ) {
				System.out.print(" ");
			}
			count++;
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	}

