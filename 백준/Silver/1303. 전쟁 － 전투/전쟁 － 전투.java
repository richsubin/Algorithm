import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N, M, cnt;
	static int white, blue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[M][N];
		white = 0;
		blue = 0;
		
		
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				cnt = 0;
				if(!visited[i][j]) {
					dfs(i, j);
					if(map[i][j] == 'W')
						white += Math.pow(cnt,2);
					else
						blue += Math.pow(cnt,2);
				}
			}
		}
		bw.write(white+" "+blue);
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int x, int y) {
		cnt++;
		visited[x][y] = true;
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny>=0 && nx<M&&ny<N&&!visited[nx][ny]&&map[nx][ny]==map[x][y]) {
				dfs(nx,ny);
			}
		}
	}
}