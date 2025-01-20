import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int n, answer;
    static int[] stairs;
    static int[] nums, visited;

    public static void main(String[] args) throws IOException {
        /**
         *
         * 1. 전체 숫자를 1과 2를 통해 조합,
         *  112 는 됨 ***
         *  121는 됨 ****
         *
         *  211 안됨  => 차라리 계단 visited를 추가해서 visited[] 전에 하나 체크 될때마다 +1
         *
         *  1. 1이 세번나오면 안됨
         *  2. 2 1 1
         * 2. 6을 만드는
         *  for문
         *      1) 2로 나눠서 몫
         *      2) 남은거 1
         *
         *  dfs(int 1의 개수 세기  )를 돌림
         *  break문은 for문으로 센거
         *
         *
         *
         *
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
//        nums = new int[3]; // 1과 2가 몇개 있는지

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        visited= new int [n+1]; // 계단 지나간 값 표시

        visited[1]=stairs[1];
        if(n>=2)
            visited[2] = Math.max(visited[1]+stairs[2], stairs[2]); // 12, 2
        if(n>=3)
            visited[3] = Math.max(visited[1]+stairs[3], stairs[2]+stairs[3]); // 13, 23
        // 4= visited[2] + st[4](24), visi[1] + st3  + statir[4](134,  124)
        // 5 = visiited[3] + st[5]( 235,135), visited[2] + st[4] st[5]  (245, 1245)

        for(int i =4 ; i<= n ;i++){

            visited[i] = Math.max(visited[i-2], visited[i-3]+stairs[i-1])+stairs[i];

        }




//        int tmp = n / 2;
//        answer = Integer.MIN_VALUE;
//        for (int i = tmp; i >= 0; i--) { // 6/2 =3,
//
//
//            int tmp2 = n - (i * 2); // 6 - 2*3 =0
//
//            nums[1] = tmp2;
//            nums[2] = i;
//
//            int dept = i + tmp2; // 총 반복 횟수 3번
//
//
//            dfs(0, 0, 0, 0, dept); // 1의 개수 , 반복 횟수
//
//
//        }


        System.out.println(visited[n]);
    }

    static void dfs(int cnt, int sum, int now, int lv, int dept) { // 연속된거 개수 ,지난계단 지났는지, 점수합, 현재 몇칸에 있는지, 반복몇번했는지, 주어진 반복횟수

        // 11 2 11
        if (cnt == 2) { //  *****
//            System.out.print("-----xxx");
            return;
        }

        if (lv == dept) {
            answer = Math.max(answer, sum);
//            System.out.println(a + "    " +sum);
            return;

        }


        for (int i = 1; i <= 2; i++) { // st[2] = 3;
            if (nums[i] > 0) {
                nums[i]--;
                int prev = now;
                now += i;

                if (prev!= 0 && prev+1 == now ) { // prev =4, now 5
//                    System.out.print(cnt+ " +1");

                    dfs(cnt+1, sum + stairs[now], now, lv + 1, dept);
                } else { // 2인 경우
                    dfs(0, sum + stairs[now], now, lv + 1, dept);
                }
                now -= i;
                nums[i]++;
            }
        }
    }
}
