import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cnt = 0;
		int X = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
			if(num >= 0) cnt++;
			else {
				list.add(Math.abs(num));
				
			}
		}
		
		Collections.sort(list);
		
		if(cnt < K)
			X = list.get(K-cnt-1);
		
		bw.write(X+"");
		bw.flush();
		bw.close();
	}
}