    import java.util.*;
    import java.io.*;

    class G{
        int st;
        int end;
        int cost;

        public G(int st, int end, int cost){
            this.st = st;
            this.end = end;
            this.cost = cost;
        }


    }
    public class Main {
        static int n, m, r;
        static int [] map;
        static int [] [] arr;

        static int INF = 16;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지역의 개수
            m = Integer.parseInt(st.nextToken()); // 수색범위
            r= Integer.parseInt(st.nextToken()); // 길의 개수
            map = new int [n+1];
            arr= new int [n+1][n+1];
            int [] answer = new int [n+1];
            int [][] visited = new int [n+1][n+1];


            st = new StringTokenizer(br.readLine());
            for(int i =1; i<= n; i++){
                map[i]= Integer.parseInt(st.nextToken());
            }
            for(int i =1 ; i<=n ; i++){
                for(int j = 1; j <=n ; j++){
                    if(i==j) continue;
                    arr[i][j] = INF;

                }

            }


            for(int i =0 ; i< r ; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[a][b]= c;
                arr[b][a]= c;

            }



            for(int i =1; i <=n; i++){
                for(int j = 1; j<=n ; j++){
                    for(int k= 1; k<=n ; k++){
                        if(arr[j][i]+arr[i][k] < arr[j][k] ){
//                            System.out.println("m "+ m);
//                            if(visited[j][k]==0){ // 있으면 1->2 ->3 과 1->4 ->3 이거 비교 불가함

//                                visited[j][k]=1;

//                                System.out.print( j+ " -> "+ i  + "  " +i + " -> "+k + " : " +arr[j][i] + "   +  "+arr[i][k] + "    "+ "   vs "  + arr[j][k]  );
//                                System.out.println();
                                arr[j][k] = arr[j][i]+arr[i][k];
//                                System.out.println(j +"  "+ answer[j]);
                            }
//                        }

                    }
                }
            }
            int answer2 = 0;
            for(int i = 1; i<= n ; i++){
                int sum = 0;
                for(int j =1; j<=n ; j++){
                    if(m >= arr[i][j]){
                        sum+=map[j];
                    }

                }
                answer2 = Math.max(sum, answer2);
            }

            System.out.println(answer2);

        }
    }