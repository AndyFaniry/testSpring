package com.mobilemoney.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mobilemoney.model.Client;
import com.mobilemoney.model.Compte;
import com.mobilemoney.model.Credit;
import com.mobilemoney.model.MouvementMoney;
import com.mobilemoney.model.Response;
import com.mobilemoney.model.Token;
import com.mobilemoney.model.offre.AchatOffre;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class CompteController {
	@PostMapping(value="/compte/login")
	public Response loginClient(@RequestBody Compte compte) throws Exception {
		return compte.login();
	}
	@PostMapping(value="/compte/inscription")
	public Response inscriptionClient(@RequestBody Map<String,String> compte) throws Exception {
		Compte cmp=new Compte(Integer.parseInt(compte.get("idclient")),Integer.parseInt(compte.get("idoperateur")),compte.get("num"),compte.get("mdp"));
		return cmp.insertCompte(compte.get("nom"), compte.get("email"));
	}
	@GetMapping("/compte/getcompte")
	public Response getClient(@RequestBody Map<String,String> compte) throws Exception{
		return Compte.getCompte(Integer.parseInt(compte.get("idcompte")));
	}
	@PostMapping(value="/compte/depot")
	public Response depot(@RequestHeader("Authorization") String bearertoken,@RequestBody Map<String,String> valeur) throws Exception {
		String token= Token.deleteBearerToToken(bearertoken);
		String valeur1= valeur.get("valeur");
		Response r= Compte.depotMoney(token,valeur1);
		return r;
	}
	@PostMapping(value="/compte/achat/offre")
	public Response achatOffre(@RequestHeader("Authorization") String bearertoken,@RequestBody Map<String,String> donner) throws Exception {
		String token= Token.deleteBearerToToken(bearertoken);
		String idOffre= donner.get("idOffre");
		String daty= donner.get("daty");
		Response r= AchatOffre.achatOffre(token, idOffre, daty);
		return r;
	}
	@GetMapping(value="/compte/solde/credit")
	public Response soldeCredit(@RequestHeader("Authorization") String bearertoken) throws Exception{
		String token= Token.deleteBearerToToken(bearertoken);
		return Credit.getSoldeWebService(token);
	}
}
