import java.util.*;
import java.io.*;


public class Main {


    static int n;

    static int[][] arr;
    static int [] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        dp= new int [n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a; // day
            arr[i][1] = b; // pay
        }

        for(int i =0 ;i<n ;i++){

            if(i+arr[i][0] <= n){ // ** <=인데 <로 작성함...ㅁ
                dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], arr[i][1]+dp[i]); // 몇일 후의 pay = 몇일 후 페이랑 현재 i일 + 몇일 후 pay 중 큰거
            }

            dp[i+1]= Math.max(dp[i], dp[i+1]); // 전의 pay가 다음 pay에 유지돼야함

        }

        System.out.println(dp[n]); // n+1개 배열이니 n까지 만들어짐


    }


}