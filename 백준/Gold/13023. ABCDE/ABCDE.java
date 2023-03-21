import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M; //사람 수, 관계 수
	static ArrayList<Integer>[] friend;
	static boolean[] visited;
	static boolean result =false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			friend[i] = new ArrayList();
		}
		
		for(int i=0;i<M;i++) { //값 넣어주기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			friend[from].add(to);
			friend[to].add(from);
		}
		for(int i=0;i<N;i++) {
			if(result) break;
			DFS(i,0);
		}
		
		
		if(result) System.out.println("1");
		else System.out.println("0");
		
	}
	
	public static void DFS(int currNode,int depth) {
		if(result || depth == 5) {
			result = true;
			return;
		}
		for(int node: friend[currNode]) {
			if(!visited[node]) {
				visited[node] = true;
				DFS(node,depth+1);
				
			}
		}
		visited[currNode] = false;  
	}
	
}
