import java.util.*;
import java.io.*;


public class Main {


    static int location, des;

    static int[] dp; // [자식의 번호] => 부모

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        location = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());

        dp = new int [100001];

        bfs(location);


        System.out.println(dp[des]-1);



    }

    public static void bfs(int su){
        Queue<Integer> q= new LinkedList<>();
        dp[su]=1;
        q.add(su);
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == des){
                return;
            }
            if( tmp-1 >=0 &&  dp[tmp-1]==0 ){
                dp[tmp-1] = dp[tmp]+1;
                q.add(tmp-1);
            }
            if(tmp+1 <=100000 &&  dp[tmp+1]==0  ){

                dp[tmp+1] = dp[tmp]+1;
                q.add(tmp+1);
            }
            if(tmp*2 <=100000 && dp[tmp*2]==0){

                dp[tmp*2] = dp[tmp]+1;
                q.add(tmp*2);

            }

        }




    }

}


