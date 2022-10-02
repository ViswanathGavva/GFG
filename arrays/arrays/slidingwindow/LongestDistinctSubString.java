package arrays.slidingwindow;
/*
 * 
 * Given a string s, find the length of the longest substring without repeating characters.

 

	Example 1:
	
	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
	Example 2:
	
	Input: s = "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:
	
	Input: s = "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3.
	Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

public class LongestDistinctSubString {
	
	
	public static void main(String[] args) {
		//String str = "pwwkew";
		//String str = "wpwklew";
		String str = "wpwkabcabcglew";
		//String str ="abcabcbb";
		//String str ="bbbbb";
		System.out.println(findMaxDistinctSubStr(str));
	}

	private static String findMaxDistinctSubStr(String str) {
		//make the first char as current window to start with
		String windowStr = str.substring(0,1);
		String maxStr = windowStr;
		
		for(int right=1;right<str.length();right++) {
			char rightChar = str.charAt(right);
			//if the next character is already present in the current window, 
			// Then split it till the index of the character in the window
			if( windowStr.indexOf(rightChar)>=0) {
				windowStr = windowStr.substring(windowStr.indexOf(rightChar)+1);
			}
			//append the next char to the window.
			windowStr = windowStr+rightChar;
			maxStr =   windowStr.length()>maxStr.length()? windowStr:maxStr;
			
//			if( windowStr.indexOf(rightChar)==-1) {
//				windowStr = windowStr+rightChar;
//				maxStr =   windowStr.length()>maxStr.length()? windowStr:maxStr;
//				continue;
//			}
//			
//			windowStr = windowStr.substring(windowStr.indexOf(rightChar)+1);
//			windowStr = windowStr+rightChar;
//			maxStr =   windowStr.length()>maxStr.length()? windowStr:maxStr;
			
		}
		return maxStr;
	}

}
