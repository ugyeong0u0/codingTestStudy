import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, v, answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 주어진 카드
        arr = new int[n+1];
        v= new int [n+1];
        answer= new int [n];
        for(int i = 1; i<=n ; i++){
            arr[i]=i;
        }


        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int dept){

        if(dept==n){
            for(int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =1; i<= n ;i++){

            if(v[i]==0){
                v[i]=1;
                answer[dept]=i;
                dfs(dept+1);
                v[i]=0;

            }

        }


    }


}
