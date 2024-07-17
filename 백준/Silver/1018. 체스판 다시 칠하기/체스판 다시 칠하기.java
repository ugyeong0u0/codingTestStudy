import java.util.*;
import java.io.*;

public class Main {


    static int n, m, end_n, end_m;
    static int all=64, sum =64;
    static boolean[][] maps;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            String a = br.readLine();

            for (int j = 0; j < m; j++) {

                if (a.charAt(j) == 'W') // W = true
                    maps[i][j] = true;
                else
                    maps[i][j] = false;
            }
        }

        end_n = n - 7; // **
        end_m = m - 7;

        for (int i = 0; i < end_n; i++) {
            for (int j = 0; j < end_m; j++) {

                d(i, j);
            }
        }
        System.out.println(sum);
    }

    public static void d(int a, int b) {
        int endX = a+8;
        int endY = b+8; // **
        boolean tmp = maps[a][b];
        int count = 0;

        for (int i = a; i < endX; i++) {
            for (int j = b; j < endY; j++) {

                if(maps[i][j]!=tmp){
                    count++;
                   
                }
                tmp = !tmp ;// ** maps를 바꾸는 것이 아닌 tmp를 바꿈

            }

            tmp=!tmp; // 첫줄 첫번째랑 색바껴야함, for문 앞에 색이랑 바껴야함

        }


        int allT = Math.min(count , all-count);

        sum = Math.min(sum, allT);
    }




}