import java.util.*;
import java.io.*;

class Loc {

    int x;
    int y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    static int n, k;
    static int[]map;
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        map= new int [n+1];
        dp = new int [k+1];

        for(int i = 1 ; i< n+1 ; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1 ; i< k+1 ; i++){
            dp[i] = 1_000_000;
        }

        for(int i =1; i<=n ; i++){
            for(int j = map[i]; j<=k ;j++){ // 1 5 12 ... 15
                dp[j] = Math.min(dp[j], dp[j-map[i]]+1);
            }
        }



        if(dp[k]==1_000_000){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }



    }
}