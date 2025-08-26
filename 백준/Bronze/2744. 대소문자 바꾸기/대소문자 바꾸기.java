import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(Character.isLowerCase(c)) {
				result.append(Character.toUpperCase(c));
			}
			else {
				result.append(Character.toLowerCase(c));
			}
		}
		
		bw.write(result.toString());
		bw.flush();
		bw.close();
		
	}
}