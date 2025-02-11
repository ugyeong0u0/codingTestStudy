import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static int maps[]; // 순열 구성
    static int[] visited, arr; // 주어진
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 수 개수
        answer = Integer.MIN_VALUE;

        // 배열 초기화
        arr = new int [n];
        visited= new int [n];
        maps = new int [n];

        // 배열 입력값 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);


        System.out.println(answer);

    }
    static void dfs(int dept){
        if(dept == n){
            int tmp =  0;
                for(int i =2 ; i<= n; i++){
                    tmp += Math.abs(maps[i-2]- maps[i-1]);
                }
            answer = Math.max(answer, tmp);
            return;
        }

        for(int i = 0 ; i< n ; i++){
            if(visited[i]==0){
                visited[i]=1;
                maps[dept] = arr[i];
                dfs(dept+1);
                visited[i]=0;
            }

        }



    }



}
