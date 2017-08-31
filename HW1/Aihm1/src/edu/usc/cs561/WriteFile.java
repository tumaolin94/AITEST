package edu.usc.cs561;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class WriteFile {
	public void WriteDataToFile(boolean status, List<String> list, int[][] location) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			if(status) {
				writer.println("OK");
				for(int i=0;i<location.length;i++) {
					char[] temp = list.get(i+3).toCharArray();
					if(location[i][0]>=0)
						temp[location[i][0]]='1';
					System.out.println(temp);
					writer.println(temp);
				}
			}else {
				writer.println("FAIL");

			}

			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
