import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Circle{
    int st;
    int end ;
    int cost;

    public Circle(int st, int end,int cost){
        this.st = st;
        this.end = end ;
        this.cost =cost;
    }

}

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int [] dist; // 거리

    static int n, m, a, b;

    static ArrayList<Circle> graph;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 도시 개수
        m = Integer.parseInt(br.readLine()); // 간선 개수

        // 배열 초기화
        graph = new ArrayList<>();
        dist = new int [n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        StringTokenizer st;
        for(int i =0; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int o1= Integer.parseInt(st.nextToken());
            int o2= Integer.parseInt(st.nextToken());
            int o3= Integer.parseInt(st.nextToken());

            graph.add(new Circle(o1,o2,o3));
        }


        st = new StringTokenizer(br.readLine());
        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());


        dist[a] =0;

        for(int i = 0; i<n; i++){
            for(int j =0 ; j< m ;j++){

                Circle tmp = graph.get(j);

                if(dist[tmp.st]!=Integer.MAX_VALUE && dist[tmp.end] > dist[tmp.st]+tmp.cost){
                    dist[tmp.end] = dist[tmp.st]+tmp.cost;
                }

            }
        }


        System.out.println(dist[b]);

    }


}

