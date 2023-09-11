import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	static int[] kit;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 0;
		
		kit = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		chkWeight(500, 0);
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	
	public static void chkWeight(int sum, int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i] && sum + kit[i] - K >= 500) {
				visited[i] = true;
				chkWeight(sum + kit[i] - K, cnt+1);
				visited[i] = false;
			}
		}
	}
	
}