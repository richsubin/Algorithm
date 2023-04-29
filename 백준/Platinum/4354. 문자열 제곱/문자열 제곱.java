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

        for(int i=1;i<len;i++) {
            while(index>0 && str.charAt(index)!=str.charAt(i)) {
                index = pi[index-1];
            }
            if(str.charAt(index)==str.charAt(i)) {
                pi[i] = ++index;
            }
        }
        return len%(len-pi[len-1])==0? len/(len-pi[len-1]) : 1;
    }
}