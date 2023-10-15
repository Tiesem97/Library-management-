import java.sql.Statement
import java.util.*

//Shifat Mohammed 001027898
//Library Management CW COMP - 1815
class Books(
    var idBooks: Int,
    val title: String,
    val author: String,
    val yearOfPub: Int,
    val publisher: String,
    val subject: String
) {
    var jc = Javaconnect()
    var sql: String? = null
    var connection = Javaconnect.ConnectDb()
    var statement: Statement? = null
    var listBooks = ArrayList<Books>()

    @JvmOverloads
    constructor(title: String = "No title", author: String = "") : this(0, title, author, 0, "Unknown", "Unknown") {
    }

    constructor(title: String, author: String, yearOfPub: Int, publisher: String, subject: String) : this(
        1,
        title,
        author,
        yearOfPub,
        publisher,
        subject
    ) {
    }

    fun addBookToDb() {
        sql ="INSERT INTO `library`.`books` (`Title`, `Author`, `Year of Publication`, `Publisher`, `Subject`) VALUES ('" + title + "', '" + author + "', '" + yearOfPub + "', '" + publisher + "', '" + subject + "');"
        jc.exUpdate(sql) //method is used to execute a SQL statement that modifies the database, such as an INSERT, UPDATE, or DELETE statement.
    }

    fun addPublisherToDb() {
        sql = "INSERT INTO `library`.`publisher` (`Publisher`) VALUES ('" + publisher + "');"
        jc.exUpdate(sql) //method is used to execute a SQL statement that modifies the database, such as an INSERT, UPDATE, or DELETE statement.
    }

    fun deleteBookFromDb(idBooks: Int) {
        val bookId = Integer.toString(idBooks) // strores integer in variable
        sql = "delete from library.books where idBooks = $bookId;" //deletes a book from database using the unique Id of the book
        jc.exUpdate(sql) //method is used to execute a SQL statement that modifies the database, such as an INSERT, UPDATE, or DELETE statement.
    }

    fun viewAllBooks() {
        sql = "SELECT * FROM library.books;"
        jc.viewBook(sql)
    }

    fun viewBookTitle(bookTitle: String) {
        sql = "SELECT * FROM library.books where Title = '$bookTitle';"
        jc.viewBook(sql)
    }

    fun viewBookAuthor(AuthorName: String) {
        sql = "SELECT * FROM library.books where Author = '$AuthorName';"
        jc.viewBook(sql)
    }

    fun searchAuthor(searchField: String): String {
        sql = "SELECT * FROM library.books where Author = '$searchField';" //retrieve all rows for specific author from the books table in the library database
        return sql as String // return sql string to use in AdminLog class
    }

    fun searchBookTitle(searchField: String): String {
        sql = "SELECT * FROM library.books where Title = '$searchField';" //retrieve a specific book from the library database
        return sql as String // return sql string to use in AdminLog class
    }

    fun capitalFirst(txt: String): String? {
        val firstLetter = txt.substring(0, 1)
        val capitalizedFirstLetter = firstLetter.uppercase(Locale.getDefault())
        val restOfString = txt.substring(1)
        val capitalizedString = capitalizedFirstLetter + restOfString
        return capitalizedString;
    }

}