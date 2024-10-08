package com.example.bookspresso.service.debate;

import com.example.bookspresso.dto.debate.BookinpoDTO;
import com.example.bookspresso.dto.debate.DebateInpoDTO;
import com.example.bookspresso.dto.debate.N_N.DebateBookDTO;
import com.example.bookspresso.dto.debate.N_N.MemberdebateDTO;
import com.example.bookspresso.dto.debate.debateMain.DebateMainPageDTO;
import com.example.bookspresso.dto.debate.page.PageRequestDTO;
import com.example.bookspresso.mapper.debate.DebateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Debateservice {
    private final DebateMapper debateMapper;
    //토론정보입력
    public void addInpo(DebateInpoDTO debateinpoDTO){
        debateMapper.insertDebateInpo(debateinpoDTO);
    }
    public void addConnection( DebateBookDTO debateBookDTO,
                               MemberdebateDTO memberDebateDTO){
        debateMapper.insertDebateBook(debateBookDTO);
        debateMapper.insertMemberDebate(memberDebateDTO);
    }


    //책 검색
    public List<BookinpoDTO> searchBookinpo(String title){
        return debateMapper.selectbookinpo(title);}




    public List<DebateMainPageDTO> findMainPage(PageRequestDTO pageRequestDTO){
        return debateMapper.selectListWithPage(pageRequestDTO);
    }
    public int findTotal(){
        return debateMapper.selectTotal();
    }




}
