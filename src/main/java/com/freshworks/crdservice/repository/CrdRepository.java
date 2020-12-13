package com.freshworks.crdservice.repository;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.freshworks.crdservice.model.CrdServiceModel;

@Repository
@EnableJpaRepositories(repositoryFactoryBeanClass = CrdServiceModel.class)
public interface CrdRepository extends MongoRepository<CrdServiceModel, String> {

	public CrdServiceModel save(CrdServiceModel crdServiceModel);
	public JSONObject findByKey(String key);
	public String deleteByKey(String key);
}
