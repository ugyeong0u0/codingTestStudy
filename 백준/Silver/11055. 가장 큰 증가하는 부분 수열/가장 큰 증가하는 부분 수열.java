import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;
    static int[] dp, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        dp = new int[n];
        visited = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int k = Integer.parseInt(st.nextToken());

            dp[i] = k;
        }

        visited[0] = dp[0];



        for (int i = 1; i < n; i++) {
            visited[i]=dp[i];
            for (int j = 0; j < i; j++) {
                if (dp[i]>dp[j]) {
                    visited[i] = Math.max(visited[j]+dp[i], visited[i]);
                }
            }

        }

        for(int a : visited){
            answer = Math.max(answer, a);
        }

        System.out.println(answer);

    }
}
