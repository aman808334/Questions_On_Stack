import java.util.Stack;

class Next_Greater_To_Left2 {
    
    public static int[] greater(int arr[]){

        int ans[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1); // While put 0th index in the stack

        // Will traverse the array from right and store the index in the stack
        for(int i=arr.length-2; i>=0; i--){

            if(arr[i]>arr[st.peek()]){
                while(!st.empty() && arr[i]>arr[st.peek()]){
                    ans[st.peek()] = arr[i];
                    st.pop();
                }
                st.push(i);
            }

            else{
                st.push(i);
            }
        }

        for(int i=0; i<ans.length; i++){
            if(ans[i]==0)
              ans[i] = -1;
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
