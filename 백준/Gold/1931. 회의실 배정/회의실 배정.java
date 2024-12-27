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
    static String nn;
    static loc []visited;
//    static int [] visited2;
//    static int [] ddx ={0,0,1,-1};
//    static int [] ddy ={1,-1,0,0};
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st =new StringTokenizer(br.readLine());

        n =Integer.parseInt(br.readLine());
//        m = Integer.parseInt(st.nextToken()); // 총 가격 4200

//        sum = 0;

        visited = new loc[n];

        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a  = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());

            visited[i]=new loc(a,b);

        }

        Arrays.sort(visited, new Comparator<loc>(){
            public int compare(loc a, loc b){
                if(a.y==b.y){
                    return a.x-b.x;
                }else{
                    return a.y-b.y;    
                }
                
            }

        }); // 회의 시간 잛은거로 정렬

        int now =0; // 현재 회의가 끝난 시간
        answer=0;
        for(int i =0 ;i< visited.length;i++){
            loc tmp = visited[i];
            if(now<=tmp.x){
                now= tmp.y;
//                System.out.println(now);
                answer++;

            }


        }




        /*
        * 1. 회의 정렬을 하면 될거 같음
        * - 회의 시간이 짧은거먼저
        * - 해당 회의 끝난 후 다음 회의 시작 보기

        * */




        System.out.println(answer);





    }


//    static void dfs(int idx, int change, int dept){
//
//        if(change==0){
//            answer= Math.min(answer, dept);
//            return;
//        }
//
//        for(int i = idx; i>=0 ;i--) {
//            int k = change / visited[i];
//            if (k > 0) {
//                dfs(i-1, change - visited[i]*k, dept +k);
//
//            }else{
//                if(i-1>=0)
//                    dfs(i-1, change, dept); // ** 처음에 빼먹음
//            }
//        }
//    }


}
