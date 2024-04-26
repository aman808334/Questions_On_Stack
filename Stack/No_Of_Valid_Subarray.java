
// Number of Valid Subarray

/*
U r given an array & u have to find number of valid subarray in that given array

Rule to be valid - That subarray is valid which starts with the smallest no in the subarray

Example - 

Input -> [2,4,2,1,3]

Valid subarray are = [2],[2,4],[2,4,2], [4], [2], [1], [1,3], [3]

Output -> 8
*/

/*
Approach -

We know that b/f any smaller number occurs, till then all the possible subarrays are valid.
So, we'll find the nsr & then count all the possible subarray b/w the current index & next smaller.
*/

import java.util.Stack;

class No_Of_Valid_Subarray {

    public static int countValidSubarray(int arr[]){

        int count = 0;
        int nsr[] = nextSmallerRight(arr);
       
        // Iteration grom find the count of valid subarray
        for(int i=0; i<arr.length; i++){
            count += nsr[i]-i;
        }

       return count; 
    }
    
    public static int[] nextSmallerRight(int arr[]){

        int nsr[] = new int[arr.length];

        nsr[nsr.length-1] = arr.length; // Last element won't have nsr. So, nsr.length

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1); // Will push index of last element in the stack
        
        // Iteration from right side
        for(int i = arr.length-2; i>=0; i--){

            while(!st.empty() && arr[i]<=arr[st.peek()]){
                st.pop();
            } 

            if(st.isEmpty())
             nsr[i] = arr.length; // If no nsr then arr.length
            else
             nsr[i] = st.peek();
             

            st.push(i); 
           
        }

       return nsr;  
    }

    public static void main(String[] args) {
        
        int arr[] = {2,2,2};
        System.out.println(countValidSubarray(arr));

    }
    
}
