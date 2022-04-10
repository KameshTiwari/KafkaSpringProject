package interviewproject.services;

import java.util.List;

import interviewproject.entity.Bets;
import interviewproject.entity.BetsEntity;

public interface betsServices {
	
	public void addBets(Bets b1);
	public Bets display();
	public void addBet(BetsEntity b1);
	public Bets findByGameAndId(String game, long id);
	public Bets addBetsByJsonfile();

}

