import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] ranks = new int[n];
		
		for(int i=0;i<n;i++) {
			ranks[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ranks);
		
		int cut = (int)(Math.round(n * 0.15));
		double result = 0;
		
		for(int i = cut;i<n-cut;i++) {
			result += ranks[i];
		}
		
		result /= (n-cut*2);
		
		bw.write((int)(Math.round(result))+"");
		bw.flush();
		bw.close();
	}
}