package chapter15;

public class Ex10_ForlnFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[3][3];
//		int[행]: 행을 의미하는 반복문
		int num = 1;
		for(int i = 0; i <3; i++) {
//			int[행][열] : 열을 의미하는 반복문
			for(int j=0; j<3; j++) {
				arr[i][j] = num;
				num++;
			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
//				\t : 탭
				System.out.print(arr[i][j]+ "\t");
			}
			System.out.println();
		}
	}

}
