import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(),":");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long d = gcd(a,b);
        bw.write(a/d+":"+b/d);
        bw.flush();
        bw.close();
        br.close();
    }
    public static long gcd(long a, long b){
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}