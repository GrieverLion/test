import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Test {

	public static void main(String[] args) {
		String mac = null;
		try {
			Process porcess = Runtime.getRuntime().exec("ipconfig /all");
			InputStreamReader isr = new InputStreamReader(
					porcess.getInputStream());
			LineNumberReader input = new LineNumberReader(isr);
			String line;
			while ((line = input.readLine()) != null) {
				// System.out.println(line);
				if (line.toLowerCase().matches(
						".*[0-9a-f][0-9a-f][-]" + "[0-9a-f][0-9a-f][-]"
								+ "[0-9a-f][0-9a-f][-]" + "[0-9a-f][0-9a-f][-]"
								+ "[0-9a-f][0-9a-f][-]" + "[0-9a-f][0-9a-f].*")) {
					// System.out.println(line);
					String str = line.substring(line.length() - 17,
							line.length());
					if (str.split("-").length == 6) {
						mac = str;
					}
					break;
				}
			}
			isr.close();
			input.close();
			System.out.println(mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
