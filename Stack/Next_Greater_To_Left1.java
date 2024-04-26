import java.util.Stack;

class Next_Greater_To_Left1 {

    public static int[] greater(int arr[]){

        int ans[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr[0]); // While put 0th index in the stack
        ans[0] = -1;

        // Will traverse the array from left and store the elements in the stack
        for(int i=1; i<arr.length; i++){

            if(arr[i]>st.peek()){
                while(!st.empty() && arr[i]>st.peek()){
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
        int arr[] = {2,5,9,1,3,12,6,8,7};
        int ans[] = greater(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
    
}
