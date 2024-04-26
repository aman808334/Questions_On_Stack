
// Maximal Rectangle

/*
We'r given a binary matrix. We've to find the area of a largest rectangle formed by only '1'

Example -

Matrix = 01001
         01010
         11001
         11101 
         
largest rectangle which can be formed by only '1' is 11. So, the output should be '4'
                                                     11         
*/

// Approach - We'll convert this to largest area histogram

import java.util.Stack;

class Maximal_Rectangle {

    public static int solve(int arr[][]){

        int area = 0;
        int height[] = new int[arr[0].length];
         
        // Initially, we'll put the 1st row in "height" array 
        for(int i=0; i<arr[0].length; i++){
            height[i] = arr[0][i];
        }

        area = Math.max(area, largestAreaHistrogram(height));

        for(int row=1; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){

                if(arr[row][col] == 1)
                  height[col] ++;
                else
                  height[col] = 0;  
            }
          area = Math.max(area, largestAreaHistrogram(height));  
        }

        return area;
    }

    public static int largestAreaHistrogram(int arr[]){

        int ls[] = new int[arr.length]; // For storing indices of nsl
        int rs[] = new int[arr.length]; // For storing indices of nsr

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

        // We've required indices in nsl & nsr. Now, calculate the maximum area,
        int max = 0;
        for(int i=0; i<arr.length; i++){
            
            int area = arr[i]*((rs[i]-ls[i])-1);
            max = Math.max(max, area);
        }

       return max; 
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,1,0,0}, {1,0,0,1,1}, {1,1,1,1,1}, {1,0,0,1,0}};
        System.out.println(solve(arr));
    }
    
}
