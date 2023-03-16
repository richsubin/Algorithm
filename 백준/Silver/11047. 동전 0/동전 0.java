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
		long K = Long.parseLong(st.nextToken());
		int num[] = new int[N];
		int cnt = 0;
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = N-1;i>=0;i--) {
			cnt += (int) (K / num[i]);
			K = K % num[i];
			if(K<0) break;
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		bw.close();

	}

}
