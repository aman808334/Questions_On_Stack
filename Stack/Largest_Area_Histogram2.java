
// Largest Area Histogram

import java.util.Stack;

class Largest_Area_Histogram2 {

    public static int solve(int arr[]){
        
        int ls[] = new int[arr.length]; // For storing indices of nsl
        int rs[] = new int[arr.length]; // For storing indices of nsr
        
        leftSmallest(arr,ls,rs); // ls & rs array will contain index of nsl & nsr respectively
        int max = 0;
        for(int i=0; i<arr.length; i++){
            
            int area = arr[i]*((rs[i]-ls[i])-1);
            max = Math.max(max, area);
        }

       return max; 
    }
     // We'll calculate the nsl & nsr in same function
     public static void leftSmallest(int arr[], int ls[], int rs[]){

        Stack<Integer> st = new Stack<>();
        st.push(0); // Put the index of 1st element of the array in stack
        ls[0] = -1;

        // Iteration of array from right side & will put index in the stack
        for(int i=1; i<arr.length; i++){

            if(arr[i]<arr[st.peek()]){

                while(!st.empty() && arr[i]<arr[st.peek()]){
                    rs[st.peek()] = i; // For nsr.
                    st.pop();
                }
                if(st.empty())
                  ls[i] = -1; // No smallest element in the right.
                else
                  ls[i] = st.peek();

               st.push(i);
            }

            else{
                ls[i] = st.peek();
                st.push(i);
            }
        }
        // Will iterate on 'rs' array & where there is '0' will put rs.length there 
        for(int i=0; i<rs.length; i++){
            if(rs[i] == 0)
              rs[i] = rs.length;
        }
    }

    public static void main(String[] args) {
        int arr[] = {6,2,5,4,5,1,6};
        System.out.println(solve(arr));
    }
    
}