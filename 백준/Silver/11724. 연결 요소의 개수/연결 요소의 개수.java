import java.util.*;
import java.io.*;

public class Main {

    static int v, line;
    static int[][] maps;
    static int[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        maps = new int[v + 1][v + 1];
        visited = new int[v + 1];


        for (int i = 0; i < line; i++) {
            st =new StringTokenizer( br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a][b] = 1;
            maps[b][a] = 1;

        }

        for (int i = 1; i <= v; i++) {

            if(visited[i]==1){
                continue;
            }

            for (int j = 1; j <= v; j++) {

                if (maps[i][j] == 1 && visited[j] == 0) {

                    dfs(i);
                }

            }

            answer++; // 밖 for문에 있어야함!!

        }


        System.out.println(answer);


    }

    static void dfs(int x) {
        visited[x] = 1;

        for (int i = 1; i <= v; i++) {
            if (maps[x][i] == 1 && visited[i] == 0) {

                dfs(i);

            }

        }


    }
}