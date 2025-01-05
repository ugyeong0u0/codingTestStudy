import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

class loc {
    int x;
    int y;

    loc(int x, int y) {

        this.x = x;
        this.y = y;
    }
}


public class Main {

    static int n, answer, to;
    //    static char[][] maps;
    static int[] visited;
    static int[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        words = new int[n];
        for (int i = 0; i < n; i++) {
            words[i] =Integer.parseInt( br.readLine());
        }

        answer = 0;


        /*
        1. 우선순위 큐에 넣고 내림차순 정렬
        2. 두개뽑고 둘다 +인지 확인
        3.  둘 중 하나 -면 +하기
        둘다 -면 곱해서 더하기
        -와 0 1 은 주위 해야함
        0일경우 버리고
        1인 경우 더하기
         * */

//        PriorityQueue <Integer> pq = new PriorityQueue<>((o1,o2)->(o2 -o1));
//
//        for(int i = 0; i< n ;i++){
//            pq.offer(words[i]);
//        }
//
//        while(!pq.isEmpty()){
//            int fir = pq.poll();
//            int two;
//            if(pq.size()>=1){
//                two = pq.poll();
//                if(two ==0){
//                    if(pq.size()>=1){
//                        int tmp = pq.peek();
//                        if(tmp<0){
//                            pq.offer(0);
//                        }
//                    }
//                    answer+=fir;
//
//                }else if(fir>0 && two ==1){
//                    answer += fir+two;
//                }
//                else if(fir>0 && two >0 || fir< 0 && two <0 || fir ==0 && two<0){
//                    answer += fir * two;
//                }else{
//                    answer += fir +two;
//                }
//
//            }else{
//               answer += fir;
//            }
//            // 1. 1 2 양수
//            // 2. 1 2 음수
//            // 3. 1 양 2음
//            // 4. 1 0 2음
//            // 5. 1양 20
//
//
//
//        }


        PriorityQueue<Integer> plus = new PriorityQueue<>((o1,o2)->(o2-o1)); // 내림차순
        PriorityQueue<Integer> minus = new PriorityQueue<>((o1,o2)->(o1-o2)); // 마이너스는 오른차순 , 끝이 0일 수 있음

        for (int i = 0; i < n; i++) {
           if(words[i]<=0){
               minus.offer(words[i]);
           }else{
               plus.offer(words[i]);
           }
        }
        /*
        * plus의 경우
        * 1. 1이 있는 경우 무조건 더하는게 나음
        * 2. 1이상 값 연달아는 곱하기
        * */
        while(!plus.isEmpty()){
            int fir = plus.poll();

            if(plus.isEmpty()){
                answer += fir;
               break;
            }
            if(fir==1){ // **
                answer += fir;
            }else if(plus.peek()==1){
                answer += fir+ plus.poll();
            }else{
                answer += fir * plus.poll();
            }


        }
        while(!minus.isEmpty()){
            int fir = minus.poll();

            if(minus.isEmpty()){
                answer += fir;
                break;
            }

            if(minus.peek() ==0){
                minus.poll();
            }else{

                answer += minus.poll() * fir;
            }



        }
        
        System.out.println(answer);
    }


}



