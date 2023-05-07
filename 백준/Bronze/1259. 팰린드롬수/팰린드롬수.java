import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            boolean chk = true;
            for(int i = 0;i<str.length()/2;i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i))
                    chk = false;
            }
            if(chk) sb.append("yes\n");
            else sb.append("no\n");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
}