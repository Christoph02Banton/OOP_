// Author/Name: Aneska Bryan
// ID Number: 2102374
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: Getting the GUI  from the base screen (Starts off the GUI for the login screen)

package guiPKG.screens;

import java.io.IOException;

import javax.swing.JFrame;

public class MainScreen {

	public static JFrame frame;

	public static void main(String[] args) {

		try {
			BaseScreen base = new BaseScreen();
			frame = base.getBaseFrame();

		} catch (IOException e) {
			e.printStackTrace();
		}

		new LoginScreen(frame);

	}

}
