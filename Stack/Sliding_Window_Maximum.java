
// Sliding window maximum

/*
You are given an array & WS. 
You have to tell maximum in each window 

Example -

Input -> {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6}
Output -> {9,9,8,12,12,14,14,32,32,32,32,19,19,19}
*/

import java.util.ArrayList;
import java.util.Stack;

class Sliding_Window_Maximum {

    public static ArrayList<Integer> maximum(int arr[], int k){

        int ngr[] = nextGreater(arr); // Will store the index of next greater to right
        ArrayList<Integer> ans = new ArrayList<>();

        // Now check maximum in the WS of 'k'
        int j =0;
        for(int i=0; i<=arr.length-k; i++){
            if(i>j){
                j=i;
            }
            while(ngr[j]<(i+k)){
                j = ngr[j];
            }
            if(ngr[j-1]<arr.length)
              ans.add(arr[ngr[j-1]]);
            else
              ans.add(arr[j]); 
        }
      return ans;    
    } 

    public static int[] nextGreater(int arr[]){

        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        ans[arr.length-1] = arr.length; // Doesn't have max on right
        st.push(arr.length-1); // Will push the last index of the array

        for(int i=arr.length-2; i>=0; i--){

            if(arr[i]>arr[st.peek()]){
                while(!st.empty() && arr[i]>arr[st.peek()]){
                    st.pop();
                }
                if(st.empty())
                  ans[i] = arr.length; // Doesn't have max on right
                else
                  ans[i] = st.peek();
                  
              st.push(i);    
            }

            else{
                ans[i] = st.peek();
                st.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
        int k = 4;
        System.out.println(maximum(arr, k));
    }
    
}
