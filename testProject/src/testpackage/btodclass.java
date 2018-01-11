package testpackage;

public class btodclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bin=100000;
		//System.out.println(bintodec(bin));
		//Scanner s=new Scanner(system.in);
		
System.out.println(AnyToAny(37,8,2));
	}
public static int bintodec(int bin){
	int dec=0,rem=0,p=1;
	while(bin>0){
	rem=bin%10;
  dec=dec+rem*p;
   p=p*2;
   bin=bin/10;
	}
	return dec;
	
public static int AnyToDec(int sb, int num){
	int rem=0,p=1,dec;
	while(num!=0){
		rem=num%10;
    	dec=dec+rem*p;
    	p=p*sb;
    	
}return dec;
}
public static int DecToany(int db,int num){
	int rem=0,p=1,ans=0;
	while(dec!=0){
		rem=dec%db;
	    ans=ans+rem*p;
	    p=p*10;
	    dec=dec/db;
}return ans;
}
public static int AnyToAny(int num,int sb, int db){
 int dec=AnyToDec(sb,num);
 int ans=decToAny(db,dec);
//{
//	for(int i=0;i<count;i++){
//		int p=2; 
//		p=p*p;
}
}
