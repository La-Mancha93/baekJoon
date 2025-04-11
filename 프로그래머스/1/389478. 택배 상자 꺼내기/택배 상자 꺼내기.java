class Solution {
    public int solution(int n, int w, int num) {
        
        //왼쪽에서 오른쪽으로 가면서 1번 상자부터 번호 순서대로
        int height = n%w == 0 ? n/w : n/w+1; 
        int[][] box = new int[height][w];
        int x = 0;
        int y = 1;
        int counter =1;
        for(int i =height-1; i >= 0;i--){
            //짝수일때는 왼 -> 오
            if(isHolsu(height,i)){
                for(int j = 0; j<w;j++){
                    if(counter > n) continue; 
                    box[i][j] = counter;
                    if(counter == num) {
                        x = j;
                        y = i;
                    }
                    counter++;
                }
            } else{
            //홀수일때는 오 -> 왼
                for(int j = w-1; j >= 0;j--){
                    if(counter > n) continue; 
                    box[i][j] = counter;
                    if(counter == num) {
                        x = j;
                        y = i;

                    }
                    counter++;
                }
            }
        }
        for(int[] a : box){
            for(int b : a){
                System.out.print("[" + b +"]");
            }
            System.out.println();
        }
        
        
        int answer = y+1;

        if(box[0][x] == 0) answer--;

        return answer;
    }
    
    private static boolean isHolsu(int height, int compareNum){
        if(height - compareNum == 0) return true;
        else if((height - compareNum) % 2 == 0) return false;
        else return true;
    }
}