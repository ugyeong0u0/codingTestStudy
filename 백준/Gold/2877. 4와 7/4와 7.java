import java.util.*;
import java.io.*;
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        String k = Integer.toBinaryString(n+1);
    
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<k.length(); i++){
            if(k.charAt(i) == '0'){
                sb.append('4');
            }
            else{
                sb.append('7');
            }

        }

        System.out.println(sb);
    }
}