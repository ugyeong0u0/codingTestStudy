import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle implements Comparable<Circle> {
//    int st;
    int end;
    int cost;

    public Circle( int end, int cost) {
//        this.st = st;
        this.end = end;
        this.cost = cost;
    }

    public int compareTo(Circle tmp) {
        return this.cost - tmp.cost;
    }
    public String toString() {
        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] dist; // 거리
    static int[] visited; // 방문 여부

    static int n, m, a, b;

    static ArrayList<Circle> graph;
    //    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<ArrayList<Circle>> maps;
    static PriorityQueue<Circle> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 도시 개수
        m = Integer.parseInt(br.readLine()); // 간선 개수

        // 배열 초기화
        graph = new ArrayList<>();
        dist = new int[n + 1];
        maps = new ArrayList<>();
        visited = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            maps.add(new ArrayList<>()); // **
        }


        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());
            int o3 = Integer.parseInt(st.nextToken());

            maps.get(o1).add(new Circle(o2, o3));


        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); // 출발지
        b = Integer.parseInt(st.nextToken()); // 도착지

        pq.offer(new Circle(a, 0));
        dist[a] = 0;

        while (!pq.isEmpty()) {
            Circle now = pq.poll();
            if (visited[now.end] ==0) {
                visited[now.end] = 1;
                for (Circle tmp :maps.get(now.end)) {
                    if(visited[tmp.end]==0 && dist[tmp.end]> dist[now.end]+ tmp.cost)  {
                        dist[tmp.end] = dist[now.end] + tmp.cost;
                        pq.offer(new Circle(tmp.end, dist[tmp.end]));
                    }
                }
//                System.out.println("현재 우선순위 큐 요소: " + Arrays.toString(pq.toArray()));
            }

            if(now.end == b){
                System.out.println(dist[b]);
                return;
            }
        }


//        System.out.println(dist[b]);
    }


}

