class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w =0;
        int h =0;
        for(int i =0 ; i< sizes.length ; i++){
            int max = Math.max(sizes[i][0],sizes[i][1]);
            int min = Math.min(sizes[i][0],sizes[i][1]);
            if(h>=max && w>=min || h>=min && w>=max){
                continue;
            }else{
                if(w<max && h<min){
                    w= max;
                    h= min;
                }else if(w<max && h>=min){
                    w=max;
                }else if(w>=max && h<min){
                    h= min;
                }
                
            }
            // System.out.println(w+"  ,  "+h);
        }
        answer= w*h;
        return answer;
    }
}