package com.inflean.BestBookMS.repository;

import com.inflean.BestBookMS.domain.model.BestBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook,String> {
}
