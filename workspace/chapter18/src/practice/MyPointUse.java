//package practice;
//
//public class MyPointUse {
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyPoint a = new MyPoint(3, 20);
//        System.out.println(a);  
//    }
//}
//
//class MyPoint {
//    int x;
//    int y;
//
//    MyPoint(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public String toString() {
//        return "MyPoint(" + x + "," + y + ")";
//    }
//}


package practice;

public class MyPointUse {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint a = new MyPoint(3, 20);
        System.out.println(a);  
    }
}

class MyPoint {
    int x;
    int y;

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "MyPoint(" + x + "," + y + ")";
    }
}