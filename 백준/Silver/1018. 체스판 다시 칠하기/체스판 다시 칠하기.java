import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static boolean[][] chess;
	static int min = 64;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());	
		chess = new boolean[N][M];
		
		for(int i=0;i<N;i++) { //체스판 값 넣어주기
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) =='W')
					chess[i][j] = true;
				else
					chess[i][j] = false;
			}
		}
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				check(i,j);
			}
		
		}
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
		br.close();
	}
	private static void check(int x, int y) {
		int count = 0;
		boolean bwcheck = chess[x][y];
		for(int i=x;i<x+8;i++) {
			for(int j =y;j<y+8;j++) { //색이 번갈아 나와야함
				if(chess[i][j] !=bwcheck) count++;
				
				bwcheck = (!bwcheck);
			}
			bwcheck = (!bwcheck); //다음줄 첫번째도 다른 색임
		}
		count = Math.min(count, 64-count);
		
		//다른 8x8도 해야함
		min = Math.min(min, count);
	}
	

}