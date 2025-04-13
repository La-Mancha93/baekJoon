class Solution {
    public int solution(int[] players, int m, int k) {
        //m명 늘어날때마다 서버 1대 추가 필요
        //n*m 명 이상 (n+1) * m 명 미만이라면 최소 n대 서버 필요
        //한번 증설한 서버는 k시간 동안 운영
        //하루동안 모든 게임 이용자가 게임을 이용하기 위해 서버를 최소 몇번 증설해야하는지?
        int answer = 0;
        int[] server = new int[players.length];
        for(int i =0; i<players.length;i++){
            int plusServer = (players[i] / m) - server[i];
            if(plusServer > 0){
                a: for(int j=i;j<i+k;j++){
                    if(j>= players.length) break a;
                    server[j] += plusServer;
                }
                answer += plusServer;
            }
        }
        return answer;
    }
}