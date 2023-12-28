import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무 갯수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무 미터
		
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int min = 0;
		int max = 0;
		
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			if(max < trees[i])
				max = trees[i];
		}
		
		while(min < max) { //이분탐색
			int mid = (min + max) / 2;
			long sum = 0;
			
			for(int tree : trees) {
				if(tree - mid > 0) {
					sum += tree - mid;
				}
			}
			
			if(sum < M) {
				max = mid;
			}
			
			else {
				min = mid + 1;
			}
		}
		
		int result = min - 1;
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}