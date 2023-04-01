import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int from, to, weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	static int N, M;
	static char[] school;
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new Edge[M];
		st = new StringTokenizer(br.readLine());
		school = new char[N+1];
		
		//남학교, 여학교 배열에 값넣기
		for(int i=1;i<=N;i++) {
			school[i] = st.nextToken().charAt(0);
		}
		
		//관계 리스트에 값넣기
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));	
		}
		
		//부모 노드가 자기 자신 make()
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
        
		
		//weight 기준 오름차순 정렬
		//가중치가 가장 작은 간선을 순서대로 선택할거임
		Arrays.sort(edgeList,(e1, e2)->e1.weight-e2.weight);
		
		int totalWeight = 0;
		int edgeCnt = 0;
		for(Edge e:edgeList) {
			//남-여로만 연결되어야함
			
			if(find(e.from) != find(e.to)) {
				if(school[e.from]!=school[e.to]) {
					totalWeight += e.weight;
					edgeCnt++;
					union(e.from, e.to);
				}
			}
		}
		
		//모든 학교를 연결하는 경로가 없으면 -1 출력
		if(edgeCnt!= N-1) totalWeight = -1;
		
		bw.write(String.valueOf(totalWeight));
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}
	
	public static void union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot!=yRoot) {
			parents[yRoot] = xRoot;
		}
	}
}