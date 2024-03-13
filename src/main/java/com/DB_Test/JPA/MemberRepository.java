package com.DB_Test.JPA;

import java.util.List;

public interface MemberRepository {

    MemberEntity insert(MemberEntity member);

    MemberEntity select(String member_id);

    MemberEntity update(MemberEntity member);

    String delete(String member_id);

    List<MemberEntity> findAll();
}