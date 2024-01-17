import java.io.*;
import java.util.*;

public class Main {
	
	
	static int M, N; //가로, 세로
	static int[][] box; //토마토 들어있는 상자
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static Queue<tomato> que = new LinkedList<tomato>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) { //익은 토마토면
					que.add(new tomato(i, j, 0));
				}
			}
		}
		
		bfs();
		
	}
	
	static void bfs() {
		int day = 0;
		while(!que.isEmpty()) {
			tomato t = que.poll();
			day = t.day;
			
			for(int i=0;i<4 ;i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && box[nx][ny]==0) {
					box[nx][ny] = 1;
					que.add(new tomato(nx,ny, day+1));
				}
			}
		}
		
		if(chkTomato())
			System.out.println(day);
		else
			System.out.println(-1);
	}
	
	static boolean chkTomato() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}