import java.util.*;
import java.io.*;


public class Main {
    static int  Kase,  N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Kase = Integer.parseInt(br.readLine());
        int [][] dp = new int [31][31];

        for(int i = 1 ; i<=30 ; i++){
            dp[i][0] = dp[i][i] =1;


            for(int j = 1; j<i; j++){
                dp [i][j] = dp[i-1][j-1] + dp[i-1][j]; // 전체에서 선택하는경우 + 전체에서 선택하지 않는 경우


            }

        }

        for(int i = 0 ; i<Kase ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);

        }

    }

}