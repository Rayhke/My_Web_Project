package com.DB_Test;

import com.DB_Test.JPA.MemberEntity;
import com.DB_Test.JPA.MemberService;

import java.util.List;

public class JPA_Main {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        MemberEntity entity;
        String member_id;

        // 삽입
        entity = new MemberEntity();
        entity.setMember_id("nink2458");
        entity.setPwd("asd");
        entity.setNickname("NNNNNN");
        entity.setPhone("111111");
        entity.setEmail("asdasd@com");
        memberService.insert(entity);
        //

        // 조회
        member_id = "nink2458";
        entity = memberService.select(member_id);
        System.out.println(entity.toString());
        //

        // 수정
        member_id = "nink2458";
        entity = memberService.select(member_id);
        System.out.println("이전 데이터 : " + entity.toString());
        entity.setNickname("UUUUUU");
        entity = memberService.update(entity);
        System.out.println("이후 데이터 : " + entity.toString());
        //

        // 삭제
        member_id = "nink2458";
        entity = memberService.select(member_id);
        memberService.delete(member_id);
        //

        List<MemberEntity> entityList = memberService.findAll();
        for (MemberEntity member : entityList) {
            System.out.println(member.toString());
        }
    }
}
