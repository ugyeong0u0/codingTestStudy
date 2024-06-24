import java.util.*;


class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
//         List<String> arr1 = new ArrayList<>();
//         List<String> arr2 = new ArrayList<>();
        
       
//         for(int i =0 ; i< participant.length; i++){
            
//             arr1.add(participant[i]);   
            
//         }
        
//          for(int i =0 ; i< completion.length; i++){
            
//             arr2.add(completion[i]);   
            
//         }
        
//         Collections.sort(arr1);
//         Collections.sort(arr2);
        
        
        
//         for(int i =0 ; i< completion.length; i++){
//             String a = arr1.get(i);
//             String b = arr2.get(i);
//             if(!a.equals(b)){
//                 return answer = a; 
//             }   
             
//         }

            
//             answer = arr1.get(arr1.size()-1);
            
        
        
        
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i =0 ; i< participant.length; i++){
            
             map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);   
            
         }
        
        for(int i = 0 ;i< completion.length; i++){
            
            map.put(completion[i], map.get(completion[i])-1);
            
        }
       
        
        for(String a : map.keySet()){
            
            if(map.get(a)!=0){
                return answer = a;
            }
            
        }
        
        return answer;
    }
}