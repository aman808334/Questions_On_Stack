
// Lexicographically Smallest Subsequence

/*
U'll given an array & size of subsequence
U have to return smallest possible subsequence of given size.

Example -

Input -> [3,5,2,6]

All possible subsequence of size 'k' -> 35, 32,36, 52, 56, 26

Output -> [2,6]
*/

import java.util.Stack;

class Lexicographically_Smallest_Subsequence {

    public static int[] subsequence(int arr[],int k){

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){

        // Required no. of numbers at any time = k-st.size()
        // To check that how many elements are remaining a/f a particular index = arr.length -i-1
        while(!st.isEmpty() && arr.length-i-1 >= k-st.size() && arr[i] < st.peek()){
            st.pop();
        }
         
        if(st.size() < k) // Requirement is there, then add
          st.push(arr[i]);

        }

        int ans[] = new int[k];

        for(int i=k-1; i>=0; i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }

    public static void main(String[] args) {
        
        int arr[] = {3,5,2,6};
        int k = 3;
        int ans[] = subsequence(arr,k);
        for (int i : ans) 
            System.out.print(i + " ");
            
    } 
}
