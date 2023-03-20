import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			adjList[i] = new ArrayList(); //배열의 각 칸을 또 초기화해줘야함
		}
		
		for(int i = 0;i<M;i++) {//그래프에 값을 넣어줘야한다
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		BFS(1);
		for(int i=0;i<=N;i++) {
			if(!visited[i]) {
				BFS(i);
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
		//System.out.println(Arrays.deepToString(adjList));
	}
	
	private static void BFS(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;
		while(!queue.isEmpty()) {
			int currNode = queue.poll();

			for(int node:adjList[currNode]) {
				if(!visited[node]) {
					visited[node] = true;
					BFS(node);
				}
			}
		}

	}

}
