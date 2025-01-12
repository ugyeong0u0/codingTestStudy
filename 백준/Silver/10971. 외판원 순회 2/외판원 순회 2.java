import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n; // 가장 비용 적게 모든 도시 순환
    static long answer;
    static int[][] map;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine()); // 도시 개수
        map = new int[n][n];
        visited = new int[n]; // 방문한 도시 표시
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = Long.MAX_VALUE;

        /*
         * 1. 한번 간 도시는 갈 수 없음
         * 2. visited로 방문한 곳 표시
         *
         * 0번 4번 도시가 있다면
         * 1. 0번부터 가보기
         * 2. 1번부터 가보기
         * 3. 2번부터 가보기
         * ... => 0123, 0213 순열 구성임
         *
         * bfs인데 if문 브레이크는 이미 나온 최솟값보다 커버리면 break;
         * 도시로 다시 못 올경우도 break;
         *
         * */


        for (int i = 0; i < n; i++) {

            visited[i] = 1;
            int first = i;
//            System.out.println("시작 : " + i);
            dfs(1, first, 0, i);

            visited = new int[n];

        }

        System.out.println(answer);


    }

    static void dfs(int dept, int first, int sum, int prev) {
//        System.out.println(dept);
        if (answer < sum) {
//            System.out.print( " 중간탈락" + prev+ "   sum: "+ sum+" / " +answer );
            return;
        }
        if (dept == n) {

            if (map[prev][first] != 0){
//                System.out.print( "마지막 " + first);
//                sum ;

                answer = Math.min(answer, sum+ map[prev][first]);}


//            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && map[prev][i] != 0) { // 방문전이고 방문 가능하면
//                System.out.print("    "+i+"    "+ "dept"+dept);
                visited[i] = 1;
                dfs(dept + 1, first, sum +map[prev][i], i);
//                System.out.println();
                visited[i] = 0;
            }
        }
//        if (map[prev][first] != 0)
//            dfs(dept + 1, first, sum += map[prev][first], prev);

    }
}



