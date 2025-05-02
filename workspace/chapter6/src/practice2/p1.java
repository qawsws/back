package practice2;

public class p1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 2; i <= 9; i++) {
			if(i%2!=0)//if(i%2==1)
				continue;
			for(int j =1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
			}
	}

}
