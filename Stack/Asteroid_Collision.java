
// Asteroid Collision

/*
We are given an array of integers representing asteroids.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive means right & negative means left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. 

Rule -

(1) If two asteroids meet, the smaller one will explode.
(2) If two asteroids meet & both are the same size, both will explode.
(3) Two asteroids moving in the same direction will never meet.

Example -

Input -> [5,10,-5]
Output -> [5,10]
Explanation -> The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
*/

import java.util.Stack; 

class Asteroid_Collision {

    public static int[] collision(int[] arr) {

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){

            // If element is +ve
            if(arr[i]>0){
              st.push(arr[i]);
            }
            
            else{ // Element is -ve
              
              // Peek is +ve & -ve number is powerful
              while(!st.empty() && st.peek()>0 && st.peek() <-arr[i])
                st.pop();
              
               // Peek is +ve & -ve number is equal
               if(!st.empty() && st.peek()>0 && st.peek() == -arr[i])
                st.pop();
              
              
              // Peek is -ve 
              else if(!st.empty() && st.peek()<0)
                st.push(arr[i]);
              
              // If size of stack is '0' & value is -ve then just push
              else if(st.size() == 0)
                st.push(arr[i]);
              
               // By writing else if we handle that condition in which -ve number is weak . Example - [5,10,-5]
            }
        }

        int ans[] = new int[st.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
        int arr[] = {8,-8};
        int ans[] = collision(arr);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}