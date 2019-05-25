package br.com.odaguiri.codinginterview.web;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.odaguiri.codinginterview.domain.Problem;
import br.com.odaguiri.codinginterview.service.ProblemService;
import br.com.odaguiri.codinginterview.web.assembler.ProblemAssembler;
import br.com.odaguiri.codinginterview.web.dto.ProblemDto;

@RestController
@RequestMapping(path = "/problems")
public class ProblemController {

	private ProblemService problemService;
	private ProblemAssembler problemAssembler;
	
	@Autowired
	public ProblemController(ProblemService problemService, ProblemAssembler problemAssembler) {
		this.problemService = problemService;
		this.problemAssembler = problemAssembler;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewProblem(@RequestBody @Validated ProblemDto problemDto) {
		problemService.createNewProblem(problemDto);
	}
	
	@GetMapping
	public PagedResources<ProblemDto> getAllProblems(Pageable pageable, PagedResourcesAssembler pagedAssembler) {
		Page<Problem> problemPage = problemService.lookupAllProblems(pageable);
		PagedResources<ProblemDto> result = pagedAssembler.toResource(problemPage, problemAssembler);
		return result;
	}
	
	@GetMapping("/{id}")
	public ProblemDto getProblemById(@PathVariable("id") Integer id) {
		return problemAssembler.toResource(problemService.lookupProblemById(id)
                .orElseThrow(() -> new NoSuchElementException("Problem " + id + " not found"))
         );
	}
	
}
