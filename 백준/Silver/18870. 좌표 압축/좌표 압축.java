import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] copy = new int[N];
		HashMap<Integer, Integer> compression = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			copy[i] = arr[i];
		}
		
		Arrays.sort(copy);
		
		int comp_change=0;
		for(int i = 0;i<copy.length;i++) {
			if(compression.containsKey(copy[i])) continue;
			compression.put(copy[i], comp_change);
			comp_change++;
		}
		
		for(int a:arr) {
			bw.write(compression.get(a)+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
