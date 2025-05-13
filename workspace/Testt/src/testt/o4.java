package testt;

public class o4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores = {
			    {80,60,70}, {90,95,80}, {75,80,100}, {80,70,95}, {100,65,80}
		};
		int sum = 0;
		double avg = 0;
		
		System.out.println("학생번호   국어    영어    수학    총점    평균");
		System.out.println("=========================================");
		
		 for(int i = 0; i <scores.length; i++) {
			 System.out.print((i+1)+"번 학생:"+"  ");
			 for(int j = 0; j<scores[i].length; j++) {
				 sum += scores[i][j];
				 System.out.print(scores[i][j]+"\t");
			 }
			 avg = sum/3.0;
			 System.out.println(sum + "\t" + String.format("%.1f", Math.floor(avg)));
			 sum = 0;
			 avg = 0;
		 }
}
}