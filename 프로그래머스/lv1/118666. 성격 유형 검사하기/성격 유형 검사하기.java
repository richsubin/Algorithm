import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> typeMap = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        
        for(int i=0;i<types.length;i++)
            typeMap.put(types[i], 0);
        for(int i=0;i<survey.length;i++){
            int value = choices[i]-1;
            if(value<3){
                typeMap.put(survey[i].charAt(0), typeMap.get(survey[i].charAt(0))+score[value]);
            }
            else if(value>3){
                typeMap.put(survey[i].charAt(1), typeMap.get(survey[i].charAt(1))+score[value]);
            }
        }
        for(int i = 0;i<types.length;i+=2){
            if(typeMap.get(types[i]) >= typeMap.get(types[i+1]))
                answer.append(types[i]);
            else
                answer.append(types[i+1]);
        }
        
        
        
        return answer.toString();
    }
}