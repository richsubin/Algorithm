import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] paperMap;
	static int minus = 0; //-1에 해당
	static int zero = 0; //0에 해당
	static int plus = 0; //1에 해당
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		paperMap = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paperMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0, 0, N);
		
		bw.write(minus+"\n"+zero+"\n"+plus+"\n");
		bw.flush();
		bw.close();
		
	}
	
	public static void countPaper(int row, int col, int size) {
		if(checkPaper(row, col, size)) {
			if(paperMap[row][col] == -1) minus++;
			if(paperMap[row][col] == 0) zero++;
			if(paperMap[row][col] == 1) plus++;
			return;
		}
		
		int cutSize = size/3;
		
		for(int i=row;i<row+size;i+=cutSize) {
			for(int j=col;j<col+size;j+=cutSize) {
				countPaper(i, j, cutSize);
			}
		}
	}
	
	public static boolean checkPaper(int row, int col, int cutSize) {
		for(int i=row;i<row+cutSize;i++) {
			for(int j=col;j<col+cutSize;j++) {
				if(paperMap[i][j] != paperMap[row][col])
					return false;
			}
		}
		return true;
	}
}