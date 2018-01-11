package Mathematical;

public class DayOfTheYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
		int x=DOY(t, 1996);
		if(x==0){
			System.out.println("Sunday");
		} else if(x==1){
			System.out.println("Monday");
		}else if(x==2){
			System.out.println("Tuesday");
		}else if(x==3){
			System.out.println("Wednesday");
		}else if(x==4){
			System.out.println("Thusrday");
		}else if(x==5){
			System.out.println("Friday");
		}else if(x==6){
			System.out.println("Saturday");
		}

	}
	
	public static int DOY(int t[],int y){
		int m=1,d=1;
		y-=m;
		return (y+y/4-y/100+y/400+t[m-1]+d)%7;
	}

}
