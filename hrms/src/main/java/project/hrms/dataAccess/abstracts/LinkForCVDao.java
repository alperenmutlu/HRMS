package project.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.LinkForCV;


public interface LinkForCVDao extends JpaRepository<LinkForCV, Integer>{
	LinkForCV getById(int id);
	List<LinkForCV> getAllByJobSeeker_id(int id);
}
