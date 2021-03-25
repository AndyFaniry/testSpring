package com.mobilemoney.model.mouvement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MouvementInternet {
	public static void insertmouvInternet(int idCompte, int mo,LocalDateTime dateDebut,LocalDateTime dateFin,Connection co ) throws Exception {
		PreparedStatement st = null;
		try {
				Timestamp dDebut = Timestamp.valueOf(dateDebut);
				Timestamp dFin = Timestamp.valueOf(dateFin);
				String sql= "insert into Internet(idCompte,mo,datyDebut,datyFin) VALUES(?,?,?,?)";
				st = co.prepareStatement(sql);
				st.setInt(1,idCompte);
				st.setInt(2,mo);
				st.setTimestamp(3,dDebut);
				st.setTimestamp(4,dFin);
				st.execute();
				co.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(st != null) st.close();
		}	
	}
}
