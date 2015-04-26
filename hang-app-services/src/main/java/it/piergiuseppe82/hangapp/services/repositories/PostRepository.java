package it.piergiuseppe82.hangapp.services.repositories;

import it.piergiuseppe82.hangapp.services.repositories.model.Post;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.SpatialRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, String>, SpatialRepository<Post> {

	@Query("MATCH (n:Post) RETURN n ORDER BY n.postCreationTime DESC SKIP {skip} LIMIT {limit};")
	Iterable<Post> getAllPostpaginate(@Param("skip") long skip, @Param("limit") long limit);
	
	

}