package 종합.예제10.board.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.예제10.board.dto.BoardDto;
import 종합.예제10.board.entity.BoardEntity;
import 종합.예제10.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BoardService {

    @Autowired
    private BoardRepository boardRepo;

    //등록
    public boolean bSvc(BoardDto boardDto){
        BoardEntity boardEntity = boardDto.toEntity();

        return boardRepo.save( boardEntity ).getBno() > 0;
    }

    //전체조회
    public List<BoardDto> bFindAll(){
        List<BoardEntity> boardEntityList = boardRepo.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(boardEntity -> {
            BoardDto boardDto = boardEntity.toDto();
            boardDtoList.add(boardDto);
        });
        return boardDtoList;
    }

    //개별조회
    public BoardDto bGet(Integer bno){
        Optional<BoardEntity> optional = boardRepo.findById(bno);
        if(optional.isPresent()){
            return optional.get().toDto();
        }else{
            return null;
        }
    }

    //삭제
    public boolean bDel(Integer bno){
        boolean exists = boardRepo.existsById( bno );

        if(exists){
            boardRepo.deleteById( bno );
            return true;
        }else{
            return false;
        }

    }

    //수정
    public boolean bUpd(BoardDto boardDto){
        Optional<BoardEntity> optional = boardRepo.findById(boardDto.getBno());
        if(optional.isPresent()){
            BoardEntity boardEntity = optional.get();
            boardEntity.setBtitle(boardDto.getBtitle()); boardEntity.setBcontent(boardDto.getBcontent());
            boardEntity.setBwriter(boardDto.getBwriter());
            return true;
        }else{
            return false;
        }
    }
}
