import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle implements Comparable<Circle> {
    int st;
    int w;

    public Circle(int st, int w) {
        this.st = st;
        this.w = w;
    }

    public int compareTo(Circle tmp) {
        return w - tmp.w;
    }


//    public String toString() {
//        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
//    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] dist; // 거리
    static int t, n, m, count, startNode;
    static ArrayList<Circle>[] maps;
    static int[] check;

    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 비행기 개수
        startNode = Integer.parseInt(br.readLine());
        check = new int[n + 1];

        dist = new int[n + 1];
        maps = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i <= n; i++) {
            maps[i] = new ArrayList<>(); // **
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 도시 개수
            int b = Integer.parseInt(st.nextToken()); // 비행기 개수
            int w = Integer.parseInt(st.nextToken()); // 비행기 개수
            maps[a].add(new Circle(b, w));
        }

        dist[startNode]= 0;

        PriorityQueue<Circle> pq = new PriorityQueue<>();
        pq.offer(new Circle(startNode, 0));

        while (!pq.isEmpty()) {
            Circle tmp = pq.poll();
//            check[tmp.st] = 1;

            for (Circle next : maps[tmp.st]) {
                if (dist[tmp.st] != INF && dist[next.st] > dist[tmp.st] + next.w) {
                    dist[next.st] = dist[tmp.st] + next.w;
                    pq.offer(new Circle(next.st,dist[next.st]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}

