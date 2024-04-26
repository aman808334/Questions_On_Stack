
// Second Next Greater Element

/*
Input -> [2,4,0,9,6]
Output -> [9,6,6,-1,-1]
*/

import java.util.Arrays;
import java.util.Stack;

class Second_Next_Greater_Right {

    public static int[] secondGreaterElement(int arr[]){

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        

        int ans[] = new int[arr.length];
        Arrays.fill(ans, -1); // fill -1 in all index

        for(int i=0; i<arr.length; i++){

            while(!st2.isEmpty() && arr[i]>arr[st2.peek()])
              ans[st2.pop()] = arr[i];

             while(!st1.isEmpty() && arr[i]>arr[st1.peek()])
              temp.push(st1.pop());

             while(!temp.isEmpty())
              st2.push(temp.pop());

           st1.push(i);    
        }
      return ans;  
    }

    public static void main(String[] args) {

        int arr[] ={11,13,15,12,0,15,12,11,9};
        int ans[] = secondGreaterElement(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }  
}
