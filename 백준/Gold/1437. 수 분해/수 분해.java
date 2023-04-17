import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N+1];
		
		for(int i=0;i<=N;i++) {
			if(i<=4) {
				arr[i] = i;
			}
			else {
				arr[i] = (arr[i-3] *3)%10007;				
			}
		}
		
		bw.write(arr[N]+"");
		bw.flush();
		bw.close();
		br.close();
	}
}