package interviewproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import interviewproject.entity.BetsEntity;

@org.springframework.stereotype.Repository
public interface betsrepository extends JpaRepository<BetsEntity, Long> {

	public BetsEntity findByGameAndId(String game, long Id);
	
}
