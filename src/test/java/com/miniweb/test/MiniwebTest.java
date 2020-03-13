package com.miniweb.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.miniweb.api.RestAPI;
import com.miniweb.model.Standings;

public class MiniwebTest {

	RestAPI restAPI = new RestAPI();

	@Before
	public void setupInitial() throws Exception {

	}

	@Test
	public void getgetByCountryTest() {
		List<Standings> standingsList = new ArrayList<>();
		try {
			standingsList = restAPI.getByCountry("England");
			System.out.println(standingsList.toString());
			assertNotNull(standingsList);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void getgetStandingsTest() {
		String result = "";
		try {
			result = restAPI.getStandings();
			System.out.println(result);
			assertNotNull(result);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
