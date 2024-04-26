
import java.util.Stack;

class Largest_Area_Histogram1 {

    public static int solve(int arr[]){
        int rs[] = rightSmallest(arr);
        int ls[] = leftSmallest(arr);
        int max = 0;
        for(int i=0; i<arr.length; i++){
            int area = arr[i]*((rs[i]-ls[i])-1);
            max = Math.max(max, area);
        }

        for(int i=0; i<ls.length; i++){
            System.out.print(ls[i] + " ");
         }

         System.out.println();

         for(int i=0; i<rs.length; i++){
            System.out.print(rs[i] + " ");
         }

         System.out.println();

       return max; 
    }

     public static int[] rightSmallest(int arr[]){

        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1); // Put the index of last element of the array in stack
        int answer[] = new int[arr.length];
        answer[arr.length-1] = arr.length;

        // Iteration of array from right side & will put index in the stack
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i]<arr[st.peek()]){
                while(!st.empty() && arr[i]<arr[st.peek()]){
                    st.pop();
                }
                if(st.empty())
                  answer[i] = arr.length; // No smallest element in the right.
                else
                  answer[i] = st.peek();

               st.push(i);
            }

            else{
                answer[i] = st.peek();
                st.push(i);
            }
        }
        return answer;
    }

    public static int[] leftSmallest(int arr[]){

        Stack<Integer> st = new Stack<>();
        st.push(0); // Put the index of 1st element of the array in stack
        int answer[] = new int[arr.length];
        answer[0] = -1;

        // Iteration of array from right side & will put index in the stack
        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[st.peek()]){
                while(!st.empty() && arr[i]<arr[st.peek()]){
                    st.pop();
                }
                if(st.empty())
                  answer[i] = -1; // No smallest element in the right.
                else
                  answer[i] = st.peek();

               st.push(i);
            }

            else{
                answer[i] = st.peek();
                st.push(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {6,2,5,4,5,1,6};
        System.out.println(solve(arr));
    }
    
}

