import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] dp = new int[n];  // dp[i] : i번째 원소를 마지막으로 하는 가장 큰 증가하는 부분 수열의 합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = A[i]; // 초기값은 자기 자신
        }

        int answer = dp[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) { // 증가하는 부분 수열 조건
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            answer = Math.max(answer, dp[i]); // 최댓값 갱신
        }

        System.out.println(answer);
    }
}
