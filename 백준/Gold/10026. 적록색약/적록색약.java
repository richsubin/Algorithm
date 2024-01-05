import java.io.*;

public class Main {

	static char[][] rgb;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int colorResult, nonColorResult, N; //색맹X결과, 색맹결과, 전체 크기
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		rgb = new char[N][N];
		visited = new boolean[N][N];
		colorResult = 0;
		nonColorResult = 0;
		
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			for(int j = 0;j<N;j++) {
				rgb[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					colorResult++;
				}
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(rgb[i][j] == 'R')
					rgb[i][j] = 'G';
			}
		}
		
		visited = new boolean[N][N];

		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					nonColorResult++;
				}
			}
		}
		
		bw.write(colorResult+" "+nonColorResult);
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		char tempColor = rgb[x][y];
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < N && ny < N && nx >=0 && ny >=0 && !visited[nx][ny] && tempColor == rgb[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}