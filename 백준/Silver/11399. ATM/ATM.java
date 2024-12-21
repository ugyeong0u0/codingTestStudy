import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class loc{
    int x;
    int y;

    loc(int x, int y){

        this.x=x;
        this.y=y;
    }
}


public class Main {

    static int n, answer, sum, arrN;
    static char[][] maps;
    static int []visited;
    static int [] visited2;
    static int [] ddx ={0,0,1,-1};
    static int [] ddy ={1,-1,0,0};
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st =new StringTokenizer(br.readLine());

//        n = Integer.parseInt(st.nextToken()); // 테케 수
//        arrN = Integer.parseInt(st.nextToken());



        answer = 0;
        sum = 0;
        n= Integer.parseInt(br.readLine());

        visited = new int[n];
        visited2 = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i= 0; i<n; i++){
        visited[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(visited);


        for(int i = 0; i< n ;i++){

            if(i-1>=0)
                visited[i]=visited[i]+visited[i-1];

        answer+=visited[i];
        }





        System.out.println(answer);

      



    }





}
