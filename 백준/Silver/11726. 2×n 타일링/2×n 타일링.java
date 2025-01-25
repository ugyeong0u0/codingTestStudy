import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, answer;
    static int [] dp;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp= new int [n+1];



        dp[1] = 1;
        if (n>=2)
            dp[2] = 2;


        /**
         * dp[4] = 1+3, 2+2 = dp[3] + dp[2] = 5
         * dp[5] = 
         *
         */

        System.out.println(dfs(n));
    }

    static int dfs(int n ){

        if(dp[n]==0 && n>=3){
            dp[n]= (dfs(n-1)+dfs(n-2))%10007;
        }
        return dp[n];

    }
}
