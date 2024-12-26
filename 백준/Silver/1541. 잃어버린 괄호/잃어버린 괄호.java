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
    static int []visited;
//    static int [] visited2;
//    static int [] ddx ={0,0,1,-1};
//    static int [] ddy ={1,-1,0,0};
//    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st =new StringTokenizer(br.readLine());

        nn = br.readLine();
//        m = Integer.parseInt(st.nextToken()); // 총 가격 4200

//        sum = 0;


        answer = 0;
        int idx = 0;
        for(int i =0; i<nn.length();i++){
            if(nn.charAt(i)== '-'){
                idx =i; // -가 나온 idx
                break;
            }
        }


        int fir = 0;
        int two = 0;
        if(idx!=0 ){

            String a = nn.substring(0,idx);
            String[] b= a.split("\\+");

            String [] c = nn.substring(idx,nn.length()).split("\\-|\\+");

            for(int i=0; i<b.length ; i++ ){
//                System.out.print(b[i]);
                fir+= Integer.parseInt(b[i]);
            }
//            System.out.print("    ");
            for(int i=1 ; i<c.length ;i++){
//                System.out.print(c[i]);
                two += Integer.parseInt(c[i]);

            }

            answer = fir- two;
        }else{
            String [] k = nn.split("\\+");
            for(int i =0; i<k.length; i++){
                answer += Integer.parseInt(k[i]);
            }

        }





        /*
        *1. -를 발견하면 -부터 끝까지 먼저 합해버리기
        * 2. 스프릿 한 나머지 부분 더하기
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
