package arrays.slidingwindow;

/*
 * 	Given an array of integers and a number k.
	Return the highest sum of any k consecutive elements in the array.
	
	Examples:
	Input: arr = [1, 5, 2, 3, 7, 1], k = 3
	Output: 12 (the sum of subarray [2, 3, 7])
	
	Input: arr = [5, -3, 7, -6, 8], k = 2
	Output: 4 (the sum of subarray [-3, 7])
	
	Input: arr = [5, -3, 7, -6, 8], k = 3
	Output: 9 (the sum of subarray [5, -3, 7] or [7, -6, 8])

 * @author viswanath.gavva
 *
 */
public class HighestSubArray {
	
	public static void main(String[] args) {
		//int arr[] = {1, 5, 2, 3, 7, 1};
		//int k =3;
		//int arr[] = {5, -3, 7, -6, 8};
		//int k =2;
		int arr[] = {5, -3, 7, -6, 8};
		int k =3;
		
		int res = findHighestSubArraySum(arr,k);
		System.out.println(res);
		
	}

	private static int findHighestSubArraySum(int[] arr, int k) {
		if(arr.length==0 || k==0) {
			return 0;
		}
		if(k==1) {
			return(findMaxInArray(arr));
		}
		
		int curSum =0;
		for(int j=0;j<k;j++) {
			curSum += arr[j];
		}
		for(int i=1,j=k;i<arr.length-k;i++,j++) {
			int newSum = (curSum-arr[i-1]+arr[j]);
			curSum = Math.max(curSum, newSum);						
		}
		
		
		return curSum;
	}

	private static int findMaxInArray(int[] arr) {
		// TODO Find the Max in array and return
		return arr[0];
	}

}
