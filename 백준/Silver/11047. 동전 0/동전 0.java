import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class loc{
    int x;
    int y;

    loc(int x, int y){

        this.x=x;
        this.y=y;
    }
}


public class Main {

    static int n, answer, sum, m;
//    static char[][] maps;
    static int []visited;
//    static int [] visited2;
//    static int [] ddx ={0,0,1,-1};
//    static int [] ddy ={1,-1,0,0};
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 테케 수 10
        m = Integer.parseInt(st.nextToken()); // 총 가격 4200

        answer = Integer.MAX_VALUE;
//        sum = 0;

        visited = new int[n]; // 지폐 값


        for(int i= 0; i<n; i++){
            visited[i] = Integer.parseInt(br.readLine());
        }
//        Arrays.sort(visited);


        /*
        *1. for문을 통해 현재 지폐가 값에 쓰일 수 있는지
        * 있다면 dfs 또 보내기(단 현재 빼고 남은게 현재 지폐보다 크면 안됨)
        *2. dfs(현재 지폐 인덱스 번호, 남은 금액, 사용한 지폐 )
        *3. break 문은 현재 지폐가격일때
        * */

        dfs(n-1, m,0);

//        if(answer )

        System.out.println(answer);





    }


    static void dfs(int idx, int change, int dept){

        if(change==0){
            answer= Math.min(answer, dept);
            return;
        }
//        System.out.println("visited[idx] "+ visited[idx]+ " change :  "+ change);

        for(int i = idx; i>=0 ;i--) {
            int k = change / visited[i];
            if (k > 0) {

//                System.out.println("visited[idx]   "+ visited[i]+ "    change :  "+ change +  "   k  " +k);
                dfs(i-1, change - visited[i]*k, dept +k);

            }else{
                if(i-1>=0)
                    dfs(i-1, change, dept);
            }
        }
    }


}
