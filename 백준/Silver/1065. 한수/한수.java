import java.util.*;
import java.io.*;

public class Main {

    static int sum = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 들어오는 수가 1000까지인데 1000은 안됨


        d(n);


        System.out.println(sum);


    }

    public static void d(int num) {

        if (num < 100) {
            sum = num;
        } else {

            sum = 99;
            if(
                    num==1000
            ){
                num=999;
            }
            for(int i = 100; i<=num; i++){
                int tmp = i;
                int one = tmp%10;
                tmp=tmp/10;
                int two = tmp %10 ;
                tmp = tmp/10;

                int three = tmp%10;

               
                if(two-one == three- two){
                    sum++;
                }
            }


        }

    }


}