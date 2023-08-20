import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;
	static StringBuilder resultBFS, resultDFS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		resultBFS = new StringBuilder();
		resultDFS = new StringBuilder();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(V);
		visited = new boolean[N+1];
		bfs(V);
		
		bw.write(resultDFS+"\n"+resultBFS);
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		resultDFS.append(start+" ");
		
		for(int i=1;i<=N;i++) {
			if(arr[start][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		visited[start] = true;
		while(!que.isEmpty()) {
			int currNode = que.poll();
			resultBFS.append(currNode+" ");
			
			for(int i=1;i<=N;i++) {
				if(!visited[i] && arr[currNode][i] ==1) {
					que.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}