import java.util.*;
import java.io.*;
public class Main {
    static int [] dx = {-1,-1,-1, 0,  0, +1,+1, +1 };
    static int [] dy = {+1,0,-1, +1, -1, +1, 0, -1 };
    static int [][] maps, visited;

    static int w, h ;
    public static void main(String[] args) throws IOException {

        List <Integer> list = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String tmp = " ";
        while(!(tmp=br.readLine()).equals("0 0")){

            StringTokenizer st= new StringTokenizer(tmp);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            maps = new int[h+1][w+1];
            visited = new int[h+1][w+1];
            for(int i =1; i<= h;i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 1; j<=w ;j++){

                    maps[i][j] = Integer.parseInt(st.nextToken()); // 1인지 0인지

                }
            }

            int island =0;

            for(int i = 1; i<=h ;i++){

                for(int j = 1; j<= w ;j++){

                    if(maps[i][j] == 1 && visited[i][j]==0 ){

                        island++;
                        bfs(i, j);
                    }

                }

            }

            list.add(island);


        }


        for(int i = 0; i<list.size();i++ ){
            System.out.println(list.get(i));
        }

    }

    public static void bfs(int x , int y){
        visited[x][y]=1;

        for(int i = 0 ;i< dx.length ; i++){
            int nx= x+dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny >=0 && nx<=h && ny<= w && visited[nx][ny]==0 && maps[nx][ny]==1){
                bfs(nx, ny);

            }
        }


    }
}