import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int max = -1;
		int x_result = 0;
		int y_result = 0;
		for(int i=1;i<=9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(max <= num) {
					max = num;
					x_result = i;
					y_result = j;
				}
			}
		}
		
		bw.write(max+"\n"+x_result+" "+y_result);
		bw.flush();
		bw.close();
		br.close();
	}
}