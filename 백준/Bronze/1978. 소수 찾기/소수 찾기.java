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

		int count = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			boolean check = true;
			int num = Integer.parseInt(st.nextToken());
			if(num == 1 || num == 0) continue;
			else if(num == 2) count++;
			else {
				for(int j=2;j<num;j++) {
					if(num % j ==0) {
						check = false;
						break;
					}
				}
				if(check) count++;
			}
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
		br.close();
	}
}