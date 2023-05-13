import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[15][15]; //누적합
        for(int i=0;i<15;i++){
            apt[0][i] = i;
            apt[i][1] = 1;
        }
        for(int i=1;i<15;i++){ //누적합으로 다 초기화해서 넣어줌
            for(int j=2;j<15;j++){ //대각선 더해주면 된다
                apt[i][j] = apt[i-1][j] + apt[i][j-1];
            }
        }

        for(int i=0;i<T;i++){
            int k =Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]+"\n");
        }
        bw.write(""+sb);
        bw.flush();
        bw.close();
        br.close();
    }
}