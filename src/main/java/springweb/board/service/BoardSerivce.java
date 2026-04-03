package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;
import springweb.util.FileService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardSerivce {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService; // 파일서비스

    // 글 등록
    public boolean addPost(BoardDto boardDto, String loginMid){
        BoardEntity saveEntity = boardDto.toEntity();
        // 사용자 추가
        Optional<MemberEntity> memberEntity = memberRepository.findByMid(loginMid);
        if(memberEntity.isPresent()){
            saveEntity.setMemberEntity( memberEntity.get() );

            // ++++++++ 최종 DB에 엔티티를 SAVE 하기 전에 첨부파일이 존재하면 업로드 ++++++++//
            String fileName = fileService.upload(boardDto.getUploadFile() ); // 업로드 및 파일명을 반환
            // 만약에 파일을 업로드 했다면 저장할 엔티티에 파일명 저장하기
            if(fileName != null) saveEntity.setBfile( fileName );

            return boardRepository.save( saveEntity ).getBno() > 0;
        }else return false;
    }

    // 내가 쓴 글 조회
    public List<BoardDto> findAllMyPost(String loginMid){
        return boardRepository
                .findAllByMemberEntity_Mid(loginMid)
                .stream().map(BoardEntity::toDto)
                .toList();
    }
}
