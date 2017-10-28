package net.project.bookmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.project.bookmanager.model.Book;
import net.project.bookmanager.service.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
    private BookService bookService;

//    @Autowired(required = true)
//    @Qualifier(value = "bookService")
//    public void setBookService(BookService bookService) {
//        this.bookService = bookService;
//    }

    @RequestMapping(value = "/list-book", method = RequestMethod.GET)
//    public String listBooks(Model model){
    public ResponseEntity<List<Book>> listBooks(){
    	List<Book> listBook = bookService.listBooks();
//    	
//        model.addAttribute("book", new Book());
//        model.addAttribute("listBooks", this.bookService.listBooks());

    	ResponseEntity<List<Book>> entity = new ResponseEntity(listBook, HttpStatus.OK);
        return entity;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        if(book.getId() == 0){
            this.bookService.addBook(book);
        }else {
            this.bookService.updateBook(book);
        }

        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.bookService.removeBook(id);

        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());

        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdata";
    }
}
