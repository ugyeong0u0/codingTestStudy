import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

        static StringBuilder sb = new StringBuilder();
    static int [] visited; // 거리

    static int n, m, k, x;
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> maps = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 간선 개수
        k = Integer.parseInt(st.nextToken()); // 거리 정보
        x = Integer.parseInt(st.nextToken()); // 출발 도시 번호



        // 배열 초기화
        for(int i =0; i<=n ; i++){
            maps.add(new ArrayList<Integer>());
        }
        visited = new int [n+1];
        for (int i = 1; i <= n; i++) {
            visited[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            ArrayList<Integer> tmp =  maps.get(start);
            tmp.add(end);
        }

        q.offer(x);
        visited[x] = 0;

        while (!q.isEmpty()) {

            int tmp = q.poll(); // 노드 번호

            if(visited[tmp]>k){ //**** 더 돌 필요 없음
                break;
            }
            if(visited[tmp]==k) list.add(tmp);

            ArrayList<Integer> now = maps.get(tmp);

            for(int i = 0; i< now.size(); i++ ){
                int newNode = now.get(i);
                if(visited[newNode] != Integer.MAX_VALUE) continue; // 어차피 거리 비용이 1로 같기에 먼저 도착한게 젤 가까움 
                q.offer(newNode);
//                if(visited[newNode]>visited[tmp]+1){
                    visited[newNode] = visited[tmp]+1; 
//                }
            }
        }


//        for(int i =1 ; i<=n ;i++){
//            if(visited[i]==k){
//                list.add(i);
//            }
//        }

        Collections.sort(list);

        if(list.size()==0){
            System.out.println(-1);
        }else{
            for(int i= 0; i< list.size(); i++){
                sb.append(list.get(i)).append("\n");
            }
        }

        System.out.println(sb);

    }


}

