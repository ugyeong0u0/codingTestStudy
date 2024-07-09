import java.util.*;
import java.io.*;
public class Main {
    static int computer, line;
    static int [] visited ;
    static int [][] maps;
    static int answer;
    public static void main(String[] args) throws IOException {
       Scanner sc= new Scanner(System.in);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       answer= 0;
       computer = Integer.parseInt(br.readLine());
       line= Integer.parseInt(br.readLine());
       visited = new int[computer+1];
       maps = new int [computer+1][computer+1];


        for(int i =0; i<line ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());


            maps[a][b]=1;
            maps[b][a]=1;

        }
        visited[1]=1;

        bfs(1);

        System.out.println(answer);

    }

    public static void bfs(int v ){

        for(int i = 1; i <= computer;i++){

            if(visited[i]==0 && maps[v][i]==1){
                answer++;
                visited[i]=1;
                bfs(i);

            }

        }

    }
}