import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
/*
 *
 *
 * */

//class Loc{
//    int x;
//    int y, answer ;
//
//    public Loc (int x, int y){
//        this.x= x;
//        this.y=y;
//    }
//
//
//}

public class Main {

    static int row, col, n, line, answer, tar1, tar2, k;
    static int[][] maps;
    static int[] visited;
//    static ArrayList<Integer> list ;
//    static int [] dx = {0,0,-1,+1};
//    static int [] dy = {+1,-1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 사람
//        list = new ArrayList();
        StringTokenizer st = new StringTokenizer(br.readLine());

        tar1 = Integer.parseInt(st.nextToken());
        tar2 = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        answer = 0;
        maps = new int[n + 1][n + 1];
        visited = new int[n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a][b] = 1;
            maps[b][a] = 1;
        }

        dfs(tar1, 0);
        if (answer == 0) {
            System.out.println(-1);
        } else
            System.out.println(answer);

    }

    static void dfs(int node1, int count) {
//        System.out.println("n1"+node1);
        if (node1 == tar2) {
            answer = count;
//                System.out.println("끝"+answer);
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (maps[node1][i] == 1 && visited[node1] == 0) {
//                    System.out.println(node1 + " ,,"+count);
                visited[node1] = 1;
                dfs(i, count + 1);
                visited[node1] = 0;
            }

        }


    }

}
