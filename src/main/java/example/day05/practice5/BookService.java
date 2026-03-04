package example.day05.practice5;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    // C
    public boolean addBook(BookDto bookDto){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBtitle( bookDto.getBtitle() );
        bookEntity.setBwriter( bookDto.getBwriter() );
        bookEntity.setBpublisher( bookDto.getBpublisher() );
        BookEntity saveEntity = bookRepo.save( bookEntity );
        return saveEntity.getBno() >= 1; // 저장된 엔티티가 1개 이상이면
    }

    // R
    public List<BookDto> printBooks(){
        List<BookEntity> bookEntityList = bookRepo.findAll(); // 전체 목록 가져옴 findAll

        List<BookDto> bookDtoList = new ArrayList<>();
        bookEntityList.forEach( bookEntity -> {
            BookDto bookDto = new BookDto();
            bookDto.setBtitle( bookEntity.getBtitle() );
            bookDto.setBwriter( bookEntity.getBwriter()) ;
            bookDto.setBpublisher( bookEntity.getBpublisher() );

            bookDtoList.add( bookDto );
        });
        return bookDtoList;
    }

    // U
    public boolean updateBook(BookDto bookDto){
        Optional<BookEntity> optional = bookRepo.findById( bookDto.getBno() );

        if( optional.isPresent() ){
            BookEntity bookEntity = optional.get();
            bookEntity.setBtitle(bookDto.getBtitle());
            bookEntity.setBwriter(bookDto.getBwriter());
            bookEntity.setBpublisher(bookDto.getBpublisher());
            return true;
        }
        return false;
    }

    // D
    public boolean deleteBook(int bno){
        bookRepo.deleteById( bno ); // bno 기준으로 삭제 진행
        return true;
    }

}
