import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Star{ //별 위치
		double x, y;
		int index; //별 마다 번호 매겨줌
		public Star(double x, double y, int index) {
			super();
			this.x = x;
			this.y = y;
			this.index = index;
		}
	}
	
	static class Edge implements Comparable<Edge>{//두 별 사이 비용 정보위해
		double weight;
		int from, to;
		
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.weight > o.weight) {
				return 1;
			}
			else return -1;
		}
	}
	//서로 간 거리 다 구해서 넣어줄거임
	static int n; //정점 개수로 볼거임
	static Star[] starList; //별 위치 저장한 리스트
	static int[] parents;
	static ArrayList<Edge> edgeList;//거리 정보 넣을 거 필요함
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		starList = new Star[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			starList[i] = new Star(Double.parseDouble(st.nextToken()),
							Double.parseDouble(st.nextToken()),
							i);
		}
		
		//각 별들 마다 거리 다 계산해서 넣어줄거임
		edgeList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				double weight = Math.sqrt(Math.pow((starList[i].x-starList[j].x),2)+Math.pow((starList[i].y-starList[j].y),2));
				weight = Math.round(weight*100)/100.0; //소수 둘째 자리만 하기 위해
				edgeList.add(new Edge(i, j, weight));
			}
		}
		
		//weight 기준으로 오름차순으로 정렬해줌
		Collections.sort(edgeList);

		make();
		
		double totalWeight = 0;
		int edgeCnt = 0;
		for(Edge e: edgeList) { //비용이 최소인것부터 이어주자
			if(union(e.from, e.to)) {
				totalWeight += e.weight;
				edgeCnt++;
				if(edgeCnt == n-1) break;
			}
		}
		
		bw.write(totalWeight+"");
		bw.flush();
		bw.close();
		br.close();
	}	
	
	static void make() {
		parents = new int[n+1];
		for(int i=0;i<=n;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {//이어주기
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot ==yRoot) return false; //사이클 발생
		parents[yRoot] = xRoot;
		return true;
	}
}