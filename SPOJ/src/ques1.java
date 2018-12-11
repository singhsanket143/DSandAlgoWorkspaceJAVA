public class ques1 {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        int arr[][] = {{1,2,3,4}, {11,14,15,16}, {21,24,27,28},{31,33,34,37}};
        int key=4;
        matrixSearch(arr, key);
    }

    public static void matrixSearch(int [][] arr, int key) {
        for(int row = 0;row < arr.length;) {
            for(int col=arr[0].length-1;col>=0 && row< arr.length;) {
                if(arr[row][col] == key) {
                    // cout<<row<<" "<<col;
                    System.out.println(row+" "+col);
                    return ;
                } else if(arr[row][col] > key) {
                    col--;
                } else {
                    row++;
                }
            }
	    }
        System.out.println("Not found");
        return ;
    }
}