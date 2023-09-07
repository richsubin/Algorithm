import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dx = {0,0,-1,1,-1,-1,1,1};
	static int[] dy = {1,-1,0,0,-1,1,-1,1};
	static int[][] map;
	static boolean[][] visited;
	static int cnt, row, col;
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			
			if(row == 0 && col == 0) break;
			
			map = new int[row][col];
			visited = new boolean[row][col];
			
			for(int i = 0;i<row;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<col;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 0;
			
			for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					if(map[i][j] ==1 && !visited[i][j]) {
						DFS(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();

	}
	public static void DFS(int y, int x) {
		visited[y][x] = true;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >=0 && ny>=0 && nx<col && ny < row && map[ny][nx] == 1 && !visited[ny][nx]) {
				DFS(ny, nx);
			}
		}
	}
}