
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
/*
 * 회전 방향을 배열이든 어디에 저장해야하는 이유 ***
 * 순서대로 하면 원래 바퀴2만 움직이고 3은 움직이지 말아야하는데 바퀴 2움직이고 그로 인해 바퀴 3이 움직이는 경우 생김 => 문제에서 요하는건 초기 상태에 따라 연쇄가 일어나는지임
 *
 * */

public class Main {

    static int r, topN;

    static int[][] arr;
    static int[] roList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][8];
        roList = new int[5];
        // StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            String a = br.readLine();
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '1') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }

            }
        }


        r = Integer.parseInt(br.readLine()); // 명령 수

        for (int i = 0; i < r; i++) {
            roList = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            topN = Integer.parseInt(st.nextToken()); // 톱니 번호

            int dir = Integer.parseInt(st.nextToken()); // 회전 방향

            roList[topN]=dir;

            // [2] [6]
            if (topN - 1 >= 1 && arr[topN][6] != arr[topN - 1][2]) { // 왼쪽 회전

                dfs(0, dir, topN);
            }

            if (topN + 1 <= 4 && arr[topN][2] != arr[topN + 1][6]) { // 오른쪽 회전

                dfs(1, dir, topN);
            }

            /* 마지막에 !!
                타켓 바퀴
            */
            rotate();


//            for (int a = 1; a <= 4; a++) {
//                for (int j = 0; j < 8; j++) {
//                    System.out.print(arr[a][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("----------------");


        }


        int answer = 0;
        if (arr[1][0] == 1) {
            answer = 1;
        }

        if (arr[2][0] == 1) {
            answer += 2;
        }
        if (arr[3][0] == 1) {
            answer += 4;
        }

        if (arr[4][0] == 1) {
            answer += 8;
        }

        System.out.println(answer);


    }

    // 주변 바퀴 회전하는 경우
    static void dfs(int direction, int dir, int number) { // direction : 왼쪽 오른쪽 , dir 시계 반시계  number 현재 돌아가는 바퀴 번호

        if (direction == 0) { // 왼쪽 바퀴 회전
            if (number - 1 >= 1 && arr[number][6] != arr[number - 1][2]) {
                roList[number - 1] = dir * -1;
                dfs(0, dir * -1, number - 1);
            }
        } else { // 오른쪽 바퀴 회전

            if (number + 1 <= 4 && arr[number][2] != arr[number + 1][6]) {
                roList[number + 1] = dir * -1;
                dfs(1, dir * -1, number + 1);
            }
        }


    }

    static void rotate() {

        for (int i = 1; i <= 4; i++) {
            int rD = roList[i];


            if (rD == -1) { // 반시계라면
                //            System.out.println("dir : " +dir + "   n"+ number);
                int tmp = arr[i][0];
                for (int j = 0; j <= 6; j++) {

                    arr[i][j] = arr[i][j + 1];

                }
                arr[i][7] = tmp;


            } else if(rD==1) { // 시계인 경우
                //            System.out.println("dir : " +dir + "   n"+ number);
                int tmp = arr[i][7];

                for (int j = 6; j >= 0; j--) {

                    arr[i][j + 1] = arr[i][j];

                }
                arr[i][0] = tmp;

            }

        }



    }


}
