import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> card = new HashMap<>();
		st= new StringTokenizer(br.readLine());

		for(int i = 0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!card.containsKey(num))
				card.put(num,1); 
			else
				card.put(num, card.get(num)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());

		for(int i = 0;i<M;i++) {
			int find = Integer.parseInt(st.nextToken());
			if(card.containsKey(find))
				sb.append(card.get(find)+" ");
			else
				sb.append(0+" ");
		}
		
		System.out.println(sb);
		br.close();
	}
}