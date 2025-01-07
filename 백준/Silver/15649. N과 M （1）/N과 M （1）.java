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

    static int n, m;
    static ArrayList<String > answer;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 몇번째까지 구할지
        m = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();

        /*
        * 총 4자리를 구한다 했을 때 = 순열
        * 첫번재 자리에 1~4까지 들어갈 수 있고
        * 두번째 자리에 1~4까지 중 이용하지 않은 수가 들어갈 수 있음
        * ...
        * 1부터 돌리는거임 visited를 사용해서 dfs 돌리기
        *
        *
        * */
        boolean [] visited = new boolean[n+1];
        dfs(visited, "", 0);


        for(int i =0; i<answer.size(); i++){
            String tmp = answer.get(i);
            for(int j = 0 ; j< answer.get(i).length(); j++){
                System.out.print(tmp.charAt(j));
            }
            System.out.println();

        }

    }

    static void dfs(boolean [] v, String tmp, int dept){

        if(dept==m){
            answer.add(tmp);
            return;
        }

        for(int i= 1; i<=n ; i++){
            if(!v[i]){
                v[i]=true;
                if(tmp.equals("")){
                    dfs(v, tmp+i, dept+1 );
                }else{
                    dfs(v, tmp+" " +i, dept+1 );
                }

                v[i] =false;
            }
        }



    }
}



