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
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] friends = new int[N][N];
		int num = 1000000000;
		for(int k=0;k<N;k++) {
			Arrays.fill(friends[k],num);
			friends[k][k] = 0;
		}
		
		for(int k=0;k<M;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			friends[i][j] = friends[j][i] = 1;
		}
		
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					friends[i][j] = Math.min(friends[i][j], friends[i][k]+friends[k][j]);
				}
			}
		}
		
		int index=0;
		int total = num;
		for(int i=0;i<N;i++) {
			int temp = 0;
			for(int j=0;j<N;j++) {				
				temp+=friends[i][j];
			}
			if(total>temp) {
				total = temp;
				index = i+1;
			}
		}
		
		bw.write(String.valueOf(index));
		bw.flush();
		bw.close();
		br.close();
	}
}