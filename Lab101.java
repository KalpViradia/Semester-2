import java.io.*;
public class Lab101 {
	public static void main(String[] args) {
			try {
			BufferedReader r = new BufferedReader(new FileReader("Lab10.txt"));
			String i;
			int counter=0;
			int wordcounter=0;
			int charactercounter=0;
			while((i=r.readLine())!=null){
				counter++;
				String[] word = i.split(" ");
				wordcounter+=word.length;
				charactercounter+=i.length();
			}
			System.out.println("Number of Characters: "+charactercounter);
			System.out.println("NUmber of words: "+wordcounter);
			System.out.println("Number of Lines: "+counter);
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
}