import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			map.put(name, 1);
		}
		for(int i=0;i<M;i++) {
			String watch = br.readLine();
			if(map.containsKey(watch))
				arr.add(watch);
		}
		Collections.sort(arr);
		bw.write(arr.size()+"\n");
		for(String s:arr) {
			bw.write(s+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}