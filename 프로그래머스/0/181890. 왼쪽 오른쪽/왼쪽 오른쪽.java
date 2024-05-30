
class Solution {
    public String[] solution(String[] str_list) {
        
        String[] answer = null;
        
        int len = str_list.length;
        
        int p = 0;
        int k = 0;
        
        for(int i = 0; i< len; i++){
            
            if(str_list[i].equals("l")){
                k= 0;
                p = i; // i 는 인덱스 번호 
                answer = new String[i];
                break;
            }else if(str_list[i].equals("r")){
                
                k=i+1;
                p= str_list.length;
                answer = new String[p-k];
                break;
            }else{
                
                answer= new String[0];
                
            }
        }
        int m= 0;
        for(int a = k;a<p; a++){
            answer[m++]=str_list[a];
        }
        
        
        return answer;
    }
}