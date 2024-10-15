class Solution {
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        /*
        그냥 dfs 로 다 하나씩 가보고 가장 큰 값 넣기    
        
        1. visited로 방문여부 남기기=> 행 기준  
        2. dfs 탈출은 던전개수<depth
        3. 호출 전 호출 후로 for문 두개 사용해서 max값 구하기 
        */
        visited = new boolean[dungeons.length];
        int answer = -1;
        
        for(int i= 0; i< dungeons.length;i++){
            
            if(!visited[i]&& k>=dungeons[i][0]){
                // System.out.println(i);
                visited[i]=true;
                int re = dfs(1,1,k-dungeons[i][1],dungeons );
                answer = Math.max(re, answer);
                visited[i]=false;
            }
            
        }
        
        
        return answer;
    }
    
    static int dfs(int dept, int v, int re, int [][] du){
        if(dept > du.length){
            System.out.println(v);
            return v;
        }
        int maxValue = v; 
        
        for(int i =0 ;i< du.length ;i++){
            
            if(!visited[i]&& re>=du[i][0]){
                // System.out.println(i+" dpet : "+ dept+" v : "+v +"re : "+re);
                visited[i] = true;
                maxValue = Math.max(maxValue,dfs(dept+1, v+1, re-du[i][1], du));
                visited[i]=false;
                
            }
            
        }
        return maxValue;
        
    }
}