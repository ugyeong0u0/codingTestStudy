import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle {
    int st;
    int end;

    public Circle(int st, int end) {
        this.st = st;
        this.end = end;
    }
//    public String toString() {
//        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
//    }
}

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] dist; // 거리
//    static int[] visited; // 방문 여부

    static int t, n, m, count;

    //    static ArrayList<Circle> graph;
    //    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Circle> maps;
//    static PriorityQueue<Circle> pq = new PriorityQueue<>();

    static int[][] map;
    static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        t= Integer.parseInt(br.readLine()); // 테스트 케이스 개수


//        for(int i =0 ; i< t ; i++ ){ // 테스트 케이스만큼 반복
        StringTokenizer st;
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 도시 개수
        m = Integer.parseInt(br.readLine()); // 비행기 개수

//            dist = new int [n + 1];
//            maps = new ArrayList<>();
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = INF;
            }
        }


        // 비행기 개수 받기
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());


            map[s][e] = Math.min(map[s][e],cost);


        }
//        for (int j = 1; j <= n; j++) {
//            for (int k = 1; k <= n; k++) {
//                sb.append(map[j][k]).append(" ");
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {

//                        if(map[j][k]> map[j][i] + map[i][k]){
//                            map[j][k]= map[j][i] + map[i][k];
//                        }
                        map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }

        }

        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k++) {
                if(map[j][k]!=INF)
                    sb.append(map[j][k]).append(" ");
                else{
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


}

