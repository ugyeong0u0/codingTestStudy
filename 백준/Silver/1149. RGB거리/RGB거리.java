import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static int[][] h;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;


        h = new int[n][3];
        visited = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h[i][0] = Integer.parseInt(st.nextToken());
            h[i][1] = Integer.parseInt(st.nextToken());
            h[i][2] = Integer.parseInt(st.nextToken());


        }



        visited[0][0] = h[0][0];
        visited[0][1] = h[0][1];
        visited[0][2] = h[0][2];

        /**
         * 1에서 빨간색을 선택하면
         * 2에선 g나 b를 선택해야함
         * dp[2][red] = min(dp[1][g], dp[1][b]) + dp [2][r];
         * dp[2][g] = min(dp[1][r], dp[1][b]) + dp [2][g];
         * dp[2][b]=
         *
         *
         */
        System.out.println(Math.min(recur(0, n - 1), Math.min(recur(1, n - 1), recur(2, n - 1))));


    }

    public static int recur(int color, int lv) {
        if (visited[lv][color]==0) {

            if (color == 0) {
                visited[lv][0] = Math.min(recur(1, lv - 1), recur(2, lv - 1))+h[lv][0];
            } else if (color == 1) {
                visited[lv][1] = Math.min(recur(0, lv - 1), recur(2, lv - 1))+h[lv][1];
            } else {
                visited[lv][2] = Math.min(recur(0, lv - 1), recur(1, lv - 1))+h[lv][2];
            }
        }
        return visited[lv][color];

    }
}

