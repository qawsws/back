package practice2;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (int i = 2; i <= 9; i++) {
//            for (int j = 1; j <= 9; j++) {
//                if (j > i) { 
//                    break;
//                }
//                System.out.println(i+"*"+j+"="+(i*j));
//            }
//          
//	}
//
//}
//}
		for(int i = 2; i <= 9; i++) {
			for(int j =1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+(i*j));
				if(j==i){
					break;
				}
			}
			}
	}

}

