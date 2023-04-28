import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int result=0;
		for(int i=1;i<=C;i++) {
			result+= K* i + P * i*i;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}