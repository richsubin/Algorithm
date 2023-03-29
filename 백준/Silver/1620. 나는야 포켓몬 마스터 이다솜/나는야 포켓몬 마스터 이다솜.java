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
		HashMap<String, String> pokemon = new HashMap<String, String>();
		
		
		for(int i = 1;i<=N;i++) {
			String name = br.readLine();
			pokemon.put(name, Integer.toString(i));
			pokemon.put(Integer.toString(i), name);
			
		}
		
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			bw.write(pokemon.get(find)+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
