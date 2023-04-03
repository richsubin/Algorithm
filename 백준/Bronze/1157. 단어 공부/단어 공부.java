import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = 0;
		char answer='?';
		int[] arr = new int[26];
		String str = br.readLine().toUpperCase();
		
		for(int i=0;i<str.length();i++) {
			int num = str.charAt(i)-'A';
			arr[num]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
				answer = (char)(i+'A');
			}
			else if(max == arr[i])
				answer ='?';
		}
		bw.write(answer);
		bw.flush();
		bw.close();
		br.close();
	}
}