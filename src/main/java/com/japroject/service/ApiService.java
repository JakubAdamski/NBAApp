package com.japroject.service;

import com.japroject.model.NbaGame;
import com.japroject.repository.NbaGameRepository;
import jakarta.annotation.PostConstruct;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@NoArgsConstructor
public class ApiService {

    @Autowired
    private NbaGameRepository nbaGameRepository;

    @PostConstruct
    public void init() {
        fetchAndSaveGames("2023");
    }

    public void fetchAndSaveGames(String season) {
        try {
            String urlString = "https://api-nba-v1.p.rapidapi.com/games?season=" + season;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", "2523971080msh2289df27ab1e542p16db7ajsnff483b974945");
            connection.setRequestProperty("X-RapidAPI-Host", "api-nba-v1.p.rapidapi.com");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray gamesArray = jsonResponse.getJSONArray("response");
                for (int i = 0; i < gamesArray.length(); i++) {
                    JSONObject gameObj = gamesArray.getJSONObject(i);
                    saveGame(gameObj);
                }
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveGame(JSONObject gameObj) {
        NbaGame nbaGame = new NbaGame();

        nbaGame.setSeason(gameObj.getInt("season"));

        JSONObject dateObj = gameObj.getJSONObject("date");
        if (dateObj != null && !dateObj.isNull("start")) {
            nbaGame.setGameDate(parseDate(dateObj.getString("start")));
        }

        JSONObject statusObj = gameObj.getJSONObject("status");
        if (statusObj != null && !statusObj.isNull("long")) {
            nbaGame.setGameStatus(statusObj.getString("long"));
        }

        // Dodanie informacji o drużynach
        JSONObject teamsObj = gameObj.getJSONObject("teams");
        JSONObject homeTeam = teamsObj.getJSONObject("home");
        JSONObject visitorTeam = teamsObj.getJSONObject("visitors");

        nbaGame.setHomeTeamName(homeTeam.getString("name"));
        nbaGame.setHomeTeamLogoUrl(homeTeam.getString("logo"));
        nbaGame.setHomeTeamCode(homeTeam.getString("code"));
        nbaGame.setVisitorTeamName(visitorTeam.getString("name"));
        nbaGame.setVisitorTeamLogoUrl(visitorTeam.getString("logo"));
        nbaGame.setVisitorTeamCode(visitorTeam.getString("code"));

        // Dodanie wyników
        JSONObject scoresObj = gameObj.getJSONObject("scores");
        JSONObject homeScores = scoresObj.optJSONObject("home");
        JSONObject visitorScores = scoresObj.optJSONObject("visitors");

        nbaGame.setHomeTeamPoints(homeScores != null && !homeScores.isNull("points") ? homeScores.getInt("points") : null);
        nbaGame.setVisitorTeamPoints(visitorScores != null && !visitorScores.isNull("points") ? visitorScores.getInt("points") : null);

        nbaGameRepository.save(nbaGame);
    }

    public LocalDateTime parseDate(String date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(date, formatter);
    }
}
