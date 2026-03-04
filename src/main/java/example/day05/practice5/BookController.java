package example.day05.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day05/practice5")
public class BookController {

    @Autowired
    private BookService bookSvc;

    @GetMapping
    public List<BookDto> printBooks(){
        return bookSvc.printBooks();
    }

    @PostMapping
    public boolean addBook(@RequestBody BookDto bookDto){
        return bookSvc.addBook(bookDto);
    }

    @DeleteMapping
    public boolean deleteBook(@RequestParam int bno){
        return bookSvc.deleteBook(bno);
    }

    @PutMapping
    public boolean updateBook(@RequestBody BookDto bookDto){
        return bookSvc.updateBook(bookDto);
    }
}
