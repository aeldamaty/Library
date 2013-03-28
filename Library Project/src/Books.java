
public class Books {

	private String bookTitle;// Title of Book
	private String bookAuthor;// Author of Book
	private String bookNumber;// ISBN of Book
	private String bookCategory;// Genre of Book
	private double bookCost;// Cost of Book
	private int bookStarRating;// Star Rating of Book
	private int numDaysOut;// Days Book has Been Checked Out
	private static int maxDaysOut = 14;// Max Days Book Allowed to be Checked
										// Out
	private boolean stock;// Number of Copies of Book in Library
	private boolean bookLost;// true if lost

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getBookCost() {
		return bookCost;
	}

	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}

	public int getBookStarRating() {
		return bookStarRating;
	}

	public void setBookStarRating(int bookStarRating) {
		this.bookStarRating = bookStarRating;
	}

	public int getNumDaysOut() {
		return numDaysOut;
	}

	public void setNumDaysOut(int numDaysOut) {
		this.numDaysOut = numDaysOut;
	}

	public static int getMaxDaysOut() {
		return maxDaysOut;
	}

	public static void setMaxDaysOut(int maxDaysOut) {
		Books.maxDaysOut = maxDaysOut;
	}

	public boolean getCheckedIn() {
		return stock;
	}

	public void setCheckedIn(boolean stock) {
		this.stock = stock;
	}

	public Books(String title, String author, String isbn, String category,
			double cost, int starRating, int daysOut, boolean checkedIn,
			boolean lost) {

		bookTitle = title;
		bookAuthor = author;
		bookNumber = isbn;
		bookCategory = category;
		bookCost = cost;
		bookStarRating = starRating;
		numDaysOut = daysOut;
		stock = checkedIn;
		bookLost = lost;

	}

	public String bookInfo() {
		return (bookTitle + ", " + bookAuthor);
	}

}
