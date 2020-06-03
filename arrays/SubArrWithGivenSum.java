public class SubArrWithGivenSum {

public voild findSubArrWithGivenSum(int[] ip,int sum){
	/** Pseudo code:
	
		int[] subArr = null;
		for (int i=0; i< ip.length();ip++){
			while(total(subArr)>sum){
			    //Keep removing the first item in the array as long as the sum of the elements in the array exceeding the given sum
				subArr.remove(0);
			}
			
			//If the sum of the elements in the array is EQUAL to the given sum, print the sub array and reset it.
			if(total(subArr) == sum){
				print(subArr);
				clear(subArr);
			}
			
			subArr.push(ip[i]);
		}
	**/
	int[] subArr = new int[]();
	
}

public static void main(String[] args) {
	SubArrWithGivenSum subArrWithGivenSum = new SubArrWithGivenSum();
	int[] ip = {1,2,3,4,5,7,2,1,1};	
	int sum = 4;
	subArrWithGivenSum.findSubArrWithGivenSum(ip,sum);
}
}