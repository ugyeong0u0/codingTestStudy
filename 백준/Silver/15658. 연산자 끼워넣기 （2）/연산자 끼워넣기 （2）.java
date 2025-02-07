import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, min, max;
    static int[] nums;
    static int[] v;

    //    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine()); // 수 개수
        nums = new int[n];
        v = new int[4];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine()); // 숫자
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine()); // 연산자
        for (int i = 0; i < 4; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int dept, int sum) {

        if (dept == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int next = nums[dept + 1];
            if (v[i] > 0) {
                v[i] -= 1;
                switch (i) {

                    case 0:
                        dfs(dept + 1, sum + next);
                        break;

                    case 1:
                        dfs(dept + 1, sum - next);
                        break;
                    case 2:
                        dfs(dept + 1, sum * next);
                        break;
                    case 3:
                        dfs(dept + 1, sum / next);
                        break;

                }
                v[i] += 1;

            }

        }


    }


}
