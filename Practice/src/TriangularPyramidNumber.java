
public class TriangularPyramidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(numberOfSticks(7));

	}
	
	public static int numberOfSticks(int x) {
		return (3*x*(x+1))/2;
	}

}
