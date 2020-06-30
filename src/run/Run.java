package run;

import gui.View;

public class Run
{

	public static void main(String[] args)
	{
		View view = new View();
		view.setResizable(false);
		view.setLocationRelativeTo(null);
		view.setTitle("Metacognitive Reader");
		view.setVisible(true);
	}

}
