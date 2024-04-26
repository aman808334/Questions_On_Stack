
// Trapping Rain Water 2D

import java.util.PriorityQueue;

class Trapping_Rain_Water_2D {

    static class Pair implements Comparable<Pair>{
        int row;
        int col;
        int element;
       
        // Constructor
        public Pair(int row, int col, int element){
        this.row = row;
        this.col = col;
        this.element = element;
        }

        // This function with compare & return the minimum value on the basis of element
        public int compareTo(Pair o){
          return this.element - o.element;
        }    
    }
      

    public static int trapping(int arr[][]){

      PriorityQueue<Pair> pq = new PriorityQueue<>();
      boolean visited[][] = new boolean[arr.length][arr[0].length]; 

      // Adding the boundary of given 2D array in the PQ & mark it as visited in visited 2D array
      for(int i=0; i<arr.length; i++) {
        for(int j=0; j<arr[0].length; j++) {
       
          if( i== 0 || i == arr.length-1 || j == 0 || j == arr[0].length-1){
            pq.add(new Pair(i,j,arr[i][j]));
            visited[i][j] = true;
          }     
        }
      }

      int neighbour[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // Direction of all possible neighbour
      int totalwater = 0;

      while(!pq.isEmpty()){

        Pair p = pq.remove(); // Take out a pair from pq

        // Row & Column of the pair that is removed
        int r = p.row;
        int c = p.col;

        //
        for (int[] i : neighbour) {
            int rr = r + i[0];
            int cc = c + i[1];

            if(rr > 0 && rr < arr.length-1 && cc > 0 && cc < arr[0].length-1 && visited[rr][cc] == false){

                // If height of boundary is greater as compared to it's neighbour, then water can be stored
                if(arr[r][c] > arr[rr][cc]){ 

                  totalwater = totalwater + (arr[r][c] - arr[rr][cc]);
                  arr[rr][cc] = arr[r][c]; // A/f adding water the height of both r same
                  pq.add(new Pair(rr, cc, p.element)); // Adding in PQ i.e. making it a part of boundary
                }

                else{
                    pq.add(new Pair(rr, cc, arr[rr][cc])); // Adding in PQ i.e. making it a part of boundary
                }

                visited[rr][cc] = true;
            }
        }
      }

      return totalwater;
    }

    public static void main(String[] args) {
        
        int arr[][] = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1},{1,4,3,4,2,1}};
        System.out.println(trapping(arr));
    }    
}