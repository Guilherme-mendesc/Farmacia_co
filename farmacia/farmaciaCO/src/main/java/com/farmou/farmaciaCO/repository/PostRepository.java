package com.farmou.farmaciaCO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.farmou.farmaciaCO.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	public List<Post> findAllByCategoriaContainingIgnoreCase (String categoria);
	
	

}
