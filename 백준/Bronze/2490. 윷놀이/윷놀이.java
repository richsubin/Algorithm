import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		String arr[] =  {"D", "C", "B", "A", "E"};
		
		for(int i=0;i<3;i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			result.append(arr[sum]+"\n");
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}