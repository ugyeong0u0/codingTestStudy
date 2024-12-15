import java.util.*;
import java.io.*;


public class Main {
    static int answer,n = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x = 0; // 5의 개수
        int y = 0; // 3의 개수
        for(int i =n/5; i>=0; i--){ // i는 5의 개수
            x= i;
            if((n-i*5)%3==0){
                y=(n-i*5)/3;
                answer= x+y;
                break;
            }else{
                answer=0;
            }

        }
        if(answer ==0){
            answer=-1;
        }

        System.out.println(answer);


    }

}




