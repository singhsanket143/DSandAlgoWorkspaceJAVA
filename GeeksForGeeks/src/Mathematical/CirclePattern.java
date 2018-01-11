package Mathematical;

public class CirclePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		circlePattern(8);

	}
	
	public static void circlePattern(int r){
		int x,y;
		int n=2*r+1;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				x=i-r;
				y=j-r;
				if(x*x+y*y<=r*r+1){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
