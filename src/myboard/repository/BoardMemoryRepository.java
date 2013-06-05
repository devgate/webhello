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
        boards.add(new Board(generateId(), "title1","작성자1","pw1","content1 입니다."));
        boards.add(new Board(generateId(), "title2","작성자2","pw2","content2 입니다."));
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

    @Override
    public void deleteBoard(int id) {

        for(Board board: boards){
            if(board.equals(id)){
                boards.remove(id);
            }
        }

    }

    private synchronized int generateId() {
        return keyStore++;
    }

}
