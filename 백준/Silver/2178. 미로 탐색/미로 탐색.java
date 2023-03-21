import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] miro;
	static boolean[][] visited;
	
	//상하좌우 탐색을 위한 방향 배열
	static int[] dx= {0, 0, -1, 1};
	static int[] dy= {-1, 1, 0, 0};
	static int row, col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		miro = new int[row][col];
		visited = new boolean[row][col];
		
		for(int i=0;i<row;i++) {
			String line = br.readLine();
			for(int j=0;j<col;j++) {
				miro[i][j] = line.charAt(j) - '0'; //한글자를 숫자로 바꿔줌
						
			}
		}
		
		BFS();
		System.out.println(miro[row-1][col-1]);
	}
	
	private static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {0,0}); //int 배열인데 배열[0]이 x좌표 [1]이 y좌표
		visited[0][0] = true;         //냉장고나 회의실처럼 시작시간, 끝나는 시간 이렇게 생각하면 될듯
		
		while(!queue.isEmpty()) {
			int[] currLoc = queue.poll(); 
			
			for(int i=0;i<4;i++) {
				int nextrow = currLoc[0] + dy[i];
				int nextcol = currLoc[1] + dx[i]; //상하좌우
				
				
				//유효성 검사
				if(nextrow>=0 && nextcol>=0&&nextrow<row &&nextcol<col&&!visited[nextrow][nextcol]&&miro[nextrow][nextcol]!=0) {
					visited[nextrow][nextcol] = true;
					miro[nextrow][nextcol] = miro[currLoc[0]][currLoc[1]]+1;
					queue.offer(new int[]{nextrow, nextcol});
				}
			}
		}
	}

}
