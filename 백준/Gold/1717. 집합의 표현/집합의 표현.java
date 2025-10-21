import java.io.*;
import java.util.*;
public class Main {
	
	static int n,m;
	static int[] sets;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //count of sets
		m = Integer.parseInt(st.nextToken()); //count of operations
		sets = new int[n+1];
		
		for(int i =0;i<n+1;i++) { //initializing sets' values
			sets[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(op == 1) isSet(a, b);
			else unionSet(a, b);
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}
	
	static void isSet(int a, int b) {
		if(findSet(a) == findSet(b)) {
			sb.append("YES\n");
		}
		else sb.append("NO\n");
	}
	
	static int findSet(int num) {
		if(sets[num] == num) return num;
		
		return sets[num] = findSet(sets[num]);
	}
	
	static void unionSet(int a, int b) {
		//이미 union 일경우
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		//해야하는 경우
		sets[bRoot] = aRoot;
	}
}