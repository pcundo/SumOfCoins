import java.util.Arrays;

 /******Sum of coins******
 Given a list of value of coins, find the least amount number of coins to sum up to the specified amount
 In this example, we are given 3 coins with value "1, 3, 5". The sum of all the coins should add up to 11.
 We use a recusive dynamic programming to solve this. Our table is displayed below

 * = infinity

  j  i->  0 1 2 3 4 5 6 7 8 9 10 11
 0(0)     0 * * * * * * * * * *  *
 1(1)     0 1 2 3 4 5 6 7 8 9 10 11
 2(3)     0 1 2 1 2 3 2 3 4 3 4  5
 3(5)     0 1 2 1 2 1 2 3 2 3 2  3

  The steps to fill out the table is followed:
 1) First fill out the zero row with infinity except the first cell, then
    fill out the first column with zero.
 2) Check if the value of the first coin(number in the parenthesis) is less than or 
    equal to the number above, if yes subtract the value to the number i number,
    get the number from that cell and add 1 to it, then compare it with the above cell.
 3) Record the smaller value. 
 4) If the value is greater than, then record the number from the cell above. 

 */

public class SumOfCoins {
	public static void main(String [] args){
		int [] value = {0,1,3,5};
		int [] sum = new int[12];
		Arrays.fill(sum, Integer.MAX_VALUE);
		sum[0] = 0;
		System.out.println(sum(sum,value,11,3));
		System.out.println(sum1(sum,value));
	}
	
		/**
		 The recursive method seems to be much faster because it only computes the data
		 that is need for some particular value. It doesn't computer every single data
		 and hence it didn't fill the table. 
		 */
	public static int sum(int[]s, int [] v, int i, int j){
		int sum = 0;
		if(i == 0)
			return 0;
		else if(j == 0)
			return s[i];
		else if(v[j] <= i)
			return sum = Math.min(sum(s,v,i-v[j],j) + 1, sum(s,v,i,j-1));
		else
			return sum = sum(s,v,i,j-1);
	}

		/**
		 This method seems to computer every single data to fill the table.
		 */
		public static int sum1(int []s, int [] v){
				int sLength = s.length;
				int vLength = v.length;
				int temp = 0;
				for(int i = 0; i < sLength; i++){
						for(int j = 1; j < vLength; j++){
								if(v[j] <= i && (temp = s[i-v[j]]+1) < s[i])
										s[i] = temp;
								
										
						}
				}
				return s[sLength-1];
		}
}
