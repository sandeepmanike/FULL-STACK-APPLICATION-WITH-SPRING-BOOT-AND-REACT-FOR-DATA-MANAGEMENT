package com.example.hell.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hell.modal.Modal;

@Repository
public interface Rep extends JpaRepository<Modal ,Long> {

}
