package edu.qpp.crawler.repository;

import edu.qpp.crawler.domain.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by xirui on 2017/4/9.
 */
public interface ResultRepository extends JpaRepository<Result,Long> ,JpaSpecificationExecutor<Result> {

    Result findByDigest(String digest);

    List<Result> findAllByTheme(String theme);

}
