import java.util.*;
import java.io.*;

public class Main {
	
	static int paperMap[][];
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		//2의 제곱(2~128)
		
		paperMap = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				paperMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0,0,N);
		
		bw.write(white+"\n"+blue);
		bw.flush();
		bw.close();
	}
	
	
	public static void countPaper(int row, int col, int size) {
		if(checkPaper(row, col, size)) {
			if(paperMap[row][col] == 1) blue++;
			else white++;
			return;
		}
		
		int cutSize = size/2;
		
		countPaper(row, col, cutSize); // 제2사분면
		countPaper(row, col+cutSize, cutSize); //제 1사분면
		countPaper(row+cutSize, col, cutSize); // 제 3사분면
		countPaper(row+cutSize, col+cutSize, cutSize);//제 4사분면
	}
	
	public static boolean checkPaper(int row, int col, int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(paperMap[i][j] != paperMap[row][col])
					return false;
			}
		}
		return true;
	}
}