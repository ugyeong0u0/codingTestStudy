import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int n, m,  answer;
    static int []  dp ;
    static StringBuilder [] nums;
    static Queue<Integer> q= new LinkedList<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st= new StringTokenizer(br.readLine());


        n = Integer.parseInt(br.readLine());

        nums = new StringBuilder [n+1];
        dp = new int [n+1];

        dp[n]=0;
        nums[n] = new StringBuilder().append(n).append(" ");

        q.add(n);

        while(!q.isEmpty()){

            int t = q.poll();

            if(t==1){
                break;
            }

            if(t%3==0&& dp[t/3]==0){
                dp[t/3] = dp[t]+1;
                nums[t/3] = new StringBuilder().append(nums[t]).append(t/3).append(" ");
                q.add(t/3);
            }
            if(t%2==0 && dp[t/2]==0){
                dp[t/2] = dp[t]+1;
                nums[t/2] = new StringBuilder().append(nums[t]).append(t/2).append(" ");
                q.add(t/2);
            }
            if(t-1>=1&& dp[t-1]==0){
                dp[t-1] = dp[t]+1;
                nums[t-1] = new StringBuilder().append(nums[t]).append(t-1).append(" ");
                q.add(t-1);
            }
        }

        System.out.println(dp[1]);
        System.out.println(nums[1]);







    }
}
