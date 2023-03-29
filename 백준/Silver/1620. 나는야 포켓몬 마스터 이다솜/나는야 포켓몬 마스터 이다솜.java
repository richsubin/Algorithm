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
		HashMap<String, Integer> pokemon = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		String[] pokename = new String[N+1];
		
		for(int i = 1;i<=N;i++) {
			String name = br.readLine();
			pokemon.put(name, i);
			pokename[i] = name;
		}
		
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			if(isNumber(find)) {
				int index = Integer.parseInt(find);
				sb.append(pokename[index]+"\n");
			}
			else {
				sb.append(pokemon.get(find)+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	public static boolean isNumber(String find) {
		try {
		Double.parseDouble(find);
		return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}