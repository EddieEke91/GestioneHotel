package it.solving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.solving.model.Stanza;
import it.solving.model.StanzaImpl;

@Controller
public class MyController {

    // jsp Device

    StanzaImpl a = new StanzaImpl();

    @GetMapping("/")
    public String index(ModelMap model) {

	return "index";
    }

    @GetMapping("/insertSta")
    public String insertStanza(Model m, @RequestParam int nStanza) {

	a.insertStanza(nStanza);

	m.addAttribute("nStanza", nStanza);

	return "insertSta";
    }

    @GetMapping("/selectSta")
    public String selectStanza(Model m, @RequestParam int id) {

	Stanza stanzaById = a.selectStanza(id);

	m.addAttribute("stanza", stanzaById);

	return "selectSta";
    }

    @GetMapping("/updateSta")
    public String updateStanza(Model m, @RequestParam int id, @RequestParam int nStanza) {

	boolean condizione = a.updateStanza(id, nStanza);
	String messaggio1 = "";
	String messaggio2 = "";

	if (condizione) {
	    messaggio1 = "numero stanza modificato";

	    System.out.println("condizione");
	    messaggio2 = String.valueOf(nStanza);

	    System.out.println(messaggio2);

	} else {
	    messaggio1 = "numero stanza non modificato";
	    messaggio2 = "rimasto invariato";
	}

	m.addAttribute("messaggio1", messaggio1);
	m.addAttribute("messaggio2", messaggio2);

	return "updateSta";
    }

    @GetMapping("/deleteSta")

    public String deleteStanza(Model m, @RequestParam int id) {

	boolean condizione = a.deleteStanza(id);
	String messaggio = "";
	if (condizione)
	    messaggio = "eliminata";
	else
	    messaggio = "non eliminata";

	m.addAttribute("messaggio", messaggio);

	return "deleteSta";
    }

    // jsp Componente

}
