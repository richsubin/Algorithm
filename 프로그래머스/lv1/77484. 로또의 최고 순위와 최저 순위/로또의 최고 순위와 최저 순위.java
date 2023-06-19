class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int zeroCnt = 0;
        int winCnt = 0;
        for(int i=0;i<6;i++){
            if(lottos[i]==0) zeroCnt++;
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(win_nums[i]==lottos[j]) {
                    winCnt++;
                    break;
                }
            }
        }
        answer[0] = winChk(winCnt+zeroCnt);
        answer[1] = winChk(winCnt);
        return answer;
    }
    
    public int winChk(int cnt){
        switch(cnt){
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 6;
        }
    }
}