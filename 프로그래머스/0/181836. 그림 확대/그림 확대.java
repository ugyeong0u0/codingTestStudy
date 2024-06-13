import java.util.*;
// 1. 한 줄 완성
// 2. 그 한줄 k번 복사 
class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k ];
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i< picture.length;i++){ // 배열의 첫 번째
            String tmp = "";
            for(int j =0; j< picture[i].length(); j++){ // 한 줄 완성하기
                for(int l =0 ; l<k;l++){
                    
                    tmp+=picture[i].charAt(j);
                    
                }
                   
            }
            
             for(int l =0 ; l<k;l++){
                    
                    list.add(tmp); // 한줄씩 k번 넣기
                    
                }
        }
        
        answer= list.toArray(new String[list.size()]);
        
        
        return answer;
    }
}