import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            int b = Integer.parseInt(st.nextToken());
            int r = gcd(num,b);
            sb.append((num/r)+"/"+(b/r)+"\n");
        }

        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int gcd(int num, int b){
        while(b!=0){
            int r = num%b;
            num = b;
            b = r;
        }
        return num;
    }
}