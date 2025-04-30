import java.util.*;
import java.io.*;

class Loc {

    int x;
    int y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

public class Main {
    static int answer; // 사회자 외침
    static int line;
    static int[][] bingo;
    static int[][] check;
    static ArrayList<Integer> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[25][25];
        check = new int[25][25]; // 0
        answer = 0;
        line = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < 25; i++) { // 사회자가 부르는 것
            int target = arr.get(i);
            answer++;

            for (int w = 0; w < 5; w++) {
                for (int e = 0; e < 5; e++) {

                    if (bingo[w][e] == target) {
                        check[w][e] = 1; // 방문
                        // 빙고 확인하기
                        int flag1 = hoBingo(w, e);
                        int flag2 = verBingo(w, e);
                        int flag3 = deBingo(w, e);
                        int flag4 = de2Bingo(w,e);


                            line+= flag1+ flag2;
//                        System.out.println( answer + "flag :    " + flag1+   "     flag2  :  "+ flag2 + "   flag3   :   " +flag3+  " flag4    :  "    +flag4 + " line  :   "+ line  );
                            if (line + flag3 +flag4 >=3 ) {
                                System.out.println(answer);
                                return;
                            }

                    }
                }
            }
        }


    }

    static int hoBingo(int x, int y) {
        int ho =0;
        // 가로 x 동일 y 변동
        for (int i = 0; i < 25; i++) {
            if(check[x][i]==1){
                ho++;
            }
        }

        if(ho==5){
            return 1;
        }
        return 0;
    }

    // 세로
    static int verBingo(int x, int y) {
        int ver =0;
        for (int i = 0; i < 25; i++) {
            if(check[i][y]==1){
                ver++;
            }
        }

        if(ver==5){
            return 1;
        }
        return 0;

    }
    // 위 대각선
    static int deBingo(int x, int y) {
        int de =0;

        // 가로 x 동일 y 변동
        for (int i = 0; i < 25; i++) {
            if(check[i][i]==1){
                de++;
            }
        }
        if(de ==5){
            return 1;
        }
        return 0;
    }

    // 아래 대각선
    static int de2Bingo(int x, int y) {

        if(check[4][0] == 1 &&check[4][0]==check[3][1] &&check[4][0]==check[2][2] && check[4][0]==check[1][3] && check[4][0]==check[0][4]){
            return 1;
        }
        return 0;
    }
}