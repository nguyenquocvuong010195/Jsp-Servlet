package service;

import java.util.List;

import dto.Books;

public interface BookService {
	List<Books> getAllBooks();
	Books getBooksById(int id);
	boolean updateBorrows(int idMuon, int id, int soLuongMuon);
}
