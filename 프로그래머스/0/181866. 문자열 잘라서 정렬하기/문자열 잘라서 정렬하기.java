import java.util.*;

class Solution {
    public String[] solution(String myString) {
        
        int length             = myString.length();
        ArrayList<String> list = new ArrayList<>(); // 임시 저장할 리스트
        String temp            = "";                // 임시 문자열
        
        for(int i = 0; i < length; i++)
        {
            char c = myString.charAt(i);
            
            if(c == 'x')
            {
                if(temp != ""){
                    list.add(temp);
                    temp = "";
                }
            }
            else if(i != length - 1)
            {
                temp += c;
            }
            else
            {
                temp += c;
                list.add(temp);
            }
        }
        
        Collections.sort(list);
        
        return(list.toArray(new String[list.size()]));
    }
}