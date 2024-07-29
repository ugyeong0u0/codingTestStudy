import javax.sound.midi.Soundbank;
import java.util.*;
import java.io.*;


public class Main {

    static int n;

    static String[] visited = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sen = br.readLine();

        for (int i = 0; i < sen.length(); i++) {
            boolean flag = false;
            if (i + 3 <= sen.length()) {
                String tmp = sen.substring(i, i + 3);
                for (int j = 0; j < visited.length; j++) {
                    if (tmp.equals(visited[j])) {
//                        System.out.println(tmp);
                        n++;
                        i += 2;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }

            }
            if (i + 2 <= sen.length()) {
                String tmp = sen.substring(i, i + 2);
                for (int j = 0; j < visited.length; j++) {
                    if (tmp.equals(visited[j])) {
//                        System.out.println(tmp);
                        n++;
                        i += 1;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }

            }


//            System.out.println(sen.charAt(i));
            n++;


        }
        System.out.println(n);
    }

}


