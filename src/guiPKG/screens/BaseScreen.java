// Author/Name: Aneska Bryan
// ID Number: 2102374
// Module: Object Oriented Programming
// Date: November 7, 2022
// Description: Sets the Default settings for the GUI

package guiPKG.screens;

import java.io.IOException;
import javax.swing.*;
import guiPKG.utils.*;

public class BaseScreen {

	// final int sizex = 1000, sizey = 1000;
	public static JFrame frame;

	public BaseScreen() throws IOException {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		// Frame drag movement
		FrameDragListener frameDragListener = new FrameDragListener(frame);
		frame.addMouseListener(frameDragListener);
		frame.addMouseMotionListener(frameDragListener);
	}

	public JFrame getBaseFrame() {
		return frame;
	}

}
