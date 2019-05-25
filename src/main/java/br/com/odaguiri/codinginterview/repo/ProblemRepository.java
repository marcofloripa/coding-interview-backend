package br.com.odaguiri.codinginterview.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.odaguiri.codinginterview.domain.Problem;

@Repository
@RepositoryRestResource(exported = false)
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

	Page<Problem> findById(Integer id, Pageable pageable);
}
