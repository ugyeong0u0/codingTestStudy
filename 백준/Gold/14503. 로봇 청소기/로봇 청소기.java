import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

// 답지 봄

public class Main {
    static int n, m, answer;

    static int[][] maps;
    static int[] dx = {-1, 0, +1, 0};
    static int[] dy = {0, +1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken()); // 시작위치
        int cy = Integer.parseInt(st.nextToken());
        int cD = Integer.parseInt(st.nextToken()); //로봇이 보고 있는 방향

        answer = 1; // 안전영역 최대 개수, 시작점포함

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                maps[i][j] = a;

            }
        }

        dfs(cx, cy, cD); // 전으로 되돌릴 수 있음 => dfs

        System.out.println(answer);

    }

    static void dfs(int cx, int cy, int cD) {
        maps[cx][cy] = 2; // 현재칸 청소
//        System.out.println("cx : " + cx + "  cy : " + cy);
        for (int i = 0; i < 4; i++) {
            cD = (cD + 3) % 4;

            int nx = cx + dx[cD];
            int ny = cy + dy[cD];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 0) { // 청소 할 수 있는 곳이 있다면
                answer++;
                maps[cx][cy] = 2; // 현재칸 청소
                dfs(nx, ny, cD);
                return; // **
            }
        }

        int d = (cD + 2) % 4; // 반대방향
        int hX = cx + dx[d];
        int hY = cy + dy[d];
        if (hX>=0 && hY>=0 && hX<n && hY<m && maps[hX][hY] != 1) {
          dfs(hX,hY,cD); // 후진 후 청소 *****
        }


    }
}