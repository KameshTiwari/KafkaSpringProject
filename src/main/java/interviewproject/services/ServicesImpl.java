package interviewproject.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import interviewproject.entity.Bets;
import interviewproject.entity.BetsEntity;
import interviewproject.repository.betsrepository;

@Service
public class ServicesImpl implements betsServices {
	@Autowired
	betsrepository betsrepo;

	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void addBets(Bets b1) {
		betsrepo.saveAll(b1.getBets());

	}

	@Override
	public Bets display() {

		Bets betsobj = new Bets();
		betsobj.setBets(betsrepo.findAll());

		return betsobj;

	}

	@Override
	public void addBet(BetsEntity b1) {
		betsrepo.save(b1);

	}

	@Override
	public Bets findByGameAndId(String game, long id) {
		Bets betsobj = new Bets();
		betsobj.setBets(betsrepo.findAll());
		System.out.println(betsrepo.findByGameAndId(game, id).toString());
		return betsobj;
	}

	@Override
	public Bets addBetsByJsonfile() {
		try {
			Bets betsentity = objectMapper.readValue(
					new File("C:\\Users\\kamu9\\eclipse-workspace\\InterviewProject\\src\\main\\resources\\bets.json"),
					Bets.class);

			// betsentity.getBets().forEach(i -> betsrepo.saveAll(null));
			betsrepo.saveAll(betsentity.getBets());
			System.out.println("this is demo");
			
			return betsentity;

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
