package com.mobilemoney.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.mobilemoney.bdb.ConnectionMongo;
import com.mobilemoney.bdb.ConnectionPstg;
import com.mobilemoney.controller.ClientController;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


public class Main {
	@Autowired
	public ClientRepository clientRepository;
	public  List<Client> getAll(){
		return clientRepository.findAll();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection co= new ConnectionPstg().getConnection();
		new Client().InsertClient("Mihaja", "mihaja@gmail.com");
//		MongoDatabase db=new ConnectionMongo().connect();
//		MongoCollection<Document> coll=db.getCollection("client");
//		MongoCursor<Document> curs=coll.find(new Document("_id", 1)).iterator();
//		while(curs.hasNext())
//	    {
//	        System.out.println(curs.next().get("nom"));
//	    }
//		String retour="debut";
//		try {	
//		    ArrayList<Client> pl=Client.getListeClient();
//		    for(int i=0;i<pl.size();i++)
//		    {
//		    	System.out.println("code: "+pl.get(i).getId());
//		    	System.out.println("nom: "+pl.get(i).getNom());
//		    	System.out.println("email: "+pl.get(i).getEmail());
//		    }
//		}
//		catch(Exception ex) {
//			retour= ex.getMessage();
//		}finally {
//			if(co != null) co.close();
//			System.out.println(retour);
//		}
		

	}
}
