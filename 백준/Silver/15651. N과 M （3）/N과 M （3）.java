import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

//class Loc {
//    int m; // 보석 무게
//    int v; // 보석 가격
//
//    Loc(int m, int v) {
//
//        this.m = m;
//        this.v = v;
//    }
//}


public class Main {

    static int n, m;
    static StringBuilder answer;
    static int [] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 몇번째까지 구할지
        m = Integer.parseInt(st.nextToken());

        answer = new StringBuilder();
        arr= new int [m];
        /*
        *
        *
        * */
        boolean [] visited = new boolean[n+1];
        dfs(0);


        System.out.println(answer);


    }

    static void dfs(int dept){

        if(dept==m){
            for(int i = 0; i<dept; i++){
                answer.append(arr[i]).append(" ");
            }
            answer.append("\n");
            return;
        }

        for(int i=1; i<=n ; i++){
//            if(!v[i]){
//                v[i]=true;
            arr[dept] = i;
            dfs(dept+1);
//                v[i] =false;
//            }
        }



    }
}



