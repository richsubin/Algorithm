import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] num;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		for(int i=0;i<N;i++) bw.write(String.valueOf(num[i])+"\n");
		bw.flush();
		bw.close();
	}
}