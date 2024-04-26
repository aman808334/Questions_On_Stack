
// Merge Overlapping Intervals

/*
Given an 2D array of interval where interval[i] = [start, end], merge all overlapping interval,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Input ->  {{22,28},{1,8},{25,27},{14,19},{27,30},{5,12}}
Output -> {{1,12},{14,19},{22,30}}
*/

import java.util.*;

class Merge_Overlapping_Intervals {

    public static int [][] solve(int interval[][]){

        // Sort the given 2D array on the basis of start time
        Arrays.sort(interval,(a,b)-> Integer.compare(a[0],b[0]));

        
        Stack<int[]> st = new Stack<>();

        for (int[] i : interval) {

            if(st.empty()){
                st.push(i);
            }
            
            else{
                if(st.peek()[1]<i[0])
                  st.push(i);
                else{
                    int x = Math.max(st.peek()[1], i[1]);
                    int xx[] = {st.peek()[0],x};
                    st.pop();
                    st.push(xx);
                }  
            }  
        }
        
        ArrayList<int[]> al = new ArrayList<>(st);
        
        return al.toArray(new int[al.size()][]);

    }

    public static void main(String[] args) {
        
        int interval[][] = {{22,28},{1,8},{25,27},{14,19},{27,30},{5,12}};
        int answer[][] = solve(interval);

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
    
}
