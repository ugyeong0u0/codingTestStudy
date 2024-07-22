import java.util.*;
import java.io.*;


public class Main {


    static int number, target1, target2, kase, answer;
    static int[][] maps;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        kase = Integer.parseInt(br.readLine());

        maps = new int[number + 1][number + 1];
        visited = new int[number + 1];
        for (int i = 0; i < kase; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a][b] = 1;
            maps[b][a] = 1;

        }

        dfs(target1);
        answer = visited[target2];

        System.out.println(answer ==0 ? -1 :answer);

    }


    public static void dfs(int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(target);

        while (!q.isEmpty()) {

            int tmp = q.poll();


            if (target2 == tmp) {

                return;
            }

            for (int i = 1; i <= number; i++) {

                if (visited[i] == 0 && maps[tmp][i] == 1) {
                    q.offer(i);
                    visited[i] = visited[tmp]+1;
                }

            }

        }

    }
}


