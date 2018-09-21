package org.softwire.training.bookish.controllers;

//import org.jdbi.v3.core.Jdbi;
//import org.skife.jdbi.v2.BeanMapper;
//import org.skife.jdbi.v2.DBI;
//import org.skife.jdbi.v2.Handle;
import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.User;
import org.softwire.training.bookish.viewModels.BooksPageModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Controller for the index page
 */
@Controller
public class IndexController {

//    @Autowired
//    private UserService userService;

    @RequestMapping("/")
//    ModelAndView home(Principal principal) {
    ModelAndView home() {
//        User user = userService.getUser(principal.getName());
        User user = new User();
        return new ModelAndView("index", "user", user);
    }

    @RequestMapping("/books")
    ModelAndView books() {


        Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost/bookish?user=bookish&password=bookish&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT");


        List<Book> books = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM books")
                    .mapToBean(Book.class)
                    .list();
        });

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.books = books;

        return new ModelAndView("books", "booksPageModel", booksPageModel);
    }

//    @RequestMapping("/books")
//    ModelAndView books() {
//
//
//        DBI dbi = new DBI("jdbc:mysql://localhost/bookish?user=bookish&password=bookish&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT");
//        Handle handle = dbi.open();
//
//        handle.registerMapper(new BeanMapper<Book>(Book.class));
//
//        List<Book> books = handle
//                .createQuery("SELECT * FROM books")
//                .mapTo(Book.class)
//                .list();
//
//        handle.close();
//
//
//        BooksPageModel booksPageModel = new BooksPageModel();
//        booksPageModel.books = books;
//
//        return new ModelAndView("books", "booksPageModel", booksPageModel);
//    }

    @RequestMapping("/login")
    ModelAndView login(@RequestParam Map<String, String> params) {
        return new ModelAndView("login", params);
    }
}
