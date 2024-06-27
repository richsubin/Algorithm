import java.io.*;
import java.util.*;
	
class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		int arr3[] = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr1[i] = a + b;
			arr2[i] = b + c;
			arr3[i] = c + a;
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		
		int max = 0;
		int[] arrs[] = {arr1, arr2, arr3};
		
		for(int i=0;i<3;i++) {
			int sum = 0;
			for(int j=N-1;j>=N-K;j--) {
				sum += arrs[i][j];
			}
			max = Math.max(sum, max);
			
		}
		
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
}