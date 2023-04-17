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
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			int count = 0;
			int sum = 0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					count++;
					sum+= count;
				}
				else {
					count = 0;
				}
			}
			sb.append(sum+"\n");
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
}