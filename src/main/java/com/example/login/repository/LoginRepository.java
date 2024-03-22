package com.example.login.repository;

import com.example.users.entity.Member;

public interface LoginRepository {

    Member findById(String id);
}