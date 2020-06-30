package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.FileUtils;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class View extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDir;
	private JTextArea txtrAsd;
	
	/**
	 * Create the frame.
	 */
	public View()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFocusable(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(".");
				if(fc.showOpenDialog(contentPane) == JFileChooser.APPROVE_OPTION)
				{
					File fichero = fc.getSelectedFile();
					txtDir.setText(fichero.getPath());
				}
			}
		});
		btnBuscar.setBounds(1110, 15, 117, 25);
		contentPane.add(btnBuscar);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.setFocusable(false);
		btnConvertir.setFocusPainted(false);
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtDir.getText().isEmpty())
				{
					txtrAsd.setText(FileUtils.formatText(FileUtils.readFile(txtDir.getText())));
				}
			}
		});
		btnConvertir.setBounds(1110, 52, 117, 25);
		contentPane.add(btnConvertir);
		
		txtDir = new JTextField();
		txtDir.setBounds(12, 15, 1086, 22);
		contentPane.add(txtDir);
		txtDir.setColumns(10);

		txtrAsd = new JTextArea();
		txtrAsd.setEditable(false);
		txtrAsd.setLineWrap(true);
		txtrAsd.setBounds(12, 104, 681, 338);
		//contentPane.add(txtrAsd);
		
		JScrollPane scrollPane = new JScrollPane(txtrAsd);
		scrollPane.setBounds(12, 104, 1215, 463);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}
}
