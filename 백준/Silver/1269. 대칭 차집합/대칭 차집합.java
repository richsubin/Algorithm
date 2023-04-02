import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> a_map = new HashMap<>();
		HashMap<Integer, Integer> b_map = new HashMap<>();
		int[] a_arr = new int[N];
		int[] b_arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			a_map.put(num, i);
			a_arr[i] = num;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			b_map.put(num, i);
			b_arr[i] = num;
		}
		
		for(int a :a_arr) {
			if(b_map.containsKey(a))
				b_map.remove(a);
		}
		
		for(int b :b_arr) {
			if(a_map.containsKey(b))
				a_map.remove(b);
		}
		
		bw.write(String.valueOf(a_map.size()+b_map.size()));
		bw.flush();
		bw.close();
		br.close();
	}
}