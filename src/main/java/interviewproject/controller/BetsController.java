package interviewproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import interviewproject.entity.Bets;
import interviewproject.entity.BetsEntity;
import interviewproject.services.betsServices;

@RestController
public class BetsController {
	@Autowired
	betsServices betsSer;
	
	@Autowired
	public KafkaTemplate<String, Object> template;
	public String topic= "test1";
	
	@PostMapping("/add")
	public void addBets(@RequestBody Bets b1)
	{
		betsSer.addBets(b1);
		b1.getBets().forEach(i-> System.out.println(i.toString()));
		template.send(topic, b1.getBets().toString());
	}
	@GetMapping("/display")
	public Bets display()
	
	{
		Bets b= betsSer.display();
		//template.send(topic, b);
		return betsSer.display();
		
	}
	@PostMapping("/addi")
	public void addBet(@RequestBody BetsEntity b1)
	{
		betsSer.addBet(b1);
		template.send(topic, b1.toString());
	}
	
	@PostMapping("/findbyfilter")
	public Bets findByGameAndId(@RequestBody BetsEntity b)
	{
		
		return betsSer.findByGameAndId(b.getGame(), b.getId());
	}
	
	@PostMapping("/addByFile")
	public Bets addBetsByJsonfile()
	{
		Bets b1=betsSer.addBetsByJsonfile();
		b1.getBets().forEach(i-> System.out.println(i));
		
		template.send(topic, b1.getBets().toString());
		return b1;
	}
	
	

}
