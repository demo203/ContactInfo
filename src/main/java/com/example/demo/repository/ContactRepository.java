package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{

}
