package dao;

import java.util.ArrayList;

import dto.Books;
import dto.HistoryBook;



public interface BooksDAO {
	public ArrayList<Books> getAllBooks() ;
	public void insertBook(Books books);
	public void updateBook(Books books);
	public void deleteBook(int bookID);
	public void updateBorrows(int ids,int id , String date,int soLuongMuon);
	public Books getBooksById(int id);
	public int SCL (int id);
}
