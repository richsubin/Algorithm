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
		StringTokenizer st;
		int count = 0;
		int N = Integer.parseInt(br.readLine()); //테스트케이스 수
		HashMap<Integer,Integer> cows = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			
			if(cows.containsKey(cow) && cows.get(cow) != loc) {
				cows.replace(cow, loc);
				count++;
			}
			else if(!cows.containsKey(cow)) {
				cows.put(cow, loc);
			}
				
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();

	}

}