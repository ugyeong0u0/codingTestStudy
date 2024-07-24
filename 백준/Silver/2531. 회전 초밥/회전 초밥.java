import java.util.*;
import java.io.*;


public class Main {

    static int n, d, k, c;
    static int [] susi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        susi = new int[n];
        int [] visited= new int[d+1];
        for(int i = 0 ; i<n ;i++){
            susi[i]= Integer.parseInt(br.readLine());
        }

        int high=0;
        int max= 0;
        for(int i = 0; i< k ;i++){
            if(visited[susi[i]]==0){
                high++;
            }
            visited[susi[i]]++;
        }
        max=high;

        for(int i =0; i< n ;i++){ // n-1?
            // i =0부터 시작

            if(high>=max){ // **
                if(visited[c]==0) max =high +1 ;
                else max= high;
            }

            // 1. 전 원소 빼기
            visited[susi[i]]--;
            if(visited[susi[i]]==0){
                high--;
            }

            // 2. 뒤 원소 넣기
            if(visited[susi[(i+k)%n]]==0){ // ** 괄호!!
                high++;
            }
            visited[susi[(i+k)%n]]++;

        }


        System.out.println(max);


    }



}


