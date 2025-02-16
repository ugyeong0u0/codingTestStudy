import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    static StringBuilder sb = new StringBuilder();
    static int[] visited, arr; // 주어진

    static int n, max;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 변수 초기화
        n = Integer.parseInt(st.nextToken()); // 수열 개수
        max= Integer.MIN_VALUE;


        // 배열 초기화
        arr = new int[n]; // 숫자 0- 9까지 만든것
        visited = new int[n]; // 숫자 방문

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n;i++){
            arr[i]= (Integer.parseInt(st.nextToken()));
        }

        dfs(0,0);

        System.out.println(max);

    }

    static void dfs(int dept, int sum) {

        if (dept == n-2) {
            max= Math.max(max, sum);
            return;
        }

        for (int i = 1; i <= n-2; i++) {
            if(visited[i]==0){
                visited[i]=1;
                int first= 0;
                for(int j =i-1; j>=0;j--){
                    if(visited[j]==0){
                        first=j;
                        break;
                    }
                }
                int last=n-1;
                for(int k = i+1; k<n; k++){
                    if(visited[k]==0){
                        last=k;
                        break;
                    }
                }
                dfs(dept+1, sum+(arr[first]*arr[last]));
                visited[i]=0;
            }
        }
    }
}
