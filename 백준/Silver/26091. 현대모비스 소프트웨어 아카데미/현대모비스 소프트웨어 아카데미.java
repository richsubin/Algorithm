import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
				
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        Arrays.sort(arr);
        
		int low = 0;
		int high = N-1;
		
		while(high > low) {
			if(arr[low]+arr[high] >= M) {
				result++;
				low++;
				high--;
			}
			else
				low++;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}