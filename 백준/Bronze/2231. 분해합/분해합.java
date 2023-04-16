import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =1;i<N;i++) {
			int num = i;
			int total = 0;
			while(num != 0) {
				total += num %10;
				num /= 10;
			}
			
			if(total+i == N) {
				result = i;
				break;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}