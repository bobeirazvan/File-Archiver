import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuffmanTree {

	private Character chars;
	private Integer freq;

	HuffmanTree() {
		this.chars = null;
		this.freq = null ; 
	}

	public void increase_freq() {
		if (this.freq == null)
			this.freq = 0;
		else
			this.freq = this.freq + 1;
	}

	public int count() {
     return 1;
	}

	public static void main(String[] args) {
		HuffmanTree myobj = new HuffmanTree();
	}

}
