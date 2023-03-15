import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = new int[3];
		for(int i=0;i<3;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//bw.write(String.valueOf(result[i]))
		Arrays.sort(num);
		
		for(int n:num) bw.write(String.valueOf(n+" "));
		bw.flush();
		bw.close();
	}
}
