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
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> work = new HashMap<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String att = st.nextToken();
			if(!work.containsKey(name)) 
				work.put(name, att);
			else 
				work.remove(name);
		}
		ArrayList<String> names = new ArrayList<>(work.keySet());
		Collections.sort(names,Collections.reverseOrder());
		
		for(String s:names) {
			bw.write(s+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}