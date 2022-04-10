package interviewproject.services;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import interviewproject.entity.Bets;

public class test {

	public static void main(String[] args) {
		ObjectMapper objectmapper= new ObjectMapper();
		try {
			Bets betsentity = objectmapper.readValue(new File("\\resources\\bets.json"), Bets.class);
			
			betsentity.getBets().forEach(i -> System.out.println(i.toString()));
			
			System.out.println("this is demo");
			
			
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
