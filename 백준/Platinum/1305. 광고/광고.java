import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		String str= br.readLine();
		
		int result = L-getLastPi(str);
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static int getLastPi(String str) {
		int len = str.length();
		int[] pi = new int[len];
		int index=0;
		
		for(int i=1;i<len;i++) {
			while(index>0 && str.charAt(index)!=str.charAt(i)) {
				index = pi[index-1];
			}
			if(str.charAt(index)==str.charAt(i)) {
				pi[i] = ++index;
			}
		}
		return pi[len-1];
	}
}