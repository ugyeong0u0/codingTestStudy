    import java.util.*;
    import java.io.*;

    class G implements Comparable<G>{
        int st;
        int end;
        int cost;

        public G(int st, int end, int cost){
            this.st = st;
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(G o1){
            return this.cost- o1.cost;
        }


    }
    public class Main {
        static int n, m, r;
        static int [] map;
        static int [] answer;

        static ArrayList<G> [] maps;
        static int INF = 16;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지역의 개수
            m = Integer.parseInt(st.nextToken()); // 수색범위
            r= Integer.parseInt(st.nextToken()); // 길의 개수
            maps = new  ArrayList [n+1];
            answer = new int [n+1];

            for(int i =1 ; i<=n ; i++){

                maps[i] = new ArrayList<G>();

            }


            map = new int [n+1];




            st = new StringTokenizer(br.readLine());
            for(int i =1; i<= n; i++){
                map[i]= Integer.parseInt(st.nextToken());
            }



            for(int i =0 ; i< r ; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                maps[a].add(new G(a,b,c));
                maps[b].add(new G(b,a,c));

            }

            int [] answer3 = new int [n+1];

            for(int i =1 ; i<=n ; i++){




                bfs(i);
                int sum =0;
                for(int j=1 ; j<= n ; j++){
                    if(m>= answer[j]){
                        sum+=map[j];
                    }

                }
                answer3[i]= sum;
            }
            int answer2 = 0;
            for(int i = 1 ;i <= n ; i++){

                answer2 = Math.max(answer2, answer3[i]);
            }

            System.out.println(answer2);
        }

        static void bfs(int start){
            PriorityQueue<G> pq = new PriorityQueue<>();
            int [] visited = new int[n+1];
            answer = new int[n+1];

            for(int i =1; i<= n ; i++){
                answer[i]= INF;
            }

            pq.offer(new G(start,start,0));
            answer[start]=0;

            while(!pq.isEmpty()){

                G tmp = pq.poll();
                int cur = tmp.end;
                int cost = tmp.cost;
                if(visited[cur]==1) continue;
                visited[cur] = 1;

                for(G now  : maps[cur]){

                    if(visited[now.end]==0 && answer [now.end] > answer[cur]+now.cost ){
                        answer[now.end] = answer[cur]+now.cost;
                        pq.offer(new G(now.st, now.end, answer[now.end]));
                    }

                }
            }





        }
    }