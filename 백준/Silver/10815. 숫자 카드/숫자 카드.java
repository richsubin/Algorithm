import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(String.valueOf(find(num))+" ");
		}
		bw.flush();
		bw.close();
        br.close();
	}
	public static int find(int num) {
		int leftIndex = 0;
		int rightIndex = N-1;
		while(leftIndex <= rightIndex) {
			int midIndex = (leftIndex+rightIndex)/2;
			
			if(arr[midIndex]<num) leftIndex = midIndex+1;
			else if(arr[midIndex]>num) rightIndex = midIndex-1;
			else return 1;
		}
		return 0;
	}

}
