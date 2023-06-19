import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = n;
		for(int i =0;i<n;i++) {
			boolean[] arr = new boolean[26];
			String str = br.readLine();
			arr[(int)str.charAt(0)-97] = true;
			for(int j=1;j<str.length();j++) {
				char c = str.charAt(j);
				if(c == str.charAt(j-1)) continue;
				if(arr[(int)c-97]) {
					cnt--; break;				
				}
				arr[(int)c-97] = true;
			}
		}
		bw.write(cnt+"");
		br.close();
		bw.flush();
		bw.close();			
	}
}