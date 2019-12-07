import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

class ProcessInput {

	public String text;
	public int ap[];

	ProcessInput() {

		this.text = null;
		ap = new int[150];

	}

	public void read() {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		try {
			this.text = read.readLine();
		} catch (IOException ex) {

			System.out.println("Congratulations ! You got a IOException");

		}
	}

	public String getString() {

		return this.text;

	}

	public void processString() {

		CharacterIterator it = new StringCharacterIterator(getString());

		while (it.current() != CharacterIterator.DONE) {
			
			ap[it.current()]++;
			it.next();

		}
	}

	public int getAp(char letter) {

		return ap[letter];

	}

}

public class HuffmanTree {

	public Character chars;
	public Integer freq;

	HuffmanTree(Character chars, Integer freq) {

		this.chars = chars;
		this.freq = freq;

	}

	HuffmanTree(Integer freq) {
		this.chars = null;
		this.freq = freq;
	}

	public Integer getFreq() {
		return this.freq;
	}

	public Character getChars() {
		return this.chars;
	}

	public void increase_freq() {

		if (this.freq == null)
			this.freq = 0;
		else
			this.freq = this.freq + 1;

	}

	public static void main(String[] args) {

		PriorityQueue<HuffmanTree> obj = new PriorityQueue<HuffmanTree>(30, new HuffmanTreeComparator());

		obj.add(new HuffmanTree('a', 15));
		obj.add(new HuffmanTree('b', 10));
		obj.add(new HuffmanTree('c', 5));

		while (obj.isEmpty() == false) {

			System.out.print(obj.peek().getFreq());
			System.out.print(" ");
			System.out.println(obj.peek().getChars());

			obj.remove();
		}

		ProcessInput rd = new ProcessInput();
		rd.read();
		rd.processString();
		System.out.println(rd.getAp('a'));

	}

}

class HuffmanTreeComparator implements Comparator<HuffmanTree> {

	public int compare(HuffmanTree obj1, HuffmanTree obj2) {

		if (obj1.getFreq() > obj2.getFreq()) {

			return 1;

		}
		if (obj1.getFreq() < obj2.getFreq()) {

			return -1;

		}

		return 0;

	}
}
