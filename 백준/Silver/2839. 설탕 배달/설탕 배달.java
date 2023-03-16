import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = -1;
		
		for(int i=0;i<=(N/3);i++) {
			if ((N-(i*3))%5 == 0) {
				cnt=i+(N-(i*3))/5;
				break;
			}
		}
		
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		br.close();

	}

}