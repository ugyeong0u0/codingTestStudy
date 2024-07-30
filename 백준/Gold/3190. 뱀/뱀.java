
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    /* 1. 하나의 맵에 뱀몸통(2), 사과(1) 다 표시하기
    *  2. 꼬리를 빼는 거라 선입 선출임 => 큐
    *  3. 자기 몸에 부딪혀도 죽는거
    *  4. 네 방향움직이는거 ++ -- 한 변수에 하면 되고, 혹은 %4 하면됨 
    * */
    static int n, apple, dirN, time;

    static int [][] maps;
    static String [] dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n =Integer.parseInt(br.readLine());
        apple =Integer.parseInt(br.readLine());

        maps= new int[n+1][n+1];
        dir = new String[10001]; // 몇 초 후
        for(int i = 0; i< apple; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            maps[a][b] = 1; // 사과

        }

        apple =Integer.parseInt(br.readLine());

        for(int i = 0 ; i< apple;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nxtime= Integer.parseInt(st.nextToken());
            String nxtdir = st.nextToken();

            dir[nxtime] = nxtdir;

        }
        int dx= 1;
        int dy = 1; // 시작
        int alD = 2;
        Queue<int []> q= new LinkedList<>(); // 뱀 길이

        q.add(new int [] {dx,dy}); // 0초

        while(dx>=1 && dy >=1 && dx<=n &&dy<=n ){

            if(dir[time]!= null){
                if(dir[time].equals("D")) { // 오른쪽 90도
                    alD =alD +1;
                    if(alD == 5){
                        alD= 1;
                    }
                }else{ // 왼쪽 90도
                    alD = alD -1;
                    if(alD ==0){
                        alD = 4;
                    }
                }
            }

            time++;
            if(alD ==1 ){ // 사과가 있는지
                dx=dx-1;
            }else if(alD ==2 ){
                dy=dy+1;
            }else if(alD == 3){
                dx=dx+1;
            }else{
                dy=dy-1;
            }

            if(dx>=1 && dy >=1 && dx<=n &&dy<=n ){
                if(maps[dx][dy]==2){
                    break;
                }
            }else{
                break;
            }

            // 사과가 있다면
            if(maps[dx][dy]==1){
                q.offer(new int[]{dx, dy});
            }else{ // 없다면
                int [] tmp= q.poll();
                int tx = tmp[0];
                int ty = tmp[1];
                maps[tx][ty]=0;
                q.offer(new int[]{dx, dy});
            }
            maps[dx][dy]=2;

//            System.out.println("time >" +time +"   dx : "+ dx +"  dy : "+ dy);
        }

        System.out.println(time);


    }

}


