package com.example.hell.cont;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hell.exp.ResourceNotFoundExcep;
import com.example.hell.modal.Modal;
import com.example.hell.serv.Serv;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1")
public class Cont {
	@Autowired
	private Serv serv;
	@PostMapping("/pm")
	public Modal create(@Valid @RequestBody Modal modal) {
	System.out.println(modal);
	return serv.luck(modal);
	}
	@GetMapping("/getstud")
	public List getstud() {
		return serv.getall();
	}
	@GetMapping("/getstud/{id}")
	public ResponseEntity getId(@PathVariable(value="id") long id) throws ResourceNotFoundExcep{
		Modal modal=serv.findById(id).orElseThrow(() -> new ResourceNotFoundExcep("student not found for this id :: " + id));
		return ResponseEntity.ok().body(modal);
	}
	@PutMapping("/upd/{id}")
	public ResponseEntity uptProf(@PathVariable(value="id")long id,@Valid @RequestBody Modal modal1) throws ResourceNotFoundExcep {
		Modal modal=serv.findById(id).orElseThrow(()->new ResourceNotFoundExcep("please check the id::"+id));
		modal.setFirstName(modal1.getFirstName());
		final Modal kk=serv.luck(modal);
		return ResponseEntity.ok(kk);}

	@DeleteMapping("del/{id}")
	public Map delRec(@PathVariable(value="id")long id) throws ResourceNotFoundExcep{
		Modal modal=serv.findById(id).orElseThrow(()->new ResourceNotFoundExcep("please check the id provided::"+id));
		serv.del(modal);
		Map nn=new HashMap<>();
		nn.put("deleted", id);
		return nn;
	}
}
