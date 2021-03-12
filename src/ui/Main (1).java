package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public final static String SPLIT =" ";
	@SuppressWarnings("unused")
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int numOfBooks = Integer.parseInt(line);
		int[] prices = new int[numOfBooks];
		int money;
		String[] numberArrays = null;
		System.out.println("llego");
		int countain = 0;
		while(line != null) {
			System.out.println(numOfBooks+"----");
			if(countain == 0) {
				line = br.readLine();
			}
			numberArrays = line.split(SPLIT);
			for(int i =0; i<numOfBooks;i++) {
				prices[i] = Integer.parseInt(numberArrays[i]);
				System.out.println(prices[i]);

			}
			System.out.println("salio");
			Arrays.sort(prices);
			System.out.println("se quedo");
			line= br.readLine();
			System.out.println("se niooni");
			money = Integer.parseInt(line);
			System.out.println(money+"adasd");
			line= br.readLine();
			System.out.println(money+"adasd");
			countain ++;
		}
		br.close();

	}
}
