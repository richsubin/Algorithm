import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] inputInfo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		inputInfo = new int[n+1][n+1];
		
		for(int k=0;k<m;k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if(inputInfo[i][j]==0)
				inputInfo[i][j] = Integer.parseInt(st.nextToken());
			else {
				int temp = Integer.parseInt(st.nextToken());
				if(temp < inputInfo[i][j]) 
					inputInfo[i][j] = temp;
			}
		}
		
		for(int a =1;a<=n;a++) {
			for(int x=1;x<=n;x++) {
				for(int y=1;y<=n;y++) {
					if(x == a || y == a||x==y) continue;
					if(inputInfo[x][a]==0||inputInfo[a][y]==0)
						continue;
					if(inputInfo[x][y]==0)
						inputInfo[x][y]=inputInfo[x][a]+inputInfo[a][y];
					else
						inputInfo[x][y] = Math.min(inputInfo[x][y], inputInfo[x][a]+inputInfo[a][y]);			
				}
			}
		}
		
		for(int a=1;a<=n;a++) {
			for(int b=1;b<=n;b++) {
				bw.write(String.valueOf(inputInfo[a][b])+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}