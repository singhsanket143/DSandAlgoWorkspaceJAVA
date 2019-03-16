
public class TestClass {
	public static void main(String[] args) {
		
//		System.out.print(2000);
//		System.out.println();
		int max=200;
		int min=1;
//		System.out.println(10);
//		for(int i=0;i<10;i++) {
//			int x = (int)(Math.random() * ((10000 - min) + 1)) + min;
////			int n = (int)(Math.random() * ((50 - min) + 1)) + min;
//			//int y = (int)(Math.random() * ((10 - min) + 1)) + min;
////			int sum = (int)(Math.random() * ((5000 - 1) + 1)) + 1;
////			System.out.println(x+" "+(x+sum));
//			System.out.println(x);
//		}
//		System.out.println(0);
		int t=100;
//		System.out.println(t);
		for(int i=0;i<t;i++) {
			int x = (int)(Math.random() * ((1000 - min) + 1)) + min;
			int y = (int)(Math.random() * ((10000 - min) + 1)) + min;
			System.out.println(x+" "+y);
			for(int j=0;j<x;j++) {
				int num = (int)(Math.random() * ((100000 - min) + 1)) + min;
				System.out.print(num+" ");
			}
			System.out.println();
			for(int j=0;j<y;j++) {
				int num = (int)(Math.random() * ((100000 - min) + 1)) + min;
				System.out.print(num+" ");
			}
			System.out.println();
		}
				
		
	}


}