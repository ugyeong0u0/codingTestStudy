import java.util.*;
import java.io.*;


public class Main {

    static int n;
    static int[][] maps, visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {+1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new int[n][n];
        maps = new int[n][n];
        int max = 0;  // 가장 높은 높이
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, maps[i][j]);
            }
        }
        int result =0;
        for (int i = 0; i <= max; i++) {
            int count= 0;
            visited= new int [n][n]; // **
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    if (maps[k][j] > i && visited[k][j] == 0) {
                        dfs(k, j, i);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);


        }

        System.out.println(result);

    }

    static void dfs(int st, int end , int high) {
        visited[st][end]=1;

        for (int i = 0; i < 4; i++) {

            int nx = st + dx[i];
            int ny = end + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && maps[nx][ny] > high) {
                dfs(nx,ny, high);
            }


        }


    }

}


