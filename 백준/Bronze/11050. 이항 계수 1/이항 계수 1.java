import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result=0;
		if(K>0 && K<N) {
			result = fib(N) / (fib(K)*fib(N-K));
		}
		else if(K==N || K==0) result=1;
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
		}
	
	public static int fib(int num) {
		if(num==1) return 1;
		return num*fib(num-1);
	}
}