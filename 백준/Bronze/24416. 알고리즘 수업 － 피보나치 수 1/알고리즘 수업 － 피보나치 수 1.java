import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	static int fib_cnt = 0;
	static int fibonacci_cnt = 0;
	static int[] arr_f;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr_f = new int[N];
		fib(N);
		fibonacci(N);
		bw.write(String.valueOf(fib_cnt)+" "+String.valueOf(fibonacci_cnt));
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int fib(int n) {
		if(n == 1 || n==2) {
			fib_cnt++;
			return 1;
	}
		else {		
			return(fib(n-1)+fib(n-2));
		}
	}
	
	public static int fibonacci(int n) {
		arr_f[0] = 1;
		arr_f[1] = 1;
		for(int i=2;i<n;i++) {
			fibonacci_cnt++;
			arr_f[i] = arr_f[i-1]+arr_f[i-2];
		}
		return arr_f[n-1];
	}
}
