package com.manning.repository;

import com.manning.repository.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> { // extends CrudRepository<Course, Long>

    // 카테고리 기준으로 모든 과정 정보 목록 조회. 목록은 Iterable 타입으로 반환한다.
    @Query("SELECT c FROM Course c WHERE c.category=?1")    // JPQL 쿼리문
    Iterable<Course> findAllByCategory(String category);

    // 카테고리 기준으로 모든 과정 정보 목록을 조회해서 이름 기준으로 정렬한다.
    Iterable<Course> findAllByCategoryOrderByName(String category);

    Iterable<Course> findAllByCategoryAndRating(String category, int rating);

    // 이름으로 과정을 조회해서 같은 이름을 가진 과정이 있으면 true, 없으면 false 를 반환한다.
    boolean existsByName(String name);

    // 카테고리 기준으로 조회한 과정 정보의 개수를 반환한다.
    Long countByCategory(String category);

    // 이름이 같거나 카테고리가 같은 과정 목록을 Iterable 타입으로 반환한다.
    Iterable<Course> findByNameOrCategory(String name, String category);

    // 이름이 주어진 문자열로 시작하는 과정 목록을 Iterable 타입으로 반환한다.
    Iterable<Course> findByNameStartsWith(String name);

    // 카테고리 기준으로 모든 과정 정보 목록을 Java 8 Stream 타입으로 반환한다.
    Stream<Course> streamAllByCategory(String category);
}
