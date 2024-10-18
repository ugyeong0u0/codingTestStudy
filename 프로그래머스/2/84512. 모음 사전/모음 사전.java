class Solution {
    static char[] mun ={'A', 'E', 'I', 'O','U'};
    static int count, answer;
    public int solution(String word) {
      
        StringBuilder sb = new StringBuilder();
         count=0;
        dfs(sb,0,word);
      
        return answer;
    }
    
    static void dfs(StringBuilder d,int nu, String wo){
        
        if((d.toString()).equals(wo)){
            // System.out.println(d);
            answer= count;
            return;
            
        }
        
        if(nu ==5){
            return;
        }
        
        for(int i =0;i<5;i++){
            count++;
            dfs(d.append(mun[i]),nu+1,wo);
            d.deleteCharAt(d.length()-1);
            
        }
    }
}


// class Solution {
//     static String Word;
//     static int answer=0;
//     static int count =0; 
//     static char [] dict = {'A', 'E' , 'I', 'O','U'};
//     public int solution(String word) {
//         Word = word;
//         StringBuilder sb =new StringBuilder();
//         dfs(sb, 0);
        
        
        
//         return answer;
//     }
    
//     static void dfs(StringBuilder sb , int cnt){
//         System.out.println(sb);
//         int sum = 0; 
//         if(sb.toString().equals(Word)){
//             answer = count;                
//             return;
            
//         }
        
//         if(cnt == 5){
//             return; 
//         }
        
//         for(int i = 0 ; i< dict.length; i++){
            
//             sb.append(dict[i]);
            
//             count ++;
//             dfs(sb, cnt+1);
            
//             sb.deleteCharAt(sb.length()-1);
            
            
            
            
            
//         }
            
//     } 
// }