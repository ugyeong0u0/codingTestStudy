import java.util.*;
import java.io.*;

public class Main {

    static int n;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int count = 1;
        int k =666;
       while(count !=  n){

           k++;
           String tmp = k+"";
           if(tmp.contains("666")){
               count++;
           }

       }

       System.out.println(k);



    }


}