import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M; // N은 도시의 수, M 여행계획에 속한 도시의 수
	static int[] parents;
	static int[] route;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		route = new int[M+1];
		
		//parents 초기화
		for(int x = 0;x<N+1;x++) {
			parents[x] = x;
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int chk = Integer.parseInt(st.nextToken());
				if(chk == 1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int x=0;x<M;x++) {
			route[x] = Integer.parseInt(st.nextToken());
		}
		
		boolean routeChk = false;
		
		for(int x=0;x<M-1;x++) {
			routeChk= isSame(route[x],route[x+1]);
			if(!routeChk) break;
		}
		
		if(routeChk) System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	static void union(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		if(iRoot == jRoot) return;
		parents[jRoot] =iRoot;
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean isSame(int i, int j) {
		int iRoot = find(i);
		int jRoot = find(j);
		if(iRoot == jRoot) return true;
		else return false;
	}
}
