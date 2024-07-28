import java.util.*;
import java.io.*;


public class Main {


    static int answer = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visited;
    static Character[][] maps;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        maps = new Character[12][6];

        for (int i = 0; i < 12; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 6; j++) {
                maps[i][j] = tmp.charAt(j);
            }
        }


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                visited = new int[12][6];
                boolean flag = false;
                for (int u = 0; u < 12; u++) {
                    for (int y = 0; y < 6; y++) {
                        if (maps[u][y] != '.') {
//                    System.out.println(i + " ," + j);
                            q = new LinkedList<>();
                            dfs(u, y);
                            if (q.size() >= 4) {
                                flag = true;
                                while (!q.isEmpty()) {
                                    int[] tmp = q.poll();
                                    int a = tmp[0];
                                    int b = tmp[1];

                                    maps[a][b] = '.';
                                }
                            }
                        }
                    }
                }
                if (flag)
                    answer++;
                // 아이템 정렬
                for (int k = 0; k < 6; k++) {
                    for (int g = 11; g >= 0; g--) {
                        if (g - 1 >= 0)
                            for (int l = g - 1; l >= 0; l--) {

                                if (maps[g][k] == '.' && maps[l][k] != '.') {
                                    maps[g][k] = maps[l][k];
                                    maps[l][k] = '.';
                                    break;
                                }
                            }
                    }
                }

//                for (int q = 0; q < 12; q++) {
//
//                    for (int a = 0; a < 6; a++) {
//                        System.out.print(maps[q][a]);
//                    }
//                    System.out.println();
//                }
//                System.out.println("----------------");
            }

        }

        System.out.println(answer);

    }

    static void dfs(int start, int end) {
        q.offer(new int[]{start, end});
        visited[start][end] = 1;
        for (int i = 0; i < 4; i++) {

            int nx = dx[i] + start;
            int ny = dy[i] + end;

            if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && maps[start][end] == maps[nx][ny] && visited[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }

    }

}


