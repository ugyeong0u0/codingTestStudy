import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a = new int[6];
    static StringBuilder sb = new StringBuilder();
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1;

        while (n != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수, 맨 앞 글자
            arr = new int[n];
            visited = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append("\n");


        }


        System.out.println(sb);

    }

    static void dfs(int dept, int next) {
        if (dept == 6) {
            for (int i : a) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = next; i < arr.length; i++) {
            if (visited[i]==0){
                visited[i]=1;
                a[dept] = arr[i];
                dfs(dept+1, i+1);
                visited[i]=0;
            }

        }

    }
}
