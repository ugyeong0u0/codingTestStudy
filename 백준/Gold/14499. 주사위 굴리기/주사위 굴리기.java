
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
// 답지 봄


public class Main {
    static int n, m, x, y, line;

    static int[][] maps;
    static int[] dice, dirs;
    static int[] dx = {0, 0, 0, -1, +1};
    static int[] dy = {0, +1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열

        x = Integer.parseInt(st.nextToken()); // 지도 시작점
        y = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        dice = new int[7]; // 1부터 시작
        maps = new int[n][m];
        dirs = new int[line];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                maps[i][j] = a;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < line; i++) {
            dirs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < line; i++) {

            int nx = x;
            int ny = y;
            nx += dx[dirs[i]];
            ny += dy[dirs[i]];
//            System.out.println("nx : "+nx+"ny : "+ny);

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
//                System.out.println("a");
                continue;
            }

            roll(nx, ny, dirs[i]);
            x = nx;
            y = ny;

            System.out.println(dice[3]);

        }


    }

    static void roll(int dx, int dy, int d) {

        int tmp = dice[0];

        switch (d) {
            case 1: {
                dice[0] = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[2];
                dice[2] = tmp;
                break;
            }

            case 2: {
                dice[0] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[1];
                dice[1] = tmp;
                break;
            }
            case 3: {
                dice[0] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[5];
                dice[5] = tmp;
                break;
            }
            case 4: { // 남쪽
                dice[0] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[4];
                dice[4] = tmp;
                break;
            }

        }
//        System.out.println("d: "+ d+ ",   "+dice[0]+"    ,"+ dice[1]+"        ,"+ dice[2]+"     ,"+ dice[3]+"      ,"+ dice[4]+ "    ,"+ dice[5]+"   ,"+ dice[6]+"    ," );

        if (maps[dx][dy] == 0) {
            maps[dx][dy] = dice[0];
        }else {
            dice[0] = maps[dx][dy];
//            System.out.println(maps[dx][dy]+" dice[0]"+dice[0]);
            maps[dx][dy] = 0;
        }


    }


}
