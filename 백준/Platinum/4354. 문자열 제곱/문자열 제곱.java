import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            int result = 1;
            String str= br.readLine();
            if(str.equals(".")) break;
            result = getLastPi(str);
            sb.append(result+"\n");
        }


        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getLastPi(String str) {
        int len = str.length();
        int[] pi = new int[len];
        int index=0;
        //반복되는 문자열 찾아서 몇 제곱인지 봐야함
        //광고 문제랑 좀 비슷하게 그 전체길이에서 배열 마지막 값 빼주면 반복되는 문자열 길이 나옴
        for(int i=1;i<len;i++) {
            while(index>0 && str.charAt(index)!=str.charAt(i)) {
                index = pi[index-1];
            }
            if(str.charAt(index)==str.charAt(i)) {
                pi[i] = ++index;
            }
        }

        if(len%(len-pi[len-1])==0)
            return len / (len-pi[len-1]);
        else
            return 1;
    }
}