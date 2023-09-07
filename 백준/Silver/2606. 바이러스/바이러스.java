import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] relation;
	static boolean[] visited;
	static int n, t, cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		cnt = 0;
		
		relation = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			relation[a][b] = 1;
			relation[b][a] = 1;
			
		}
		
		BFS(1);
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();

	}
	
	public static void BFS(int a) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(a);
		
		while(!que.isEmpty()) {
			int currNode = que.poll();
			
			for(int i=2;i<=n;i++) {
				if(relation[currNode][i] == 1 && !visited[i]) {
					que.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
	}
}