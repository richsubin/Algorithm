import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1) break;
			
			int total = 1;
			for(int i=2;i<n;i++) {
				if(n%i==0) {
					total+=i;
					sb.append(" + "+i);
				}
			}
			if(total==n) {
				result.append(n+" = 1"+sb+"\n");
				sb = new StringBuilder();
			}
			else {
				result.append(n+" is NOT perfect.\n");
				sb = new StringBuilder();
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}