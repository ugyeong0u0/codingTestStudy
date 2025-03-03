import java.util.*;
import java.io.*;
class Main{
    static int n;
    static int dp[] = new int[11];
    
    public static void main(String args[]) throws IOException{
       
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n=Integer.parseInt(br.readLine());
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    
    for (int i =4; i<11; i++){
       dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    }
    for(int i =0; i<n;i++){
        int a = Integer.parseInt(br.readLine());
        System.out.println(dp[a]);
    }
        
    }
}