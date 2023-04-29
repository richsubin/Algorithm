import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str= br.readLine();
        int result = 0;
        //광고문제는 가능 한 것 중에 가장 짧은 것->접두사 접미사 찾아서 배열로 찾기만해도
        //이번에는 "부분문자열"에서 가장 긴것!
        //모든 부분 문자열 하나씩 다 탐색해야한다

        for(int i=0;i<str.length();i++){
            String temp = str.substring(i,str.length());
            result = Math.max(result, getLastPi(temp));
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getLastPi(String str) {
        int len = str.length();
        int[] pi = new int[len];
        int index=0;
        int max=0;

        for(int i=1;i<len;i++) {
            while(index>0 && str.charAt(index)!=str.charAt(i)) {
                index = pi[index-1];
            }
            if(str.charAt(index)==str.charAt(i)) {
                pi[i] = ++index;
                max = Math.max(max,pi[i]);
            }
        }
        return max;
    }
}