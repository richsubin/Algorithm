import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Integer[] A = new Integer[N];
			Integer[] B = new Integer[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A,Collections.reverseOrder());
			Arrays.sort(B, Collections.reverseOrder());
			int temp = 0;
			for(int i=0;i<N;i++) {
				int cnt = 0;
				for(int j=0;j<M;j++) {
					if(A[i]>B[j]) {
						temp+=(M-cnt);
						break;
					}
					else cnt++;
				}
			}
			result.append(temp+"\n");
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}