import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int maps[]; // 순열 구성
    static int[] visited, arr; // 주어진
    static String[] divides;
    static int n;
    static String min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 변수 초기화
        n = Integer.parseInt(br.readLine()); // 부등호 개수
        min = "999999999";
        max = "000000000";

  // 배열 초기화
        arr = new int[n + 1]; // 숫자 0- 9까지 만든것
        visited = new int[10]; // 숫자 방문
        divides = new String[n]; // 부등호

        // 배열 입력값 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            divides[i] = st.nextToken();
        }

        dfs(0);


        System.out.println(max + "\n" + min);
//        System.out.println(maxM);
    }

    static void dfs(int dept) {
        if (dept == n + 1) { // **
            // arr이 부등호 조건에 맞는지 확인하기
            boolean isAnswer = isPoss();
            String tmp;

            StringBuilder sb = new StringBuilder();
            if (isAnswer) {
                for (int i : arr) { // 012
                    sb.append(i);
                }
                tmp = sb.toString();



                // 작은거 구하기
                if (tmp.compareTo(min) < 0) {
                    min = tmp;
                    return;
                }else if(tmp.compareTo(min) > 0){
                    max= tmp;
                    return;
                }


            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                arr[dept] = i;
                dfs(dept + 1);
                visited[i] = 0;
            }

        }

    }

    static boolean isPoss() {
        int pointer = 0;
        for (int i = 0; i < divides.length; i++) {
            int first = arr[pointer];
            int seconds = arr[pointer + 1];

            switch (divides[i]) {
                case ">": {
                    if (first <= seconds) {
                        return false;
                    }
                    pointer++;
                    break;
                }
                case "<": {
                    if (first >= seconds) {
                        return false;
                    }
                    pointer++;
                    break;
                }

            }
        }
        return true;
    }
}
