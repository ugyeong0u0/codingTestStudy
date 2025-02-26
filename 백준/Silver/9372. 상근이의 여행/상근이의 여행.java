import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle {
    int st;
    int end;

    public Circle( int st, int end) {
        this.st = st;
        this.end = end;
    }
//    public String toString() {
//        return   "->"+ end + " 비용: "+ cost + "   \\\\" ;
//    }
}

public class Main{

    static StringBuilder sb = new StringBuilder();
    static int [] dist; // 거리
//    static int[] visited; // 방문 여부

    static int t ,n, m, count;

//    static ArrayList<Circle> graph;
    //    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<Circle>maps;
//    static PriorityQueue<Circle> pq = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t= Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        for(int i =0 ; i< t ; i++ ){ // 테스트 케이스만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 변수 초기화
            n = Integer.parseInt(st.nextToken()); // 도시 개수
            m = Integer.parseInt(st.nextToken()); // 비행기 개수
            dist = new int [n + 1];
            maps = new ArrayList<>();
            for(int j = 1; j<= n; j++ ){ // 부모 배열 초기화
                dist[j] = j;
            }

            // 비행기 개수 받기
            for(int j =0 ; j< m ; j++) {
                st= new StringTokenizer(br.readLine());
                int s =Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                maps.add(new Circle(s,e));
            }
            count =0;
//            for(int j = 0; j< maps.size(); j++){
//                Circle tmp = maps.get(j);
//                int pa = find(tmp.st);
//                int pb = find(tmp.end);
//                if(pa != pb){
//                    if(pa> pb){
//                        dist[tmp.st] = pb;
//
//                    }else{
//                        dist[tmp.end] = pa;
//                    }
//                    count++;
//                }
//
//            }
            sb.append(n-1).append("\n");
        }
        System.out.println(sb);


    }

    static int find(int x ){
        if(dist[x] == x) return x;
        return dist[x]= find(dist[x]); // **
    }


}

