import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int n;
    static int [][] dp ;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st= new StringTokenizer(br.readLine());


        n = Integer.parseInt(br.readLine());

        dp= new int [41][2];

        dp[0][0]=1;
        dp[0][1] =0;
        dp[1][0]=0;
        dp[1][1]=1;

        StringBuilder sb =new StringBuilder();
        for(int i = 0; i< n; i++){

            int k =  Integer.parseInt(br.readLine());

            sb.append(dfs(k,0)).append(" ").append(dfs(k,1)).append("\n");
        }

        System.out.println(sb);

    }

    public static int dfs(int k, int l){

        if(k>1 && dp[k][l]==0 ){
            dp[k][l]= dfs(k-1, l)+ dfs(k-2,l);
        }
//        System.out.print(k+ "의"+l+"은"+dp[k][l]);
        return dp[k][l];

    }
}
