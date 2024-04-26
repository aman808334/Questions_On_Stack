
// Trapping Rain Water

import java.util.Stack;

class Trapping_Rain_Water_1 {

    public static int trapping(int arr[]){

        int rm [] = new int[arr.length];
        int lm [] = new int[arr.length];

        leftMax(arr,lm);
        rightMax(arr,rm);

        int totalwater = 0;

        //Iterate on array to calculate the totalwater
         for(int i=0; i<arr.length; i++){

            int oneblockwater = Math.min(arr[lm[i]],arr[rm[i]])-arr[i];
            if(oneblockwater>0)
              totalwater += oneblockwater;
         }

        return totalwater;
    }

    public static void leftMax(int arr[], int lm[]){

        Stack<Integer> st = new Stack<>();
        st.push(0); // Will push index of 1st element

        for(int i=0; i<arr.length; i++){
            
            if(arr[i]>arr[st.peek()]){
                lm[i] = i;
                st.pop();
                st.push(i);
            }

            else{
                lm[i] = st.peek();
            }
        }
    }

    public static void rightMax(int arr[], int rm[]){

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1); // Will push index of last element

        for(int i=arr.length-1; i>=0; i--){
            
            if(arr[i]>arr[st.peek()]){
                rm[i] = i;
                st.pop();
                st.push(i);
            }

            else{
                rm[i] = st.peek();
            }
        }    
    }

    public static void main(String[] args) {

        int arr[] = {4,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapping(arr));  
    }
}
