
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

// 답지 봄

public class Main {
    static int n, m, max;

    static int[][] maps;
    static int[] dx = {0, 0, -1, +1};
    static int[] dy = {+1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
      


        max = Integer.MIN_VALUE; // 안전영역 최대 개수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                maps[i][j] = a;

            }
        }
        dfs(0);

        System.out.println(max);

    }

    // 벽 세우기
    static void dfs(int wall) {

        if (wall == 3) { // **

            bfs(); // 바이러스 전파
            return;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { // ** visited 필요 없음
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    dfs(wall + 1);
                    maps[i][j] = 0; // ** 재귀
                }
            }
        }
    }

    // 바이러스 전파
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

            }

        }

        int [][] copyMap = new int [n][m];
        int [][] visited = new int [n][m]; // ** 이거 안하면 다음 루프때 문제 생김 
        for(int i = 0; i<n ; i++){
            copyMap[i] = maps[i].clone(); // **
        }

        while (!q.isEmpty()) {
            int [] tmp  = q.poll();
            visited[tmp[0]][tmp[1]] = 1; 
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + tmp[0];
                int ny = dy[i] + tmp[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && copyMap[nx][ny] == 0 && visited[nx][ny] == 0) {
                   visited[nx][ny]=1;
                   copyMap[nx][ny]=2;
                   q.offer(new int [] {nx,ny});
                }
            }

        }

        updateCnt(copyMap);

    }

    static void updateCnt(int[][] arr){
    int tmpMax = 0;
        for(int i= 0 ; i< n ;i ++ ){
            for(int j = 0 ; j< m ; j++){
//                System.out.print(arr[i][j]);
                if(arr[i][j]==0){
                   tmpMax++;
                }


            }
//            System.out.println();
        }

//        System.out.println("-------------------"+tmpMax);

        max= Math.max(tmpMax, max);

    }
}