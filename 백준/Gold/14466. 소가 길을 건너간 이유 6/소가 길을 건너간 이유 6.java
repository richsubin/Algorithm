import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//class Loc { // 각 좌표에 좌표 arraylist를 넣어줄거임
//	int x, y;
//
//	public Loc(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
	public class Main {
		static int N, K, R;
		static boolean[][] visited; // 방문
		static Point[] cow; // 소 위치정보
		static ArrayList<Point>[][] road; // 길 정보 저장

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 목초지 크기
			K = Integer.parseInt(st.nextToken()); // 소 몇마리
			R = Integer.parseInt(st.nextToken()); // 길 정보
			
			cow = new Point[K];
			road = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {//각 좌표에 arraylist 넣어주고 생성? 해줌
					road[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				int r1 = Integer.parseInt(st.nextToken()) - 1;
				int c1 = Integer.parseInt(st.nextToken()) - 1;
				int r2 = Integer.parseInt(st.nextToken()) - 1;
				int c2 = Integer.parseInt(st.nextToken()) - 1;
				
				//무방향인가 양방향인가 뭐 그거떄문임 이건 무방향인가..? 좀따 체크해보자
				//그니까 길이 있으면 못가는걸로 쳐야하는거임
				road[r1][c1].add(new Point(r2, c2));
				road[r2][c2].add(new Point(r1, c1));
			}

			for (int i = 0; i < K; i++) {//소 위치 넣기
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				cow[i] = new Point(x, y);
			}

			int result = 0;
			for (int i = 0; i < K; i++) {
				visited = new boolean[N][N]; //소 한 마리당 visited 초기화해줘야해
				BFS(cow[i].x, cow[i].y);
				for (int j = i + 1; j < K; j++) {
					Point Point = cow[j];
					if (!visited[Point.x][Point.y])
						result++;
				}
			}
			
			bw.write(result+"");
			bw.flush();
			bw.close();
			br.close();
		}

		private static void BFS(int x, int y) {
			visited[x][y] = true; //소 본인 위치는 일단 방문한거임
			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				//그 다음 목초지가 범위넘어서면 continue; 시키는거 있어야함
				//이미 방문했다면 넘기고
				//길 aka 벽이 있으면 또 컨티뉴
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)	continue;
				if (visited[nx][ny])continue;
				if (road[x][y].contains(new Point(nx, ny))) continue;
				BFS(nx, ny);
			}
		}
	}

