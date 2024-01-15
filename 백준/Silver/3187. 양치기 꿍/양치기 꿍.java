import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int R, C;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0,};
	static boolean[][] visited;
	static int sheep = 0, wolf = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //세로
		C = Integer.parseInt(st.nextToken()); //가로
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int sheepLive = 0;
		int wolfLive = 0;
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(!visited[i][j] && map[i][j] != '#') {
					sheep = 0;
					wolf = 0;
					dfs(i, j);
					if(sheep > wolf)
						sheepLive += sheep;
					else
						wolfLive += wolf;
				}
			}
		}
		
		bw.write(sheepLive+" "+wolfLive);
		bw.flush();
		bw.close();
		
	}
	
	static void dfs(int x, int y) {
		if(map[x][y] == 'k') {
			sheep++;
		}
		else if(map[x][y] == 'v') {
			wolf++;
		}
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>0 && ny>0 && nx<R && ny<C && !visited[nx][ny] && map[nx][ny] != '#') {
				dfs(nx, ny);
			}
		}
	}
}