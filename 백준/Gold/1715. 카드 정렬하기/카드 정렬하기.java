import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class loc {
    int x;
    int y;

    loc(int x, int y) {

        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int n, answer, to;
    //    static char[][] maps;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


//        visited = new int[n];
        Queue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(br.readLine());
//            visited[i] = a;
            pq.offer(a);

        }
        answer = 0;
        to = 0; // 몇 번 섞는지
//        Arrays.sort(visited);

        /*
         * 1. 장수는 게속 pq에 넣고 두 개 씩 빼서 다시 넣기
         * 2. 번은 따로 변수 둬서 계속 기존값에 더하기
         * */

        for (int i = 0; i < n - 1; i++) {

            int x1 = pq.poll();
            int x2 = pq.poll();

            int tmp = x1 + x2;
            to += tmp;

            pq.offer(tmp);
        }

        System.out.println(to);
    }


}



