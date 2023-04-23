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
		
		String B = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		int result = 0;
		int jin = 1;
		for(int i=B.length()-1;i>=0;i--) {
			char c = B.charAt(i);
			if('A'<=c && c<='Z') {
				result += (c-'A'+10)*jin;
			}
			else {
				result += (c-'0')*jin;
			}		
			jin *= N;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}