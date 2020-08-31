package gavvas.leetcode.twopointer;

//Time Complexity: O(n)
//Space Complexity: O(1)

public class TrappingRainWater {
	
	public int findWaterCapacity(int[] a) {
		int r = 0;//Result
		//flags to denote whether the left->right  and left <- right collection is started or not.
		//This is needed to ignore the 0's at the start in both directions. 
		//We will start trapping water only from the first occurance of non-zero bar
		boolean st1 = false,st2 = false;
		//These are the pointers used to save the Starting indexes of a potential Ditch(sd) for both the directions.
		int sd1=-1,sd2=-1;
		//Variables to hold the trapped water so far in both the directions.
		int w1=0,w2=0;
		//flags to denote if the current ditch is ended in both the directions.
		boolean ed1=true,ed2=true;
		
		for(int i=0, j=a.length-1;i< a.length && j >=0; i++,j--) {
			//ignore the 0s in both directions until we find the first non-0 element.			
			if(a[i]>0 && !st1) {
				st1=true;
				sd1=i;
			}									
			if(a[j]>0 && !st2) {
					st2=true;
					sd2=j;
			}
			
			//Iterate till the left->right (i) and left<-right (j) pointers did not/about to cross
			if(j-i > 1) {
				//start left->right only when st1 is true
				if(st1) {
					if(a[i]<a[sd1]) {//we have a smaller bar to the left so we can trap some water
						w1 = w1+(a[sd1]-a[i]);
						ed1=false;
					}else {//we reached a point where we have a taller bar to the left. so we have to
						r= r+w1;//add the water collected so far to the result.
						ed1=true;//end the current ditch
						sd1=i;//set the starting of the ditch to the current item												
						w1=0;//reset water for left -> right ditch
					}
				}
				
				//start right->left only when st2 is true
				if(st2) {
					if(a[j]<a[sd2]) {
						w2 = w2+(a[sd2]-a[j]);
						ed2=false;
					}else {
						sd2=j;//set the starting of the ditch to the current item
						ed2=true;//end the current ditch
						r= r+w2;//add the water collected so far to the result.
						w2=0;//reset water for left <- right
					}
				}
				
			}else {//The pointers already met/crossed OR just about to meet/cross in next iteration
				if(a[sd1] <= a[sd2]) { // The left -> right ditch is of smaller height
					w2=0;//ignore the left <- right ditch since that ditch has a taller starting bar
					//Continue with left -> right ditch and collect water till we reach start of left <- right ditch(sd2)
					while(i<=sd2) {
						if(a[i]<a[sd1]) {
							w1 = w1+(a[sd1]-a[i]);
							ed1=false;
						}else {
							sd1=i;//set the starting of the ditch to the current item
							ed1=true;//end the current ditch
							r= r+w1;//add the water collected so far to the result.
							w1=0;//reset water for left -> right
						}
						i++;
					}
				}else { // The left <- right ditch is of smaller height
					w1=0;//ignore the left -> right ditch since that ditch has a taller starting bar
					//Continue with left <- right ditch and collect water till we reach start of left -> right ditch(sd1)
					while(j>=sd1) {
						if(a[j]<a[sd2]) {
							w2 = w2+(a[sd2]-a[j]);
							ed2=false;
						}else {
							sd2=i;//set the starting of the ditch to the current item
							ed2=true;//end the current ditch
							r= r+w2;//add the water collected so far to the result.
							w2=0;//reset water for left -> right
						}
						j--;
					}
				}
				break;//break out of the loop
			}
			
		}
		
		
		return r;
	}
	
	public static void main(String args[]) {
		TrappingRainWater tr = new TrappingRainWater();
		int[] ipArr = {0,1,0,4,3,0,1,3,2,1,2,1};
		System.out.println("Total water that can be trapped is"+tr.findWaterCapacity(ipArr));
		
	}

}
