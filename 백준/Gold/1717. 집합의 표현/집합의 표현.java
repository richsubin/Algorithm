import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] parents;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		
		for(int i=0;i<n+1;i++) {
			parents[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int calc = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(calc == 0) {
				union(a,b);
			}
			else {
				isSame(a,b);
			}
		}
		
		System.out.print(sb);
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		parents[bRoot] = aRoot;
	}
	
	static void isSame(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) sb.append("YES\n");
		else sb.append("NO\n");
	}
	
}
