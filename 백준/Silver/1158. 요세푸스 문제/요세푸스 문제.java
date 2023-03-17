import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder("");
		
		Queue<Integer> que = new LinkedList();
		for(int i = 0;i<N;i++) {
			que.offer(i+1);
		}

		System.out.print("<");
		while(que.size()!=1) {
			
			for(int i=0;i<K;i++) {
				if(i == K-1) 
					sb.append((que.poll()+", "));
				
				else 
					que.offer(que.poll());
			}
		}
		sb.append(que.poll()+">");
		System.out.println(sb);

	}

}