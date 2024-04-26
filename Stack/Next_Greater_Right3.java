
/*
Example - 

Input -

arr[] = [1,3,4,2] & query[] = [4,1,2]

We've to say the next greater elements to the right of the elements which are present in query array

Output -

ans[] = [-1,3,-1]

*/

import java.util.HashMap;
import java.util.Stack;

class Next_Greater_Right3 {

    public static int[] solve(int arr[], int query[]){


       int ngr[] = nextGreaterRight(arr);

       int ans[] = new int[query.length];

       HashMap<Integer,Integer> hm = new HashMap<>(); // HM will contain element of arr as key & there ngr as value

       for(int i=0; i<arr.length; i++){
         hm.put(arr[i], ngr[i]);
       }

       // Will traverse the query array for answer
       for(int i=0; i<query.length; i++){
          ans[i] = hm.get(query[i]);
       }


        return ans;
    }

    public static int[] nextGreaterRight(int arr[]){

        int ans[] = new int[arr.length];

        ans[arr.length-1] = -1; // Last element won't have ngr

        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]); // Push the last element of the array in stack


        // Will traverse the array from right and store the elements in the stack
        for(int i=arr.length-2; i>=0; i--){

            if(arr[i]>st.peek()){

                while(st.size()>0 && arr[i]>st.peek()){
                    st.pop();
                }

                if(st.empty())
                  ans[i] = -1;
                else
                  ans[i] = st.peek(); 

                st.push(arr[i]);
            }

            else{
                ans[i] = st.peek();
                st.push(arr[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        int arr[] = {1,3,4,2};
        int query[] = {4,1,2};
        int ans[] = solve(arr, query);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }


    
}
