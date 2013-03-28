import java.util.ArrayList;

public class Library {

	static ArrayList<Students> students = new ArrayList<Students>();
	static ArrayList<Books> books = new ArrayList<Books>();

	static String libName;

	public Library(String name) {
		libName = name;
	}

	public void createStudent(int studentNumber, String firstName,
			String lastName) {
		students.add(new Students(studentNumber, firstName, lastName, 0.00,
				new ArrayList<Books>()));
	}

	public void createBook(String title, String author, String isbn,
			String genre, double cost, int starRating) {
		books.add(new Books(title, author, isbn, genre, cost, starRating, 0,
				true, false));
	}

	public Students findStudent(int stuNum) {
		for (int i = 0; i < students.size(); i++) {
			if (stuNum == students.get(i).getStudentNumber()) {
				return students.get(i);
			}
		}
		return null;
	}

	public Books findBookCheckOut(String input) {
		for (int i = 0; i < books.size(); i++) {
			if (input.equals(books.get(i).getBookNumber())) {
				books.get(i).setCheckedIn(false);
				return books.get(i);
			}
		}
		return null;
	}

	public ArrayList<Books> findBook(String input) {
		ArrayList<Books> booksFound = new ArrayList<Books>();
		for (int i = 0; i < books.size(); i++) {
			if (input.equals(books.get(i).getBookTitle())
					|| input.equals(books.get(i).getBookNumber())) {
				booksFound.add(books.get(i));
				// TODO add author and other things
			}
		}
		for (int k = 0; k < books.size(); k++) {
			if (input.equals(books.get(k).getBookNumber())
					&& books.get(k).getCheckedIn() == true) {
				books.get(k).setCheckedIn(false);
			}
		}
		return booksFound;
	}
}
