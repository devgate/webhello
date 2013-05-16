package myboard.repository;

import myboard.entity.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * User: HolyEyE
 * Date: 13. 2. 27. Time: 오후 5:22
 */
public class BoardMemoryRepository implements BoardRepository {

    private static int keyStore = 1;

    private static BoardMemoryRepository instance = new BoardMemoryRepository();

    private List<Board> boards = new ArrayList<Board>();

    public static BoardMemoryRepository getInstance() {
        return instance;
    }

    private BoardMemoryRepository() {

        Board board = new Board();
        board.setId(generateId());
        board.setTitle("title1");
        board.setWriter("작성자1");
        board.setContent("좋은 글 입니다.1");
        board.setPw("pw1");

        boards.add(board);
        boards.add(new Board(generateId(), "title2","작성자2","pw2","content입니다."));
    }

    @Override
    public List<Board> getBoards() {
        return boards;
    }

    @Override
    public void addBoard(Board board) {

        int newId = generateId();
        board.setId(newId);
        boards.add(board);
    }

    private synchronized int generateId() {
        return keyStore++;
    }

}
