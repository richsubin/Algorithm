import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// NxM 맵 행렬 생성 (1과 0이 값으로 들어옴)
		map = new int[n][m];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				int num = str.charAt(j) - '0';
				if (num == 1) {
					map[i][j] = num;
				}
			}
		}
		// 출발지와 목적지가 같을 경우
		if (n == 1 && m == 1) {
			System.out.println(1);
			System.exit(0);
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		// 방문을 체크하는 3차원 배열
		int[][][] check = new int[2][n][m];
		// [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
		// [1, n, m] : 벽 부수고 지나가는 방문노드 경로

		// 동서남북
		int[] ax = { 0, 0, -1, 1 };
		int[] ay = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<>();
		// 시작 노드를 q에 담기
		q.offer(new int[] { 0, 0, 0 });
		// 벽 안부쉈으니까 {0, 0, 0}에 지나온 칸의 개수 1을 값으로 넣기.
		check[0][0][0] = 1;

		while (true) {

			int[] node = q.poll();
			int w = node[0];// broken wall or unbroken wall
			int x = node[1];
			int y = node[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + ax[i];
				int ny = y + ay[i];
				// map과 check에 쓰일 인덱스가 배열의 범위를 벗어나면 무시하기.
				if (nx >= n || nx < 0 || ny >= m || ny < 0) {
					continue;
				}

				// 다음 노드가 벽이 아닐 때 -> 다음노드의 w가 0인 자리가 비어있다면 (0이라면) - w가 0이면 0인 자리에, 1이면 1인 자리에 방문 체크할 것.
				if (map[nx][ny] == 0) {
					if (check[w][nx][ny] == 0) {
						q.offer(new int[] { w, nx, ny });
						check[w][nx][ny] = check[w][x][y] + 1;
						if (nx == n - 1 && ny == m - 1) {
							return check[w][nx][ny];
						}

					}
				} 
				// 다음 노드가 벽일 때 -> 1. w가 1보다 큰 범위를 벗어나게 생겼다면 방문체크와 q에 넣는 것을 제외하도록 하고,
				// 						2. 벗어나지 않는다면 w+1 에다가 방문체크하고 q에 넣을 것.
				else {
					if (w == 0) {
						if (check[1][nx][ny] == 0) {
							q.offer(new int[] { 1, nx, ny });
							check[1][nx][ny] = check[0][x][y] + 1;
							if (nx == n - 1 && ny == m - 1) {
								return check[1][nx][ny];
							}
						}
					}
				}

			}

			if (q.isEmpty()) {
				return -1;
			}
		}

	}

}