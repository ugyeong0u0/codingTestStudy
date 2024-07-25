import java.util.*;
import java.io.*;


public class Main {

    static int n, answer;
    static int[] visited;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        words = new String[n];
        answer=0;
        for (int i = 0; i < n; i++) {

            words[i] = br.readLine();

        }

        for(int i = 0; i< n ; i++){
            visited = new int [words[i].length()];
            int flag = 0;
            boolean [] al = new boolean[26];
            for(int j = 0; j<words[i].length(); j++){
                char word = words[i].charAt(j);
                if(!al[word - 97]){
                    al[word - 97] = true;
                }else {
                    if (words[i].charAt(j - 1) != words[i].charAt(j)) {
                        flag = 1;
                        break;
                    }
                }

            }

            if(flag == 0){
                answer++;
            }


        }

        System.out.println(answer);

    }



}


