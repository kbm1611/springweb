package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardSerivce {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 글 등록
    public boolean addPost(BoardDto boardDto, String loginMid){
        BoardEntity saveEntity = boardDto.toEntity();
        // 사용자 추가
        Optional<MemberEntity> memberEntity = memberRepository.findByMid(loginMid);
        if(memberEntity.isPresent()){
            saveEntity.setMemberEntity( memberEntity.get() );
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
