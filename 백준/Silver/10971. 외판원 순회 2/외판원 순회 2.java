
import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.StringTokenizer;
import java.util.*;
/*
 *
 *
 * */

public class Main {

    static int n;
    static long answer, sum;
    static ArrayList[] maps;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        maps = new ArrayList[n];
        visited = new int[n];

        for (int i = 0; i < n; i++) { // 테케
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            maps[i] = list;

        }


        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            visited = new int[n];
            sum = 0;
            dfs(i, i);

        }


        System.out.println(answer);

    }

    static void dfs(int start, int now) {
//        System.out.print(" now  "+ now+" ->" );
        ArrayList<Integer> tmp = maps[now]; // 0 행
        visited[start] = 1;
        boolean allVisited = true;
        for (int j = 0; j < n; j++) {
            if (visited[j] != 1) {
                allVisited = false;
            }
        }

        if (allVisited) {
            int a = tmp.get(start);
            if (a == 0) {
                return;
            }

            answer = Math.min(sum + a, answer);
//            System.out.println("sum : "+ sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            int a = tmp.get(i);
            if (visited[i] != 1 && i != start && a!=0) {
                visited[i] = 1;
                sum += a;
                dfs(start, i);
                visited[i] = 0;
                sum -= a;
            }

        }


    }


}
