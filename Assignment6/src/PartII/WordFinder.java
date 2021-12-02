package PartII;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class WordFinder extends JFrame {

	JFileChooser jFileChooser;
	private JPanel topPanel; // the top line of objects is going to go here
	WordList wordList;
	JList list;
	private JTextArea wordsBox; // results of the search go in here.

	//added:
	private JScrollPane scrollPane;
	private JMenuItem item1;
	private JMenuItem item2;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private Boolean fileLoaded = false;

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 225;


	public WordFinder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jFileChooser = new JFileChooser(".");
		wordList = new WordList();

		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setSize(FRAME_WIDTH, FRAME_HEIGHT - 350);


		//panel at the top
		topPanel = new JPanel();

		// there should be objects in the top panel
		createMenus();
		// There should probably be something passed into the JScrollPane

		final int AREA_ROWS = 10;
		final int AREA_COLUMNS = 30;
		wordsBox = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		wordsBox.setEditable(false);
		scrollPane = new JScrollPane(wordsBox);

		label = new JLabel("Find: ");
		topPanel.add(label);

		createFindField();
		topPanel.add(textField);

		createClearButton();
		topPanel.add(button);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the size correctly
		//this frame is a menu frame
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jFileChooser = new JFileChooser(".");

		wordList = new WordList();

		this.add(topPanel, BorderLayout.NORTH);
		this.add(scrollPane);


//		model = new DefaultListModel();
//		list = new JList(model);

		// and of course you will want them to be properly aligned in the frame

	}


	private void createMenus() {
		/* add a "File" menu with:
		 * "Open" item which allows you to choose a new file
		 * "Exit" item which ends the process with System.exit(0);
		 * Key shortcuts are optional
		 */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");

		item1 = new JMenuItem("Open");
		class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		item1.addActionListener(new OpenActionListener());

		item2 = new JMenuItem("Exit");
		item2.addActionListener((e) -> System.exit(0));

		menu.add(item1);
		menu.add(item2);
		menuBar.add(menu);
	}


	private void find(){
		if (textField.getText().equals("") || wordList.getWords() == null) return;

		List searchResult = wordList.find(textField.getText());// figure out from WordList how to get this

		// you're going to want to get the words in the
		// searchResult list and put them in the textbox.

		load(searchResult);
	}

	//load into list

	private void load(List l) {
		wordsBox.setText("");
		for (Iterator i = l.iterator(); i.hasNext(); ) {
			wordsBox.append(i.next() + "\n");
		}
		wordsBox.setCaretPosition(0);
	}


	//creates Find: box
	private void createFindField() {
		final int FIELD_WIDTH = 10;
		textField = new JTextField(FIELD_WIDTH);
		textField.setText("");

		class TypingListener implements CaretListener {
			@Override
			public void caretUpdate(CaretEvent e) {
				find();
			}
		}
		textField.addCaretListener(new TypingListener());
	}

	//creates Clear Button
	private void createClearButton() {
		button = new JButton("Clear");
		class ClearListener implements ActionListener {
			public void actionPerformed(ActionEvent event)  {
				textField.setText("");
				load(wordList.getWords());
			}
		}
		button.addActionListener(new ClearListener());
	}

	class OpenFileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int returnVal = jFileChooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					System.out.println("You chose to open this file: " + jFileChooser.getSelectedFile().getAbsolutePath());

					InputStream in = new FileInputStream(jFileChooser.getSelectedFile().getAbsolutePath());
					wordList.load(in);

					List searchResult = wordList.getWords(); // figure out from WordList how to get this

					// because you will load in a wordlist and there
					// might be data in the search box
					if (textField.getText().equals("")) load(searchResult);
					else find();

				} catch (IOException error){
					error.printStackTrace();
				}
			}
		}
	}


	public static void main(String[] args) {

		WordFinder wordFinder = new WordFinder();
		wordFinder.setVisible(true);
	}
}
