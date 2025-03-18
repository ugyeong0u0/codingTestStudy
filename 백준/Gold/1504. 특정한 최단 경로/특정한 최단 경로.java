import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle implements Comparable<Circle> {

    int end;
    int w;

    public Circle(int end, int w) {

        this.end = end;
        this.w = w;
    }

    public int compareTo(Circle o1) {
        return this.w - o1.w;
    }


}


public class Main {

    static int n, m; // 간선 개수
    static int s1, s2; // 반드시 거쳐야하는 정점 수

    static ArrayList<Circle>[] arr;
    static int INF = 500_000_000;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];


        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<Circle>();
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Circle(b, c));
            arr[b].add(new Circle(a, c));
        }

        st = new StringTokenizer(br.readLine());
        s1 = Integer.parseInt(st.nextToken());
        s2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        int answer2 = 0;

        answer1 += dickstra(1, s1);
        answer1 += dickstra(s1, s2);
        answer1 += dickstra(s2, n);

        answer2 += dickstra(1, s2);
        answer2 += dickstra(s2, s1);
        answer2 += dickstra(s1, n);
        int answer = 0;
        answer = Math.min(answer1, answer2);


        if (answer>=INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

        public static int dickstra(int s, int e){
            PriorityQueue<Circle> pq = new PriorityQueue<>();

            int[] visited = new int[n + 1];
            int[] dist = new int[n + 1];

            Arrays.fill(dist, INF);
            pq.offer(new Circle(s, 0));
            dist[s] = 0;


            while (!pq.isEmpty()) {

                Circle a = pq.poll();
//            System.out.println("현재   " + a.end + "거리 " + a.w);

                if(visited[a.end]==0) {
                    visited[a.end] = 1;
                    for (Circle tmp : arr[a.end]) {
                        if ( dist[tmp.end] > dist[a.end] + tmp.w) {
                            dist[tmp.end] = dist[a.end] + tmp.w;
                            pq.offer(new Circle(tmp.end,dist[tmp.end]));
                        }
                    }

                }


            }
            return dist[e];

        }


}