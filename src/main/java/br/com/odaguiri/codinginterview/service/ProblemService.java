package br.com.odaguiri.codinginterview.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.odaguiri.codinginterview.domain.Problem;
import br.com.odaguiri.codinginterview.repo.ProblemRepository;
import br.com.odaguiri.codinginterview.web.dto.ProblemDto;

@Service
public class ProblemService {

	private ProblemRepository problemRepository;

	@Autowired
	public ProblemService(ProblemRepository problemRepository) {
		this.problemRepository = problemRepository;
	}
	
	public void createNewProblem(ProblemDto problemDto) {
		problemRepository.save(new Problem(problemDto.getTitle(), problemDto.getDescription()));
	}
		
	public Optional<Problem> lookupProblemById(Integer id) {
		return problemRepository.findById(id);
	}
	
	public Page<Problem> lookupAllProblems(Pageable pageable) {
		return problemRepository.findAll(pageable);
	}
}
