import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //    static StringBuilder sb = new StringBuilder();
    static int[] visited, arr; // 주어진

    static int n, max, m;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 수열 개수
        m = Integer.parseInt(st.nextToken()); // 수열 개수


        // 배열 초기화
//        arr = new int[n];
//        visited = new int[n]; // 숫자 방문

//        st = new StringTokenizer(br.readLine());


        dfs(0, "");

        Collections.sort(list);

//        for(String i : list){
//            System.out.println(i);
//        }

        if(list.size()>=m){
            String tmp = list.get(m-1);
            StringBuilder answer= new StringBuilder();
            for(int i = 0; i< tmp.length()-1;i++ ){
                answer.append(tmp.charAt(i)).append("+");
            }
            answer.append(tmp.charAt(tmp.length()-1));
            System.out.print(answer);

//            System.out.println(tmp);
        }else{
            System.out.println(-1);
        }


    }

    static void dfs( int sum, String s) {

        if (sum == n) {
            list.add(s);
            return;
        }

        for (int i = 1; i <= 3; i++) {

            if(sum+i<=n){
                dfs(sum+i, s+i);
            }
        }
    }
}

