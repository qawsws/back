package practice2;

public class p4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 for (int i = 5; i >= 1; i--) {
//	            String star = "";
//	            for (int j = 0; j < i; j++) {
//	                star += "*";
//	            }
//	            System.out.println(star);
//	}
//	}
//}
		int count = 5;
		 for (int i = 0; i <5; i++) {
			 for (int j = 0; i < count; j++) {
				 System.out.print("*");
			 }
			 count = count -1;
			 System.out.println();
		 }
	}
}