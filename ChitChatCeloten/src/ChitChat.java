import java.io.IOException;

public class ChitChat {

	public static void main(String[] args) throws IOException {
		ChatFrame chatFrame = new ChatFrame();
		Klient.prijavi(ChatFrame.javniVzdevek);
		Klient.seznam();
		chatFrame.pack();
		chatFrame.setVisible(true);
	}

}
