package com.example.hell.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hell.modal.Modal;
import com.example.hell.rep.Rep;

@Service
public class Serv {
	@Autowired
	private Rep rep;
	public Modal luck(Modal modal) {
		return rep.save(modal);
	}
	public List getall() {
		return rep.findAll();
	}
	public Optional<Modal> findById(long id){
		return rep.findById(id);
	}
	public void del(Modal modal) {
		rep.delete(modal);
	}
}
