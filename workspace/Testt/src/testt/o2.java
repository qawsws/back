package testt;

import java.util.Scanner;

class Phone{
	private String name;
	private String tel;
	private String address;
	
	
	Phone(String name, String tel, String address){
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	public String getname() {
		return name;
	}
	public String gettel() {
		return tel;
	}
	public String getaddress() {
		return address;
	}
	@Override
	public String toString() {
		return tel + ", " + address;
	}
}

public class o2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수>>");
		int count = sc.nextInt();
		sc.nextLine();
		
		Phone[] arr = new Phone[count];
		
		for(int i=0; i < count; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력),주소 >>");
			arr[i] = new Phone(sc.next(),sc.next(),sc.next());
		}
		System.out.println("저장되었습니다...");
		System.out.println();
		
		

		while(true) {
			System.out.print("검색할 이름>>");
			String find = sc.next();
			if (find.equals("exit")) {
	             System.out.println("프로그램을 종료합니다...");
	             break;  
			}
			boolean a = true;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].getname().equals(find)) {
					System.out.println(find+"의 번호와 주소는"+ arr[i]+"입니다");
					a = false;
				}
			}
			if(a) {
				System.out.println(find+"은(는) 없습니다");
			}
			
		}
	}
	

}
