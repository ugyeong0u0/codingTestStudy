import java.util.*;
import java.io.*;


public class Main {

    static int answer, m, n, h; // m 가로
    static int[][][] maps, visited;
    static int[] dx = {-1, 0, 0, 0, 0, 1};
    static int[] dy = {0, 0, 0, 1, -1, 0};
    static int[] dz = {0, 1, -1, 0, 0, 0};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 열
        n = Integer.parseInt(st.nextToken()); // 행
        h = Integer.parseInt(st.nextToken()); // 높이

        answer = 0;
        maps = new int[n][m][h];
        visited = new int[n][m][h];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    maps[i][j][k] = Integer.parseInt(st.nextToken());

                    if(maps[i][j][k] == 1){
                        q.offer(new int[]{i, j, k});
                    }
                }
            }
        }



        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (maps[i][j][k] == 1 && visited[i][j][k]==0) {
                        bfs();
                    }
                }
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, visited[i][j][k]);
                }
            }
        }

        boolean flag = false;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(maps[i][j][k]==0){
                        flag = true;
                        break;
                    }
                }
            }
        }

        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }

    }

    static void bfs() {

        //q.offer(new int[]{Nrow, Ncol, Nh});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];
//            System.out.println("[" + a + " " + b + " " + c + "]");

            maps[a][b][c] = 1;

            for (int i = 0; i < 6; i++) {
                int nR = dx[i] + a;
                int nC = dy[i] + b;
                int nZ = dz[i] + c;


                if (nR >= 0 && nC >= 0 && nZ >= 0 && nR < n && nC < m && nZ < h && maps[nR][nC][nZ] == 0 && visited[nR][nC][nZ]==0 ) {
                    visited[nR][nC][nZ] = visited[a][b][c] + 1;
                    q.offer(new int[]{nR, nC, nZ});
                }
            }

            // maps log
//            for (int k = 0; k < h; k++) {
//                System.out.print(k + " -----------\n");
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < m; j++) {
//                        System.out.print(visited[i][j][k] + " ");
//                    }
//                    System.out.print("\n");
//                }
//                System.out.print("\n");
//            }
        }

    }
}


