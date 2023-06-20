import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int range = 2;
		int answer = 1;
		
		if(n != 1) {
			while(range <= n) {
				range = range+(6*answer);
				answer++;
			}
		}	
		bw.write(answer+"");
		br.close();
		bw.flush();
		bw.close();	
	}
}