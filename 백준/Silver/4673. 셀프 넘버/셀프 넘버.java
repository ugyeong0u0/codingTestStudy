import java.util.*;
import java.io.*;
public class Main {

    static boolean [] visited = new boolean[10002];
    public static void main(String[] args) throws IOException {

        for(int i =1 ; i<=10001; i++){


            d(i);

        }

        for(int i =1 ; i<=10001; i++){
            if(!visited[i])
                System.out.println(i);

        }
    }

    public static void d(int a ){
        int sum= a;
        int tmp =a;
        while(tmp!=0){
            int divide = tmp%10;
            tmp=tmp/10;
            sum+= divide;
        }
        if(sum<=10001)
            visited[sum]=true;

    }



}