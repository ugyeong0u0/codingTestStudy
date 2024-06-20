import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        List <String> list = new ArrayList<>();
        combi("", numbers, set);
        
       Iterator<Integer> iter = set.iterator(); // <> 없다면 
        
        while(iter.hasNext()){
            
           int nn=  iter.next(); 
            
           if(nn ==2) answer++;
            if(nn%2!=0 && isPrime(nn)){

             answer++;
            }

                         
        }
        
        
        return answer;
    }
    
    static boolean isPrime(int nn){
        if(nn==1 || nn==0) return false ; 
        for(int i =3 ; i<= Math.sqrt(nn); i+=2){
            
            if(nn % i ==0) return false ;
            
        }
        System.out.println("소수"+nn);
        return true;
        
    }
    
    static void combi(String tmp, String n, HashSet set){
        
        if(!tmp.equals("")) set.add(Integer.valueOf(tmp));
        
        for(int i =0; i< n.length();i++ ){
            
            combi(tmp+n.charAt(i), n.substring(0,i)+n.substring(i+1,n.length()), set);
            
        }
        
        
    }
    
}