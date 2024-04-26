
// Next Greater 3

/*
Given a +ve integer n, find the smallest integer which has exactly the same digits existing in the given integer
and is greater in value than n. If no such positive integer exists, return -1.

Note -

The returned integer should fit in 32-bit integer, if not fit than return -1
 

Example 1:

Input -> 123
Output -> 132 (All possible - 132, 213, 231, 312, 321 but 132 is the smallest)

Input -> 321
Output -> -1
*/

import java.util.Stack;

class Next_Greater_3 {

    public static int nextGreaterElement(int n) {

        String s = n+"";
        char arr[] = s.toCharArray();

        int ngr[] = nextGreaterRight(arr); // Will have index of ngr

        boolean flag = false;
        int reqindex = 0;

       // Iterate to ngr from right side and where ever there is a number except '-1', swap that with previous element
       for(int i=ngr.length-1; i>=0; i--){

           if(ngr[i] != -1){

            reqindex = i;
            flag = true;
            break;  
          }
       }

       if(flag == true ) {

       // We've got digit to be changed. Now find with whom it will be changed
       int k = arr.length-1;
       while(arr[reqindex] >= arr[k]){ 
        /*
         If it's equals then also k-- & the digits which we'r checking will be in increasing order & the region
         for this is that we'r checking on those whose ngr doesn't exist.
        */
        k--;
       }
       // Swap
       char temp = arr[k];
       arr[k] = arr[reqindex];
       arr[reqindex] = temp;

      }

       String ans = "";

       for(int k=0; k<=reqindex; k++){
           ans +=arr[k];
       }

       // Add the remaining in reverse order
       for(int k=arr.length-1; k>reqindex; k--){
           ans += arr[k];
       }



       if(flag == true){
        if(Long.parseLong(ans) > Integer.MAX_VALUE)
          return -1;
         else
          return Integer.parseInt(ans);
       }   
       else // If no such number is possible then return '-1'
        return -1; 

    
    }

    // Will give index of next greater element to right
    public static int[] nextGreaterRight(char arr[]){

        int ans[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1); // Will put last index in the Stack

        ans[arr.length-1] = -1; // Last element won't have ngr

        for(int i=arr.length-2; i>=0; i--){

            while(!st.isEmpty() && arr[i] >= arr[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }

       return ans; 
    }

    public static void main(String[] args) {
        int n= 230241;
        System.out.println(nextGreaterElement(n));
    }
}