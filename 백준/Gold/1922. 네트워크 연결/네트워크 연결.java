import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int from , to, weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to =to;
		this.weight = weight;
	}
}
public class Main {
	static int N, M;
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edgeList = new Edge[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
		
		Arrays.sort(edgeList,(e1, e2)->e1.weight-e2.weight);
		
		int totalWeight = 0;
		
		for(Edge e:edgeList) {
			if(union(e.from, e.to)) {
				totalWeight += e.weight;
			}
		}
		bw.write(String.valueOf(totalWeight));
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot==yRoot) return false;
		parents[yRoot] = xRoot;
		return true;
	}
}