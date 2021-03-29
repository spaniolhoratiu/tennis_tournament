package layer_business;

import model.TennisGame;
import model.TennisMatch;
import model.TennisSet;
import model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TennisService {

    public TennisMatch createNewMatch(User player1, User player2) {
        TennisSet tennisSet = new TennisSet();
        tennisSet.setGames(Collections.singletonList(getEmptyTennisGame()));

        List<TennisSet> sets = new ArrayList<>();
        sets.add(tennisSet);

        TennisMatch tennisMatch = new TennisMatch();
        tennisMatch.setPlayer1(player1);
        tennisMatch.setPlayer2(player2);

        tennisMatch.setSets(sets);
        return tennisMatch;
    }



    private TennisGame getEmptyTennisGame() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.setP1Score("0");
        tennisGame.setP2Score("0");
        return tennisGame;
    }

}
