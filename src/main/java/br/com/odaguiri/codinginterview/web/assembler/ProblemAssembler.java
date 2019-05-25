package br.com.odaguiri.codinginterview.web.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.odaguiri.codinginterview.domain.Problem;
import br.com.odaguiri.codinginterview.web.ProblemController;
import br.com.odaguiri.codinginterview.web.dto.ProblemDto;

@Component
public class ProblemAssembler extends ResourceAssemblerSupport<Problem, ProblemDto> {

	private RepositoryEntityLinks entityLinks;

	public ProblemAssembler(RepositoryEntityLinks entityLinks) {
		super(ProblemController.class, ProblemDto.class);
		this.entityLinks = entityLinks;
	}

	@Override
	public ProblemDto toResource(Problem problem) {
		ProblemDto problemDto = new ProblemDto(problem.getId(), problem.getTitle(), problem.getDescription());
		// "self" : ".../problems/{id}"
		ControllerLinkBuilder ratingLink = linkTo(methodOn(ProblemController.class).getProblemById(problem.getId()));
		problemDto.add(ratingLink.withSelfRel());
		return problemDto;
	}

}
