import java.util.*;
import java.io.*;

class G implements Comparable<G> {
    int st;
    int end;
    int cost;

    public G(int st, int end, int cost) {
        this.st = st;
        this.end = end;
        this.cost = cost;
    }

    public int compareTo(G o1) {
        return this.cost - o1.cost;
    }


}

public class Main {
    static int n, m;
    static int[][] map; // 주어진
    static int[][] dp; // 정답
    static int[][] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        tmp = new int[m][2]; // 위로는 못가서 이차원으로 가능
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
//                    dp[i][j][0] = map[i][j];
            }
        }


        dp[0][0] = map[0][0];
//        tmp[0][0] = dp[0][0];
        for (int i = 1; i < m; i++) { // 첫행은 오른쪽으로만 감

            dp[0][i] = dp[0][i-1]+ map[0][i]; // *

        }


        for (int i = 1; i < n; i++) {

            tmp[0][0] = dp[i-1][0]+map[i][0];

            // 위랑 왼쪽 비교, 아래에서는 못올라와서 같은 행끼리만 비교하면 됨
            for (int j = 1; j < m; j++) { // 행

                tmp[j][0] = Math.max(dp[i - 1][j], tmp[j - 1][0]) + map[i][j]; // ? tmp[j - 1][0]

            }

            tmp[m-1][1] = dp[i-1][m-1]+ map[i][m-1];
            // 위랑 오른쪽에서 오는거 비교, 오른쪽에서 오는거라 m-2부터 시작
            for (int j = m - 2; j >= 0; j--) {

                    tmp[j][1] = Math.max(dp[i - 1][j], tmp[j + 1][1]) + map[i][j]; // ? tmp[j + 1][1]

            }

            // 가장 큰 값 구하기

            for (int j = 0; j < m; j++) {

                dp[i][j] = Math.max(tmp[j][0], tmp[j][1]);
            }

        }

        System.out.println(dp[n - 1][m - 1]);


    }
}