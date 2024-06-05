class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String [] tmp = binomial.split(" ");
        int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[2]);
        switch(tmp[1]){
            
            case "+" :{
                answer = a+b;
                break;
            }
            case "-" :{
                answer = a-b;
                break;
            }
            case "*" :{
                answer = a*b;
                break;
            }
            case "/" :{
                answer = a/b;
                break;
            }
                
        }
        
        
        return answer;
    }
}