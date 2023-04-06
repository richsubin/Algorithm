import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int total = 1;
		if(N==0) {
			System.out.println(total);
			return;
		}
		for(int i=1;i<=N;i++) {
			total *=i;
		}
		
		bw.write(total+"");
		bw.flush();
		bw.close();
		br.close();
	}
}