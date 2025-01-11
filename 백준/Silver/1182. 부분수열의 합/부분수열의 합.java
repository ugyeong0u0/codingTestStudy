    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;


    public class Main {

        static int n, tar, answer;
        static int [] arr;

        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            tar = Integer.parseInt(st.nextToken());
            arr= new int [n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n ;i++){
                arr[i]= Integer.parseInt(st.nextToken());
            }

            answer=0;

            for(int i=1; i<= n ; i++ ){

                dfs(0,0, 0, i);

            }

            System.out.println(answer);


        }

        static void dfs(int next, int sum, int dept, int curD){

            if(dept ==curD && sum==tar){
                answer++;
                return;

            }

            for(int i =next ;i<n ;i++){

                dfs(i+1,sum+arr[i],dept+1, curD);

            }



        }


    }



