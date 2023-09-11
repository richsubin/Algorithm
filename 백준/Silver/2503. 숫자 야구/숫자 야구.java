import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[] data = new boolean[988];
		int result = 0;
		
		
		for(int i=123;i<=987;i++) {
			String str = Integer.toString(i);
			if(str.charAt(0) == str.charAt(1) ||str.charAt(1) == str.charAt(2)||str.charAt(0) == str.charAt(2)||
					str.charAt(0) == '0'||str.charAt(1) == '0'||str.charAt(2) == '0') {
				continue;
			}
			//123~987 서로 다른 수니까 가능한 것들 중에
			//0도 안되고
			//같은 숫자가 있으면 안된다.
			data[i] = true;
		}
		
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			for(int mind=123;mind<=987;mind++) {
				if(data[mind]) {
					int tempStrike = 0;
					int tempBall = 0;
					for(int tempLoc=0;tempLoc<3;tempLoc++) { //마음속 숫자
						char mindChar = Integer.toString(mind).charAt(tempLoc);
						
						for(int inputLoc=0;inputLoc<3;inputLoc++) {//입력받은숫자
							char inputChar = str.charAt(inputLoc);
														
							if(mindChar == inputChar && tempLoc == inputLoc) tempStrike++;
							else if(mindChar == inputChar && tempLoc != inputLoc) tempBall++;
							
						}
					}
					
					if(tempStrike == strike && tempBall == ball) data[mind] = true;
					else data[mind] = false;
				}
			}
		}
		
		for(int i=123;i<988;i++) {
			if(data[i]) result++;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}