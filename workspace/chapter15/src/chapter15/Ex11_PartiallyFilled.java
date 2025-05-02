package chapter15;

public class Ex11_PartiallyFilled {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
				{11},
				{22, 33}
				,{44,55,66}
		};
//		arr.length:3
		for(int i = 0; i <arr.length;i++) {
//			arr[0].length: 1
//			arr[1].length: 2
//			arr[2].length: 3
			for(int j = 0; j <arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			
//			3차원 배열
			int[][][] arr3 = new int[3][3][3];
			arr3[0][0][0] = 1;
			arr3[0][0][1] = 2;
			arr3[0][0][2] = 3;
			arr3[0][1][0] = 4;
			arr3[0][1][1] = 5;
			arr3[0][1][2] = 6;
			arr3[0][2][0] = 7;
			arr3[0][2][1] = 8;
			arr3[0][2][2] = 9;
			arr3[0][0][0] = 10;
			arr3[0][0][1] = 11;
			arr3[0][0][2] = 12;
			arr3[1][0][0] = 1;
			arr3[1][0][1] = 1;
			arr3[1][0][2] = 1;
			arr3[0][0][0] = 1;
			arr3[0][0][1] = 1;
			arr3[0][0][2] = 1;
		}

	}

}
