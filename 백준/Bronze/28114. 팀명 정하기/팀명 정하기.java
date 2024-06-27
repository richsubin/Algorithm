import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		
		Map<Integer,String> map = new HashMap<>();
		int[] year = new int[3];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int solved = Integer.parseInt(st.nextToken());
			year[i] = Integer.parseInt(st.nextToken()) % 100;
			String name = st.nextToken();
			
			map.put(solved, name);
		}
		
		Arrays.sort(year);
		Object[] solves = map.keySet().toArray();
		
		Arrays.sort(solves,Collections.reverseOrder());
		
		for(Object s:solves) {
			result.append((map.get(s)).charAt(0));
		}
		for(int i=0;i<3;i++) {
			bw.write(year[i]%100+"");
		}
		bw.write("\n"+result);
		bw.flush();
		bw.close();
	}
}