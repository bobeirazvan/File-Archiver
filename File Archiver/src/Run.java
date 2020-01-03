import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;

class pair<F, S> {

	private F first;
	private S second;

	pair() {
		this.first = null;
		this.second = null;
	}

	public void assign(F first, S second) {

		this.first = first;
		this.second = second;

	}

	public F getFirst() {
		return first;
	}

	public S getSecond() {
		return second;
	}

}

class Pair {

	protected pair<Character, Integer> current;

	Pair() {
		current = new pair<Character, Integer>();
	}

	public void add_pair(Character chars, Integer freq) {
		current.assign(chars, freq);
	}

	public Integer getFreq() {
		return current.getSecond();
	}

	public Character getChars() {
		return current.getFirst();
	}

}

class TreeComparator implements Comparator<Tree> {

	public int compare(Tree obj1, Tree obj2) {

		if (obj1.getFreq() > obj2.getFreq()) {

			return 1;

		}
		if (obj1.getFreq() < obj2.getFreq()) {

			return -1;

		}

		return 0;

	}
}

class Tree extends Pair {

	private HuffmanTree address;

	Tree() {
		super();
		current = new pair<Character, Integer>();
		address = null;
	}

	public void increase_freq() {

		if (getFreq() == null)
			current.assign(getChars(), 0);
		else
			current.assign(getChars(), getFreq() + 1);

	}

	public void setAddress(HuffmanTree address) {
		this.address = address;
	}

	public HuffmanTree getAddress() {
		return this.address;
	}

}

class HuffmanTree extends Pair {

	private HuffmanTree L;
	private HuffmanTree R;

	HuffmanTree() {
		super();
		L = R = null;
	}

	public HuffmanTree left(HuffmanTree address) {

		if (L == null) {

			L = new HuffmanTree();
			if (address != null)
				L = address;

		}
		return L;

	}

	public HuffmanTree right(HuffmanTree address) {

		if (R == null) {

			R = new HuffmanTree();
			if (address != null)
				R = address;

		}
		return R;

	}

}

class ProcessInput {

	public String text;
	public int ap[];

	ProcessInput() {

		this.text = "";
		ap = new int[256];

	}

	public void read() {
		BufferedReader myread = null;
		try {
			myread = new BufferedReader(new FileReader("/home/razvan/Desktop/File-Archiver/File Archiver/test.txt"));
			String currentLine = "";
			while ((currentLine = myread.readLine()) != null) {
				System.out.println(currentLine) ;
				this.text = this.text + currentLine;
			}
			//System.out.println(this.text);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				if (myread != null)
					myread.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
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

	public void generateHeap(PriorityQueue<Tree> obj) {

		for (char i = 0; i < 256; i++) {

			Integer x = getAp(i);

			if (x > 0) {

				Tree var = new Tree();
				var.add_pair(i, x);
				obj.add(var);

			}

		}
	}

}

class Run {

	public static void traverse(HuffmanTree HEAD, String binar) {

		if (HEAD.getChars() != null) {

			System.out.print(HEAD.getChars());
			System.out.println(":" + binar);

		} else {

			traverse(HEAD.left(null), binar + "0");
			traverse(HEAD.right(null), binar + "1");
		}
	}

	public static void main(String[] args) {

		PriorityQueue<Tree> obj = new PriorityQueue<Tree>(30, new TreeComparator());
		HuffmanTree HEAD = null;
		ProcessInput file = new ProcessInput();

		file.read();
		file.processString();
		file.generateHeap(obj);

		while (obj.isEmpty() == false) {

			pair<Character, Integer> minim1 = new pair<Character, Integer>();
			HuffmanTree address1 = obj.peek().getAddress();
			minim1.assign(obj.peek().getChars(), obj.peek().getFreq());
			obj.remove();

			if (obj.isEmpty() == false) {

				pair<Character, Integer> minim2 = new pair<Character, Integer>();
				HuffmanTree address2 = obj.peek().getAddress();
				minim2.assign(obj.peek().getChars(), obj.peek().getFreq());
				obj.remove();

				HuffmanTree arb = new HuffmanTree();
				arb.add_pair(null, minim1.getSecond() + minim2.getSecond());

				Tree var = new Tree();
				var.add_pair(null, minim1.getSecond() + minim2.getSecond());
				var.setAddress(arb);
				obj.add(var);

				HuffmanTree arb_copy = new HuffmanTree();
				arb_copy = arb;

				if (minim1.getFirst() == null) {
					arb = arb.left(address1);
				} else {
					arb = arb.left(null);
					arb.add_pair(minim1.getFirst(), minim1.getSecond());
				}

				arb = arb_copy;

				if (minim2.getFirst() == null) {
					arb = arb.right(address2);
				} else {
					arb = arb.right(null);
					arb.add_pair(minim2.getFirst(), minim2.getSecond());
				}
			}

			else
				HEAD = address1;

		}

		traverse(HEAD, "");

	}
}