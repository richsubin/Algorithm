import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[][] dungchi = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			dungchi[i][0] = Integer.parseInt(st.nextToken());
			dungchi[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int result = 0;
			for(int j=0; j< N; j++) {
				if(i == j) continue;
				if(dungchi[i][0] < dungchi[j][0] && dungchi[i][1] < dungchi[j][1]) {
					result++;
				}
			}
			sb.append((result+1)+" ");
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();

	}
}