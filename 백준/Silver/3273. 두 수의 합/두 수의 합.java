import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int low = 0;
		int high = n-1;
		while(low < high) {
			int sum = arr[low]+arr[high];
			if(sum == x) {
				result++;
				low++;
			}
			if(sum<x) low++;
			else if(sum>x) high--;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}