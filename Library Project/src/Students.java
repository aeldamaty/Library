import java.util.ArrayList;

public class Students {

	private int studentNumber;// Student Number
	private String fName;// First Name
	private String lName;// Last Name
	private double fine;// Amount Owed
	private ArrayList<Books> booksOut = new ArrayList<Books>();// Max Number of
																// Books

	// Allowed in

	// Possession

	// since this number is the same for every student, it will be a static

	public Students(int stuNum, String firstName, String lastName,
			double fines, ArrayList<Books> booksCheckedOut) {

		studentNumber = stuNum;
		fName = firstName;
		lName = lastName;
		fine = fines;
		booksOut = booksCheckedOut;

	}

	public String studentInfo() {
		return (fName + " " + lName + ": Fines: " + fine
				+ ", Number of books: " + booksOut);
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public ArrayList<Books> getBooksOut() {
		return booksOut;
	}

	public void setBooksOut(ArrayList<Books> booksOut) {
		this.booksOut = booksOut;
	}

	public void addBook(Books book) {
		if (booksOut.size() < 3) {
			booksOut.add(book);
		}
	}

}
