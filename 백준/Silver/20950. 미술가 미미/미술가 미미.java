import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int maps[][]; // 갖고 있는 물감의 개수
    static int[] visited, arr, target; // 해당 물감 사용했는지 여부
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 물감 개수
        answer = Integer.MAX_VALUE;

        // 배열 초기화
        maps = new int[n][3];
        target = new int[3];

        // 배열 입력값 넣기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[i][0] = r;
            maps[i][1] = g;
            maps[i][2] = b;

        }
        // 찾는 색
        StringTokenizer st = new StringTokenizer(br.readLine());
        target[0] = Integer.parseInt(st.nextToken());
        target[1] = Integer.parseInt(st.nextToken());
        target[2] = Integer.parseInt(st.nextToken());


        // 물감 조합하기 시작
        for (int i = 2; i <= 7; i++) {
            // 배열 초기화
            visited = new int[n];
            arr = new int[i];
            dfs(0, 0, i);

        }

        System.out.println(answer);

    }

    static void dfs(int deptNow, int next, int dept) {
        if (deptNow == dept) {
            int mr = 0;
            int mg = 0;
            int mb = 0;
            for (int i : arr) { // i는 물감 번호
                mr += maps[i][0];
                mg += maps[i][1];
                mb += maps[i][2];
            }
            answer = Math.min(answer, Math.abs(target[0] - mr/dept) + Math.abs(target[1] - mg/dept) + Math.abs(target[2] - mb/dept));
            return;
        }

        for (int i = next; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                arr[deptNow] = i;
                dfs(deptNow + 1, i + 1, dept);
                visited[i] = 0;
            }
        }

    }

}
