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
    static int n, m, L;
    static int time;
    static int[][] map;
    static int[][] arr;

    static ArrayList<int [] > snake;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine()); // 보드의 크기 6
        m = Integer.parseInt(br.readLine()); // 사과의 개수 3

        map = new int[n + 1][n + 1]; // 맵의 구성도

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; // 사과있음
        }


        L = Integer.parseInt(br.readLine()); // 주어진 이동 정보 개수
        arr = new int[L + 1][2]; // 0초 후에 L = 왼쪽  1, D = 오른쪽 2  90도 회전

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            if (c.equals("L")) {
                arr[i][1] = 1;
            } else {
                arr[i][1] = 2;
            }

            arr[i][0] = x;

        }


        /* 시작은 (1.1) , 뱀의 길이는 1 , 처음엔 오른쪽 이동 -> ,, 뱀의 몸은 2로 표현
            사과가 o -> 사과는 먹고, 머리만 늘려 다음칸, 꼬리는 고정
            사과가 x -> 머리 이동시키고 , 꼬리도 이동

        오버: 벽 && 자기자신과 부딪히면 죽음
        게임이 몇초에 끝나는지
         */

        map[1][1] = 0; // 시작 위치
        int x = 1; // 머리
        int y = 1; // 머리
        int loc = 1; // 뱀의 진행 방향 1 : -> 2: 아래 // 3: <- // 4. 위

        snake = new ArrayList<>(); // 뱀

        time = 0;
        int k = 0;

        snake.add(new int [] {1,1});
        int nx = x; // 다음 이동 할 곳
        int ny = y;

        while (true) {
            time++; // 1초 지남


            if (loc == 1) { // 오른쪽
                ny += 1;
            } else if (loc == 2) { // 아래로
                nx += 1;
            } else if (loc == 3) { // <-
                ny -= 1;
            } else { // 위
                nx -= 1;
            }

//            if (nx <=0 || ny <=0 || nx > n || ny > n) { // 벽에 부딪치는지 확인
//                System.out.println(time);
//                break;
//            }

            // 몸통에 부딪치는지 확인
            boolean flag = isPossible(nx, ny);

            if(!flag){ // 부딪친 경우
                System.out.println(time);
                break;
            }
            if(map[nx][ny] == 1){ // 사과가 있는 경우
                map[nx][ny]=0;
                snake.add(new int[] {nx,ny});
            }else{ // 꼬리는 빼고 머리는 이동 ** 꼬리가 특정 부분에서 회전해야함을 어떻게 표시하지?
                snake.add(new int [] {nx,ny});
                snake.remove(0);
            }


            for(int i =0;i<snake.size(); i++){
                int [] a =  snake.get(i);
//                System.out.print( " x :  "+a[0] + "   y:  "+ a[1] + " |||||  ");
            }

//            System.out.println();



            // 이동
            for (int i = k; i < arr.length; i++) {
                if (arr[i][0] == time) {
                    if(arr[i][1]==1){ // 왼쪽 회전
                        loc-=1;
                    }else{ // 오른쪽 회전
                        loc+=1;
                    }

                    if(loc ==0){
                        loc =4;
                    }if(loc == 5){
                        loc =1;
                    }
                    k++; // arr 시작 인덱스
                }
            }

        }

    }

    static boolean isPossible(int x, int y) {

        if (x < 1 || y < 1 || x > n || y > n) { // 벽도 아니고 뱀의 몸통도 아닌 경우
            return false;
        }
        for(int i =0; i< snake.size();i++){
            int [] a= snake.get(i);
            if(x == a[0] && y==a[1]){
                return false;
            }

        }

        return true;


    }
}