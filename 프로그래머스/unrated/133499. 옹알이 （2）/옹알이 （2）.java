import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] check = {"aya","ye","woo","ma"};
        
        for(String b : babbling){ //배열 돌면서
            for(String c : check){ //check 문자 배열도 돌면서 비교해야한다
                if(b.contains(c+c)) {//연속 반복 체크를 위해
                    continue;
                }
                else if(b.contains(c))
                   b = b.replace(c," ");
            }
            if(b.replaceAll(" ","").length()==0) answer++;
        }
        
        return answer;
    }
}