import java.io.*;

public class Main {
	
	static int[][] videoMap;
	static StringBuilder result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		videoMap = new int[N][N];
		result = new StringBuilder();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				videoMap[i][j] = str.charAt(j)-'0';
			}
		}
		
		makeResult(0,0,N);
		
		bw.write(result+"");
		bw.flush();
		bw.close();

	}
	
	public static void makeResult(int row, int col, int size) {
		if(checkZip(row, col, size)) {
			result.append(videoMap[row][col]);
			return;
		}
		
		int cutSize = size/2;
		
		result.append("(");
		makeResult(row, col, cutSize);
		makeResult(row, col+cutSize, cutSize);
		makeResult(row+cutSize, col, cutSize);
		makeResult(row+cutSize, col+cutSize, cutSize);
		result.append(")");
	}
	
	public static boolean checkZip(int row, int col, int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(videoMap[i][j] != videoMap[row][col])
					return false;
			}
		}
		return true;
	}	
}