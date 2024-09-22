import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        ArrayList<Integer> arr = new ArrayList<>();
        int [] su1={1,2,3,4,5};
        int [] su2= {2,1,2,3,2,4,2,5};
        int [] su3={3,3,1,1,2,2,4,4,5,5};
        int [] result= new int [3]; // 결과 리턴 
        
        for(int i =0; i< answers.length; i++){
            
            int ss1 = (i-5*(i/5));
            if(answers[i]==su1[ss1]){
                result[0]++;
            }
            
            int ss2 = (i-8*(i/8));
            if(answers[i]==su2[ss2]){
                result[1]++;
            }
            
            int ss3 = (i-10*(i/10));
            if(answers[i]==su3[ss3]){
                result[2]++;
               
            }
             // System.out.println(answers[i]+"    "+su1[ss1] +"      "+su2[ss2]);
            
        }
        int max =0;
        for(int i= 0 ;i <3 ;i++){
            
            max= Math.max(max,result[i]);
            
        }
         // System.out.println("max  "+max );
        int c = 0;
       
        for(int i= 0; i<3 ;i++){
            
            if(max==result[i]){
                // System.out.println("max  i "+ i );
                c++;
                arr.add(i+1);
            }
            
        }
        answer = new int[c];
        
        for(int i=0; i<c; i++){
            answer[i] =arr.get(i);
        }
        
        return answer;
    }
}