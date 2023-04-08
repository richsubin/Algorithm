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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int total =0;
			float [] arr = new float[N];
			for(int j=0;j<N;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
				total+=arr[j];
			}
			double avg = total / N;
			double cnt = 0;
			for(int j=0;j<N;j++) {
				if(arr[j]>avg) cnt++;
			}
			String result = String.format("%.3f", (cnt/N*(100.0)));
			sb.append(result+"%\n");
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
}