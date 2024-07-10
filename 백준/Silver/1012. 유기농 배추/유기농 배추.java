import java.util.*;
import java.io.*;
public class Main {
    public static int kase, col, row, line;
    static int [][] maps, visited;

    static int [] dx ={-1,0,0,+1};
    static int [] dy ={-0,+1,-1,+0};

    static List <Integer> list =new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        kase =Integer.parseInt(br.readLine());

        for(int k =0; k< kase ;k++){
            int answer =0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            col =Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            line = Integer.parseInt(st.nextToken());

            maps= new int[row][col];
            visited= new int[row][col];

            for(int i = 0 ; i< line ; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                maps[b][a] = 1;

            }

            for(int i = 0 ;i< row ; i++){
                for(int j = 0; j<col ; j++){

                    if(maps[i][j]==1 && visited[i][j]==0){

                        answer++;
                        dfs(i,j);
                    }

                }


            }
            list.add(answer);

        }
        for(int k = 0; k < kase ;k++){

            System.out.println(list.get(k));
        }





    }

    static void dfs(int x, int y){
        visited[x][y]=1;

        for(int i =0 ; i< 4; i++ ){

            int nx = dx[i]+x;
            int ny = dy[i]+y;


            if(nx>=0 && ny >= 0 && nx<row && ny < col && maps[nx][ny]==1 && visited[nx][ny]==0){

                    dfs(nx,ny);

            }

        }


    }
}
