import java.util.*;
import java.io.*;


public class Main {

    static int r, c, n, time;
    static int[][] maps;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {+1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        time = 0; // 흐르는 시간
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        n = Integer.parseInt(st.nextToken()); // n초 후
        maps = new int[r][c];
        for (int i = 0; i < r; i++) {
            String tmp  = br.readLine();
            for (int j = 0; j < c; j++) {
                char a= tmp.charAt(j);
                if (a== 'O') {
                    maps[i][j] = time; // 폭탄
                }else{
                    maps[i][j] = -1;
                }
            }
        }

        while (time < n) {
            time++;
            if(time==1){
                continue;
            }
            if (time % 2 != 0 ) { // 홀수 일때 터짐
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if ( maps[i][j] == time -3) {

                            maps[i][j] = -1; // 빈 곳

                            for (int k = 0; k < 4; k++) {
                                int nx = dx[k] + i;
                                int ny = dy[k] + j;

                                if (nx >=0 && ny >= 0 && nx < r && ny < c && maps[nx][ny]!=time-3) { // time -3 ***
                                    maps[nx][ny] = -1; //  폭탄 터진 곳
                                }

                            }

                        }
                    }
                }

            }
            // 짝수일 때
            if (time % 2 == 0) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (maps[i][j] == -1) { // 빈 곳에
                            maps[i][j] = time;
                        }
                    }

                }


            }


        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(maps[i][j]==-1){
                    System.out.print(".");
                }else{
                    System.out.print("O");
                }

            }
            System.out.println();
        }

    }
}


