import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//입력 받아서 넣기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 출발지와 목적지가 같을 경우
		if (N == 1 && M == 1) {
			System.out.println(1);
			System.exit(0);
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		//3차원 배열 벽 부쉈는지 안부쉈는지 확인해야함
		//0->안부숨 1->부숨
		int[][][] visited = new int[2][N][M];

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> que = new LinkedList<>();

		que.offer(new int[] { 0, 0, 0 });
		//일단 출발지는 무조건 1칸 간거롤 치고가는거임
		visited[0][0][0] = 1;

		while(!que.isEmpty()) {

			int[] node = que.poll();
			int wall = node[0];
			int x = node[1];
			int y = node[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx<N && nx>=0 && ny<M && ny>=0) {
					// 다음 칸이 벽이 아님
					if (map[nx][ny] == 0) {
						if (visited[wall][nx][ny] == 0) {
							que.offer(new int[] { wall, nx, ny });
							visited[wall][nx][ny] = visited[wall][x][y] + 1;
							if (nx == N - 1 && ny == M - 1) {
								return visited[wall][nx][ny];
							}
							
						}
					} 
					// 다음 노드가 벽임
					else {
						if (wall == 0) { //이전에 벽 안부숨
							if (visited[1][nx][ny] == 0) {
								que.offer(new int[]{ 1, nx, ny });
								visited[1][nx][ny] = visited[0][x][y] + 1;
								if (nx == N - 1 && ny == M - 1) {
									return visited[1][nx][ny];
								}
							}
						}
					}
				}
			}
		}
		return -1;
	}
}