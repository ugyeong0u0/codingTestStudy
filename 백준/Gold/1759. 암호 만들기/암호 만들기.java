import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static String [] dics;
    static String [] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        * 최소 한개의 모음 + 최소 두개의 자음, 사전순 정렬 abc는 가능 bac는 불가 => 조합 구성
        *  1. 사전 순으로 정렬 후 bfs 돌리는데 이때 위의 모음 1개 이상, 2개 이상 자음
        *
        * */

        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 4개 암호 만들기
        m = Integer.parseInt(st.nextToken()); // 주어진 문자 개수
        dics = new String [m];

        dics = br.readLine().split(" ");
        Arrays.sort(dics); // 오름차순
        tmp = new String[n];

        dfs(0,0);

        System.out.println(sb);

    }

    static void dfs(int dept, int next){

        if(dept == n){
            int s = 0;
            int l =0;
            StringBuilder sb2 = new StringBuilder();
            for(int i =0 ; i< n;i++){
                if(tmp[i].charAt(0)== 'a' || tmp[i].charAt(0)== 'e' ||tmp[i].charAt(0)== 'i' || tmp[i].charAt(0)== 'o' || tmp[i].charAt(0)== 'u'){
                    s++;
                }else{
                    l++;
                }
                sb2.append(tmp[i]);
            }
            if(s>=1 && l>=2){

                sb.append(sb2); // **
                sb.append("\n");
            }
            return;
        }


        for(int i =next; i< m ; i++){
            tmp[dept]=dics[i];
            dfs(dept+1, i+1);

        }


    }

}



