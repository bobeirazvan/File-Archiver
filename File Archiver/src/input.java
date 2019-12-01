import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class input {

	private String text;

	input() {
		try {
			BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
			String text = new String(obj.readLine());
			this.text = text;

		} catch (IOException ex) {
			System.out.println("Congrats ! You've got a IOException");
		}

	}
}