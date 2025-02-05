import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int n, m, answer;
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        visited = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {

            int k = Integer.parseInt(st.nextToken());

            int mid = (n-1)/2;

            int l = 0;
            int r = n-1;
            // 1 2 3 4 5

            while(r>=l){ // ***
//                System.out.println("  k:  "+k +  " l: "+ l+"   m: "  + mid + "  r: "+r);
                if(arr[mid]== k){ // ** mid == k 라고 작성함
                    visited[i]= 1;
                    break;
                }
                if(arr[mid]<k){
                    l= mid+1;
                    mid = (l+r)/2;
                }else{
                    r= mid-1;
                    mid = (l+r)/2;
                }

            }


        }

        for(int i : visited){
            System.out.println(i);
        }

//        System.out.println(arr[3/2]);



    }
}
