class Solution {
    
    static int t ;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        t = target;
        
        
        answer = dfs(numbers, 0 ,0 ); // 주어진 배열, 현재 값의 합, 현재 인덱스, dfs 횟수 
        
        
        return answer;
    }
    
    public int dfs(int [] numbers, int sum, int n){
        
        if(n == numbers.length){
            
            if(sum == t){
                
                return 1; // 모든 숫자를 다 써야하기 때문에 
                
            }else{
                return 0;
            }
            
        }
       
       return dfs(numbers, sum+numbers[n], n+1 )+dfs(numbers, sum-numbers[n], n+1 );  
        
        
        
    }
}