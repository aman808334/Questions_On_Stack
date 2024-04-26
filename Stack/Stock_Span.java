// Stock Span

/*
Given an array which has 'n' numbers, representing the price of share.
Find stock span for n days.
Stock span is defined as the number of days passed b/w the current day & 1st day b/f today when price was higher 
than today

Example -

Input -> {2,5,9,3,1,12,6,8,7}
Output -> {1,2,3,1,1,6,1,2,1}

*/

import java.util.Stack;

class Stock_Span {

    
    public static int[] solve(int arr[]){

        Stack<Integer> st = new Stack<>();
        st.push(0); // Put index of 1st element in the stack
        int ans[] = new int[arr.length];
        ans[0] = 1;  
         

        for(int i=1; i<arr.length; i++){

            if(arr[i]>arr[st.peek()]){
                while(!st.empty() && arr[i]>arr[st.peek()]){
                    st.pop();
                }
                if(st.empty())
                  ans[i] = i+1; // No greater element on left
                else
                  ans[i] = i-st.peek();

                st.push(i);
            }

            else{
                ans[i] = i-st.peek();
                st.push(i);
            }
        }
       return ans;   
    }

    public static void main(String[] args) {
        int arr[] = {2,5,9,3,1,12,6,8,7};
        int ans[] = solve(arr);
        for(int i=0; i<ans.length; i++)
         System.out.print(ans[i] + " "); 
    }
    
}
