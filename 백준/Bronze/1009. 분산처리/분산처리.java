import java.util.*;
import java.io.*;


public class Main {
    static int  Kase,  N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Kase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<Kase ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int base = N % 10;
            int exp = M % 4;
            if(exp == 0) exp = 4;
            int result = 1;
            for(int j =1 ; j<=exp ; j++){
                result *= base;


            }
            result =result % 10;
            if(result == 0) result = 10;

            System.out.println(result);







        }

    }

}