package com.miniweb.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;
import com.miniweb.model.Standings;
import com.minweb.restclinet.RestClient;

@Path("/")
public class RestAPI {

	@GET
	@Path("/standings/countryname")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Standings> getByCountry(@QueryParam("countryName") String countryName) {
		Standings standings = null;
		List<Standings> standingsList = new ArrayList<>();
		
		JSONArray jsonArray = new JSONArray(RestClient.executeAPI());
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject explrObject = jsonArray.getJSONObject(i);
			if (explrObject.get("country_name").equals(countryName)) {
				standings = new Standings();
				standings.setCountryNAme(explrObject.get("country_name").toString());
				standings.setLeagueName(explrObject.get("league_name").toString());
				standings.setTeamName(explrObject.get("team_name").toString());
				standings.setLeaguePosition(explrObject.get("overall_league_position").toString());
				standingsList.add(standings);
			}
		}
		return standingsList;
	}
	
	@GET
	@Path("/standings")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStandings() {
		return RestClient.executeAPI();
	}

}
