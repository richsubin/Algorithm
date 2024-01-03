import java.io.*;
import java.util.StringTokenizer;

public class Main { //dfs
	
	static int N;
	static int[] num;
	static int[] arr;
	static boolean[] visited;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());

		num = new int[N];
		arr = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int depth) {
		if(depth == N) {
			int sum = 0;
			
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(arr[i] - arr[i+1]);
			}
			
			result = Math.max(result, sum); //최대인지 다 비교하기
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = num[i]; //숫자를 다 넣어보면서 하나씩 비교해봄 3~8개니까 적긴함
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}
}