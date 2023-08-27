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
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(B);
			int temp = 0;
			for(int i=0;i<N;i++) {
				int low = 0;
				int high = M-1;
				int index = 0;
				while(low<=high) {
					int mid = (low+high)/2; //중간값
					if(B[mid]<A[i]) {
						low = mid+1;
						index = mid+1;
					}
					else
						high = mid-1;
				}
				temp+=index;
			}
			result.append(temp+"\n");
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}