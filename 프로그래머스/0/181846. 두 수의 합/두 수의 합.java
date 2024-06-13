import java.util.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        
        Stack <Integer> st = new Stack<>();
        int carry =0;
       
        int aLeng = a.length();
        int bLeng = b.length();
        
        int shortLeng = Math.min(aLeng, bLeng);
        int longLeng = Math.max(aLeng, bLeng);
        
        if(shortLeng!= longLeng){
            String tmp="";
            for(int i = shortLeng; i<longLeng; i++){
                    
                    tmp+="0";
                    
            }
                
            if(shortLeng== aLeng){
                
                a=tmp+a;
                
            }else{
                
                b= tmp+b;
                
            }
            
        }
        
        for(int j = longLeng-1 ; j>=0 ;j--){
            
            int tmpA = Integer.parseInt(a.charAt(j)+"");
            int tmpB = Integer.parseInt(b.charAt(j)+"");
            
            int sum = tmpA+tmpB+carry;
            
          
                if(sum >9){
                carry= 1;
                sum = sum%10;
                
            }else{
                carry=0;
                
            }
            
            
            st.push(sum);
            
            
        }
        
        if(carry==1){
         st.push(1);   
        }
       
       
        while(!st.isEmpty()){
            
        answer += st.pop()+"";
       
        }
        
        
        return answer;
    }
}