import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int num = L * P;
		
		st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		for(int i=0;i<4;i++) {
			result.append(Integer.parseInt(st.nextToken()) - num).append(" ");			
		}
		result.append(Integer.parseInt(st.nextToken()) - num);
		
		
		bw.write(result.toString());
		bw.flush();
		bw.close();
	}

}