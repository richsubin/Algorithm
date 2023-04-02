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
		int T = Integer.parseInt(br.readLine());
		int R;
		String S;
		
		for(int i = 0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			
			for(int j = 0;j<S.length();j++) {
				for(int k = 0;k<R;k++) {					
					sb.append(S.charAt(j));
				}
			}
			sb.append("\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		br.close();
	}
}