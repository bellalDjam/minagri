package dz.minagri.stat.repositories;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.minagri.stat.model.Commune;
import dz.minagri.stat.model.Wilaya;



@Repository
public interface CommuneRepository  extends  JpaRepository<Commune, Long>{
	
	List<Commune> findByNameLike(String lastName, Pageable pageable);
	List<Commune> findAllByNameContainingIgnoreCase(String name);
//	List<Commune> findAllCommunesAndWilayaNomWilayaContainingIgnoreCase(String nomWilaya);
	Commune findByNameLike(String name);
	Commune findOneByName(String name);

}