import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String txt = " ";


        while (true) {
            txt = br.readLine();

            boolean visited = false; // aeiou 있니?
            boolean jFlag = false; // 3연속 이니?
            boolean eFlag = false; // ee oo 제외 두번 연속 같니?
            int vcnt = 0; // 모음 3번 연속인지
            int mcnt = 0; // 자음이 3번 연속인지


            if (txt.equals("end")) {
                break;
            }

            for (int i = 0; i < txt.length(); i++) {
                if (txt.charAt(i) == 'a' || txt.charAt(i) == 'e' || txt.charAt(i) == 'i' || txt.charAt(i) == 'o' || txt.charAt(i) == 'u') {
                    visited = true;
                    mcnt++;
                    vcnt = 0;
                } else {
                    vcnt++;
                    mcnt = 0;
                }

                if (mcnt >= 3 || vcnt >= 3) {
                    jFlag = true;
                    break;
                }

                if (i - 1 >= 0 && txt.charAt(i) != 'e' && txt.charAt(i) != 'o'&& txt.charAt(i - 1) == txt.charAt(i)) {
                    eFlag = true;
                    break;
                }

            }


            if (visited && !jFlag && !eFlag)
                System.out.println("<" + txt + ">" + " is acceptable.");
            else
                System.out.println("<" + txt + ">" + " is not acceptable.");


        }

    }


}


