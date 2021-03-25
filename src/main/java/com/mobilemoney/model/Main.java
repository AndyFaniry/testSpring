package com.mobilemoney.model;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobilemoney.bdb.ConnectionPstg;
import com.mobilemoney.controller.ClientController;
import com.mobilemoney.fonction.Fonction;
import com.mobilemoney.model.mouvement.*;
import com.mobilemoney.model.offre.*;


public class Main {
	private static final DateTimeFormatter DateTimeFormatter = null;
	@Autowired
	public ClientRepository clientRepository;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection co= new ConnectionPstg().getConnection();
		String retour="debut";
		try {
			String token="79eae1cd5763e1b0e65e22a6a4b6ffae";
			int idCompte= Token.verificationToken(token,co);
			int valeur=100;
			int idOffre=3;
			int appel=500;
			int sms=20;
			int internet= 50;
			//LocalDateTime dateDebut= LocalDateTime.now();
			//LocalDateTime dateFin= LocalDateTime.now();
			//LocalDateTime demain= dateDebut.plusDays(1);
			String datyDebut="2021-03-23T10:30:2";
			String datyFin="2021-03-19 23:14:14.687104+03";
			AchatOffre.insertAchatOffre(2,"2",datyDebut,co);
			System.out.println("ok");	
		}
		catch(Exception ex) {
			retour= ex.getMessage();
		}finally {
			if(co != null) co.close();
			System.out.println(retour);
		}
		

	}
}
