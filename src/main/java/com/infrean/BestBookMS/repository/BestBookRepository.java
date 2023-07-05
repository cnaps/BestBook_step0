package com.infrean.BestBookMS.repository;

import com.infrean.BestBookMS.domain.model.BestBook;
import com.infrean.BestBookMS.domain.model.vo.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BestBookRepository extends MongoRepository<BestBook,String> {
}
