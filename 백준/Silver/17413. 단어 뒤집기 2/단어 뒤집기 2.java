import java.util.*;
import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sen = br.readLine();
        
        StringBuilder answer = new StringBuilder();
        int len = sen.length();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(int i = 0; i< len;i++){
            char tmp =sen.charAt(i);

            if(tmp == '<'){
                flag= true;
                while(!stack.isEmpty()){ // **
                    answer.append(stack.pop()); 
                }
                answer.append(tmp);

            } else if(tmp == '>' ){
                flag = false;
                answer.append(tmp);
            }else if(flag){ // ** 분리해야함 
                answer.append(tmp);
            } else{
                if(tmp == ' '){
                    while(!stack.isEmpty()){
                        answer.append(stack.pop());
                    }
                    answer.append(" ");
                }else{
                   stack.push(tmp);
                }

            }

        }
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }


        System.out.println(answer);
    }
}


