package myboard.controller;

import myboard.entity.Board;
import myboard.repository.BoardMemoryRepository;
import myboard.repository.BoardRepository;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * User: dr.jun
 * Date: 13. 5. 14.
 * Time: 오후 7:39
 * To change this template use File | Settings | File Templates.
 */
public class BoardManageServlet extends HttpServlet {

    BoardRepository boardRepository = BoardMemoryRepository.getInstance();
    List<Board> boardList;
    String action = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   {

        boardList = boardRepository.getBoards();
        action = request.getParameter("action");

        Board board = new Board();
        board.setId(Integer.parseInt(request.getParameter("id")));
        board.setTitle(request.getParameter("title"));
        board.setWriter(request.getParameter("writer"));
        board.setPw(request.getParameter("pw"));
        board.setContent(request.getParameter("cotent"));

        if(StringUtils.equalsIgnoreCase("add", action)){
            addBoard(board);
        }else if(StringUtils.equalsIgnoreCase("update", action)){
            updateBoard(board);
        }else if(StringUtils.equalsIgnoreCase("delete", action)){
            deleteBoard( board);
        }else{

        }

    }

    private void deleteBoard( Board board) {

        for(int idx = 0; idx < boardList.size(); idx++){
            if( boardList.get(idx).getId() == board.getId()){
                boardList.remove(idx);
            }
        }
    }

    private void updateBoard(Board board) {

        for(int idx = 0; idx < boardList.size(); idx++){
            if( boardList.get(idx).getId() == board.getId()){
                boardList.set(idx, board);
            }
        }
    }

    private void addBoard(Board board) {
        boardList.add(board);
    }


}
