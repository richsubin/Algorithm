import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] city = new int [V][V];
		final int MAXV = 100000000;
		for(int k=0;k<V;k++){
			Arrays.fill(city[k], MAXV);
			city[k][k] = 0;
		}
		
		for(int k=0;k<E;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			city[i][j] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int mid=0;mid<V;mid++) {
			for(int i=0;i<V;i++) {
				for(int j=0;j<V;j++) {
					city[i][j] = Math.min(city[i][j], city[i][mid]+city[mid][j]);
				}
			}
		}
		
		int result = MAXV;
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(i!=j && city[i][j]!= MAXV && city[j][i]!= MAXV) {
					result = Math.min(city[i][j]+city[j][i], result);
				}
			}
		}
		if(result == MAXV) result = -1;
		
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
