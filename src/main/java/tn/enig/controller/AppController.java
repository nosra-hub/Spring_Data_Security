package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IMateriel;
import tn.enig.model.Departement;
import tn.enig.model.Materiel;

@Controller
public class AppController {
@Autowired
IMateriel dao;
@Autowired
IDepartement daod ;

@GetMapping("/home")
public String f0(Model m) {
	List <Materiel>liste=dao.findAll();
	m.addAttribute("liste",liste) ;
	return "home" ; }
@GetMapping("/home1")
public String f1(Model m) {
	List <Departement>liste=daod.findAll();
	m.addAttribute("liste",liste) ;
	return "home1" ; 
	
}
@GetMapping("/addMateriel")
public String f2(Model m) {
	Materiel mat= new Materiel();
	List <Materiel>liste=dao.findAll();
	List <Departement>listed=daod.findAll();
	m.addAttribute("listed",listed) ;
	m.addAttribute("liste",liste) ;
	m.addAttribute("mat",mat) ;
	return "addMateriel" ; 
	
}





@PostMapping("/save")
public String get4( Model m,@ModelAttribute("mat")Materiel mat) {
	System.out.println("save");
	dao.save(mat);
	return "redirect:/home";
}
@GetMapping("/delete/{id}")
public String get5(Model m, @PathVariable("id") int id) {
	dao.delete(id);
	return "redirect:/home";
}}
