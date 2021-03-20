package com.mobilemoney.fonction;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Fonction {
	public static String getDateNow(Connection co) throws Exception {
		String sql="SELECT CURRENT_TIMESTAMP as now";
		PreparedStatement st = null;
		String daty= "";
		try {
			st = co.prepareStatement(sql);
			ResultSet result = st.executeQuery(); 
			while(result.next()) {
				 daty = result.getString("now");			
			}	
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(st != null) st.close();
		}
		return daty;
	}
	public static String addSha1(String mdp,Connection co) throws Exception {
		String sql="select md5('"+mdp+"')";
		PreparedStatement st = null;
		String sha1= "";
		try {
			st = co.prepareStatement(sql);
			ResultSet result = st.executeQuery(); 
			while(result.next()) {
				 sha1 = result.getString("md5");			
			}	
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(st != null) st.close();
		}
		return sha1;
	}
}
