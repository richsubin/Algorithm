import java.util.*;
import java.io.*;

public class Main {
	
	static int N, K;
	static int[] route;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈이 위치
		K = Integer.parseInt(st.nextToken()); //동생의 위치 : 고정되어있음
		
		route = new int[100001]; // 최소 경로를 구하기 위해 필요한 배열
		
		if(N == K) System.out.println(0);
		else bfs(N);
	}
	
	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		route[n] = 1;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			
			for(int i=0;i<3;i++) {
				int next;
				if(i==0) {
					next = temp + 1;//한칸만 이동
				}
				else if(i==1) {
					next = temp - 1;//한칸 이동
				}
				else {
					next = temp * 2;//순간이동!!!
				}
				
				if(next == K) {
					System.out.print(route[temp]);
					return;
				}
				if(next >=0&&next<route.length&&route[next]==0) {
					que.add(next);
					route[next] = route[temp]+1;
				}
			}
		}
	}
}
