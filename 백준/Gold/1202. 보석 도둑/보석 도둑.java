import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class Loc {
    int m; // 보석 무게
    int v; // 보석 가격

    Loc(int m, int v) {

        this.m = m;
        this.v = v;
    }
}


public class Main {

    static int n, k;
    static long answer;
    static Loc[] jew;
    static int visited[];
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 보석 총 개수
        k = Integer.parseInt(st.nextToken()); // 가방 개수

        jew = new Loc[n];
        bags = new int[k];

        visited= new int[n];
        for (int i = 0; i < n; i++) { // 보석 개수 담기
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()); // 보석 가격
            jew[i] = new Loc(m, v);
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jew, new Comparator<Loc>() { // 보석 가격은 내림차순 정렬, 보석 무게는 오름차순 정렬

            public int compare(Loc o1, Loc o2) {
                if (o1.m == o2.m) {
                    return o2.v - o1.v;
                }else{
                    return o1.m- o2.m;
                }

            }

        });

        answer = 0;

        PriorityQueue<Loc> pq = new PriorityQueue<>(new Comparator<Loc>(){

            public int compare(Loc o1, Loc o2){
                if(o1.v==o2.v){
                    return o1.m- o2.m;
                }else{
                    return o2.v- o1.v;
                }
            }
        }); // 보석 내림차순

        Arrays.sort(bags); // 가방은 오름차순 정렬

        int j = 0;
        for(int i = 0 ; i< k; i++){ // 가방 개수

            while(j<n && bags[i]>=jew[j].m){
//                System.out.println(jew[j].m);
                pq.offer(jew[j++]);
            }

            if(!pq.isEmpty()){

                Loc tmp = pq.poll();
                answer+= tmp.v;

            }

        }



        System.out.println(answer);



    }
}



