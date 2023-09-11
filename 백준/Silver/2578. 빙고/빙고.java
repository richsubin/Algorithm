import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] pan;
	static int bingoCnt=0;
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		pan = new int[5][5];
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				pan[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		
		for(int t = 1;t<=25;t++) {
			int num = sc.nextInt();
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(pan[i][j] == num) pan[i][j] = 0;
				}
			}
			
			rowCheck();//행체크
			colCheck();//열체크
			leftDiagonal();//대각선 왼위-오아래 체크
			rightDiagonal();//대각선 왼아래-오위 체크
			
			if(bingoCnt >= 3) {
				result = t;
				break;
			}
			bingoCnt = 0;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
		
		
	}
	
	public static void rowCheck() {
		for(int i=0;i<5;i++) {
			int bingoChk = 0;
			for(int j=0;j<5;j++) {
				if(pan[i][j] == 0) bingoChk++;
			}
			if(bingoChk == 5) bingoCnt++;
		}
	}
	
	public static void colCheck() {
		for(int i=0;i<5;i++) {
			int bingoChk = 0;
			for(int j=0;j<5;j++) {
				if(pan[j][i] == 0) bingoChk++;
			}
			if(bingoChk == 5) bingoCnt++;
		}
	}
	
	public static void leftDiagonal() {
		int bingoChk = 0;
		for(int i=0;i<5;i++) {
			if(pan[i][i] == 0) bingoChk++;
		}
		if(bingoChk == 5) bingoCnt++;
	}
	
	public static void rightDiagonal() {
		int bingoChk = 0;
		for(int i=0;i<5;i++) {
			if(pan[i][4-i] == 0) bingoChk++;
		}
		if(bingoChk == 5) bingoCnt++;
	}
}
