import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle {
    int st;
    int end;
    int cost;

    public Circle( int st, int end, int cost) {
        this.st = st;
        this.end = end;
        this.cost = cost;
    }
    public String toString() {
        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();
    static long [] dist; // 거리
//    static int[] visited; // 방문 여부

    static int n, m, a, b;

//    static ArrayList<Circle> graph;
    //    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Circle>maps;
//    static PriorityQueue<Circle> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 버스 개수

        // 배열 초기화
//        graph = new ArrayList<>();
        dist = new long [n + 1];
        maps = new ArrayList<>();
//        visited = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

//        for (int i = 0; i <= n; i++) {
//            maps.add(new ArrayList<>()); // **
//        }



        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o1 = Integer.parseInt(st.nextToken());
            int o2 = Integer.parseInt(st.nextToken());
            int o3 = Integer.parseInt(st.nextToken());
            maps.add(new Circle(o1, o2, o3));
        }

        dist[1]=0;

       for(int i =0 ; i< n ; i++){ // 도시 개수
           for(int j =0; j< m; j++){ // 버스개수

               Circle tmp = maps.get(j);

               if(dist[tmp.st]!= Integer.MAX_VALUE && dist[tmp.end]> dist[tmp.st] + tmp.cost){
                   dist[tmp.end] = dist[tmp.st] + tmp.cost;
               }
           }
       }

       for(int i =0; i< m; i++){
           Circle tmp = maps.get(i);
            if(dist[tmp.st]!= Integer.MAX_VALUE && dist[tmp.end]> dist[tmp.st] + tmp.cost){
                System.out.println(-1);
                return;
            }
        }


       for(int i=2; i<=n;i++){
           if(dist[i]!=Integer.MAX_VALUE){
               sb.append(dist[i]);
           }else{
               sb.append(-1);
           }
           sb.append("\n");
       }

        System.out.println(sb);






    }


}

