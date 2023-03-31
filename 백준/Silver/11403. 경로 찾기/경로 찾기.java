import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int a = 0;a<N;a++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][a] ==1 && map[a][j]==1) {
						map[i][j] = 1;
					}
				}
			}
		}
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				bw.write(String.valueOf(map[i][j]+" "));
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}