import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {

        int len = 0;
        int bCnt = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt = br.readLine();

        for(int i = 0; i< txt.length();i++){

            if(txt.charAt(i)=='a') {
                len++; // a의 길이
            }
        }
        for(int i= 0; i<txt.length() ;i++){
            int high = 0;
            for(int j =i ; j<i+len; j++ ){

                if(txt.charAt(j%txt.length()) == 'b') // **
                    high++;

            }



            bCnt = Math.min(bCnt,high );


        }


        System.out.println(bCnt);






    }



}


