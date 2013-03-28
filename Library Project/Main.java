import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends Applet implements Runnable, ActionListener {

	boolean screen1 = true;
	boolean screen2 = false;
	boolean screen3 = false;
	boolean screen4 = false;
	boolean screen5 = false;
	boolean searchButtonPressed = false;
	boolean studentSearchResult = false;

	String fName = "";
	String lName = "";
	int studentNum = 0;
	double fine = 0.00;
	ArrayList<String> bookTitle = new ArrayList<String>();
	ArrayList<String> bookISBN = new ArrayList<String>();

	Button createStudent;
	Button createStudentSubmit;
	Button createBook;
	Button createBookSubmit;
	Button checkIn;
	Button checkOut;
	Button home;

	TextField stuNum;
	TextField firstName;
	TextField lastName;

	TextField title;
	TextField author;
	TextField isbn;
	TextField genre;
	TextField cost;
	TextField starRating;

	TextField studentNumber;
	Button signInStudent;

	TextField bookSearch;
	Button checkOutSubmit;
	Button checkInSubmit;

	Library library = new Library("Stephen Lewis Library");

	Students studentFound;

	public void init() {

		// create a file writer
		// create a buffered writer
		// write\

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		// Get screen size in pixels from user's system in computer
		resize(dim.width, dim.height);// sets screen size to screen
		setLayout(null);// sets layout to null
		setBackground(Color.gray);// sets background to grey
		repaint();// repaints

		createStudent = new Button("New Student");
		createStudent.setBounds(50, 50, 150, 40);
		add(createStudent);
		createStudentSubmit = new Button("Add Student");
		createStudentSubmit.setBounds(300, 200, 150, 40);

		createBook = new Button("New Book");
		createBook.setBounds(200, 50, 150, 40);
		add(createBook);
		createBookSubmit = new Button("Add Book");
		createBookSubmit.setBounds(300, 200, 150, 40);

		checkIn = new Button("Check In");
		checkIn.setBounds(350, 50, 150, 40);
		add(checkIn);

		checkOut = new Button("Check Out");
		checkOut.setBounds(500, 50, 150, 40);
		add(checkOut);

		home = new Button("Home");
		home.setBounds(700, 600, 150, 40);

		stuNum = new TextField("Student Number", 20);
		stuNum.setBounds(50, 100, 110, 20);
		firstName = new TextField("First Name", 20);
		// firstName.setBackground(Color.red);
		firstName.setBounds(50, 125, 110, 20);
		lastName = new TextField("Last Name", 20);
		lastName.setBounds(50, 150, 110, 20);

		title = new TextField("Title", 20);
		title.setBounds(50, 100, 110, 20);
		author = new TextField("Author", 20);
		author.setBounds(50, 125, 110, 20);
		isbn = new TextField("ISBN", 20);
		isbn.setBounds(50, 150, 110, 20);
		genre = new TextField("Genre", 20);
		genre.setBounds(50, 175, 110, 20);
		cost = new TextField("Cost", 20);
		cost.setBounds(50, 200, 110, 20);
		starRating = new TextField("Star Rating", 20);
		starRating.setBounds(50, 225, 110, 20);

		studentNumber = new TextField("", 20);
		studentNumber.setBounds(50, 100, 100, 20);
		signInStudent = new Button("Sign In");
		signInStudent.setBounds(160, 100, 100, 20);

		bookSearch = new TextField("", 20);
		bookSearch.setBounds(400, 100, 150, 20);
		checkOutSubmit = new Button("Check Out");
		checkOutSubmit.setBounds(670, 100, 100, 20);
		checkInSubmit = new Button ("Check In");
		checkInSubmit.setBounds(670, 100, 100, 20);

		createStudent.addActionListener(this);
		createStudentSubmit.addActionListener(this);
		createBook.addActionListener(this);
		createBookSubmit.addActionListener(this);
		checkIn.addActionListener(this);
		checkOut.addActionListener(this);
		stuNum.addActionListener(this);
		checkOutSubmit.addActionListener(this);
		checkInSubmit.addActionListener(this);
		signInStudent.addActionListener(this);
		home.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == createStudent) {
			screen1 = false;
			screen2 = true;
			repaint();
			remove(createStudent);
			remove(createBook);
			remove(checkIn);
			remove(checkOut);
			add(stuNum);
			add(firstName);
			add(lastName);
			add(createStudentSubmit);
			add(home);
		} else if (e.getSource() == createStudentSubmit) {
			screen2 = false;
			screen1 = true;
			repaint();
			String studentNumber = stuNum.getText();
			int stuNumber = Integer.parseInt(studentNumber);
			String fName = firstName.getText();
			String lName = lastName.getText();
			library.createStudent(stuNumber, fName, lName);
			screen2 = false;
			screen1 = true;
			remove(stuNum);
			remove(firstName);
			remove(lastName);
			remove(createStudentSubmit);
			add(createStudent);
			add(createBook);
			add(checkIn);
			add(checkOut);
		} else if (e.getSource() == createBook) {
			screen1 = false;
			screen3 = true;
			repaint();
			remove(createStudent);
			remove(createBook);
			remove(checkIn);
			remove(checkOut);
			add(title);
			add(author);
			add(isbn);
			add(genre);
			add(cost);
			add(starRating);
			add(createBookSubmit);
			add(home);
		} else if (e.getSource() == createBookSubmit) {
			screen3 = false;
			screen1 = true;
			repaint();
			String titleBook = title.getText();
			String authorBook = author.getText();
			String iSBN = isbn.getText();
			String genreBook = genre.getText();
			String costB = cost.getText();
			Double costBook = Double.parseDouble(costB);
			String starR = starRating.getText();
			int starRatingBook = Integer.parseInt(starR);
			library.createBook(titleBook, authorBook, iSBN, genreBook,
					costBook, starRatingBook);
			remove(title);
			remove(author);
			remove(isbn);
			remove(genre);
			remove(cost);
			remove(starRating);
			remove(createBookSubmit);
			remove(home);
			add(createStudent);
			add(createBook);
			add(checkIn);
			add(checkOut);
		} else if (e.getSource() == checkOut) {
			screen1 = false;
			screen4 = true;
			repaint();
			remove(createStudent);
			remove(createBook);
			remove(checkIn);
			remove(checkOut);
			add(studentNumber);
			add(signInStudent);
			add(bookSearch);
			add(checkOutSubmit);
			add(home);
		} else if (e.getSource() == signInStudent) {
			String studNum = studentNumber.getText();
			int stuNum = Integer.parseInt(studNum);
			studentFound = library.findStudent(stuNum);
			fName = studentFound.getfName();
			lName = studentFound.getlName();
			studentNum = studentFound.getStudentNumber();
			fine = studentFound.getFine();
			for (int i = 0; i < studentFound.getBooksOut().size(); i++) {
				bookTitle.add(studentFound.getBooksOut().get(i).getBookTitle());
				bookISBN.add(studentFound.getBooksOut().get(i).getBookNumber());
			}
			studentSearchResult = true;
			repaint();
		} else if (e.getSource() == checkOutSubmit) {
			String input = bookSearch.getText();
			Books bookFound = library.findBookCheckOut(input);
			studentFound.addBook(bookFound);
		} else if (e.getSource() == checkIn) {
			screen1 = false;
			screen5 = true;
			add(studentNumber);
			add(signInStudent);
			add (bookSearch);
			add (checkInSubmit);
		}
		else if (e.getSource ()==checkInSubmit){
			
		}
		else if (e.getSource() == home) {
			remove(title);
			remove(author);
			remove(isbn);
			remove(genre);
			remove(cost);
			remove(starRating);
			remove(createBookSubmit);
			remove(stuNum);
			remove(firstName);
			remove(lastName);
			remove(createStudentSubmit);
			remove(studentNumber);
			remove(signInStudent);
			remove(bookSearch);
			remove(checkOutSubmit);
			remove(home);
			add(createStudent);
			add(createBook);
			add(checkIn);
			add(checkOut);
			screen1 = true;
			screen2 = false;
			screen3 = false;
			screen4 = false;
			screen5 = false;
			repaint();
		}
		/*
		 * else if (e.getSource() == checkOutSearchSubmit) { String input =
		 * checkOutSearch.getText(); ArrayList<Books> booksFound =
		 * library.findBook(input); searchButtonPressed = true; repaint();
		 * System.out.println("pressed"); }
		 */

	}

	public void start() {

		// define a new thread
		Thread th = new Thread(this);
		// start this thread
		th.start();

	}

	public void run() {
		// TODO Auto-generated method stub
		// lower ThreadPriority
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while (true) {
			/*
			 * BufferedWriter w; try { w = new BufferedWriter(new FileWriter(
			 * "J:\\Computer Science\\Library Project\\Students.txt")); //
			 * w.write("asdf"); w.close();
			 * 
			 * } catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
			try {
				// Stop thread for 20 milliseconds
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				// do nothing
			}

			// set ThreadPriority to maximum value
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void paint(Graphics g) {

		Font font = new Font("Times New Roman", 0, 30);
		g.setFont(font);
		g.setColor(Color.red);

		if (screen1 == true) {
			setBackground(Color.gray);
		} else if (screen4 == true || screen5 == true) {
			if (studentSearchResult == true) {
				System.out.println("found");
				System.out.println(fName);
				g.drawString("" + studentNum, 100, 150);
				g.drawString(fName + " " + lName, 100, 200);
				g.drawString("Fines:" + " " + fine, 100, 250);
				for (int k = 0; k < bookTitle.size(); k++) {
					g.drawString(bookTitle.get(k), 100, 300 + (k * 50));
					g.drawString(bookISBN.get(k), 150, 300 + (k * 50));
				}
			}
		}
		/*
		 * if (searchButtonPressed == true) { System.out.println("in");
		 * g.drawString("Hi", 200, 200); // TODO create Text above, or remove if
		 * not needed }
		 */
	}

}
