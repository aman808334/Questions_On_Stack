
// 132 Pattern

/*
U r given an array of integers
U've to find that 132 pattern exist in that array of not.

132 pattern is a subsequence of 3 integers arr[i], arr[j] & arr[k], such that i < j < k & arr[i] < arr[k] < arr[j].
*/

/*
Approach -

We know,

i -> Smallest
j-> Largest
k -> In b/w i & j

So, we can say i<j<k

. We'll find min till now (till every element) & store it in an array & this will be 'i'
. We'll take a stack that will contain elements greater than min[j] or 'i' i.e will contain 'k'
. Iterate on the given array to find 'j' from RHS. & if st.peek() i.e 'k' > i & arr[j] i.e 'j' > st.peek() i.e 'k',
then that means i<k<j & that means 132 pattern exists
*/

import java.util.Stack;

class Pattern_132 {

    public static boolean findPattern(int arr[]){
        
        int min[] = new int[arr.length];
        int minimum = Integer.MAX_VALUE;

        //Iterate to array to find minimum till now
        for(int i=0; i<arr.length; i++){

            minimum = Math.min(minimum,arr[i]);
            min[i] = minimum;
        }

        Stack<Integer> st = new Stack<>(); // Will contain element greater than min[j] or 'i' i.e will contain 'k'

        // Iterate to array from right i.e find 'j' from right
        for(int j=arr.length-1; j>=0; j--){

            while(!st.isEmpty() && min[j]>=st.peek()){ // While i>=k
                st.pop();
            }

            if(!st.isEmpty() && min[j]<st.peek() && arr[j]>st.peek()){ // i<k<j. 
                return true;
            }

            st.push(arr[j]);
        }

        return false;   
    }

    public static void main(String[] args) {
        
        int a[] = {-1,3,2,0};
        System.out.println(findPattern(a));
    }
    
}
