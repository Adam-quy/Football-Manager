package org.example.demo.utils;

import org.example.demo.models.Match;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatchService {
    public Map<LocalDate, List<Match>> getUpcomingMatches() {
        Map<LocalDate, List<Match>> matchesByDate = new HashMap<>();

        // Saturday 26 April 2025 matches
        LocalDate saturdayDate = LocalDate.of(2025, Month.APRIL, 26);
        List<Match> saturdayMatches = new ArrayList<>();

        saturdayMatches.add(new Match(
                "Chelsea", "Everton",
                "CHE.png", "EVE.png",
                LocalTime.of(18, 30), "Stamford Bridge", "London", saturdayDate,"1 - 0"
        ));

        saturdayMatches.add(new Match(
                "Brighton", "West Ham",
                "BRI.png", "WES.png",
                LocalTime.of(21, 0), "American Express Stadium", "Falmer", saturdayDate,"3 - 2"
        ));

        saturdayMatches.add(new Match(
                "Newcastle", "Ipswich",
                "NEW.png", "IPS.png",
                LocalTime.of(21, 0), "St. James' Park", "Newcastle", saturdayDate,"3 - 0"
        ));

        saturdayMatches.add(new Match(
                "Southampton", "Fulham",
                "SOU.png", "FUL.png",
                LocalTime.of(21, 0), "St. Mary's Stadium", "Southampton", saturdayDate,"1 - 2"
        ));

        saturdayMatches.add(new Match(
                "Wolves", "Leicester",
                "WOL.png", "LEI.png",
                LocalTime.of(21, 0), "Molineux Stadium", "Wolverhampton", saturdayDate,"3 - 0"
        ));

        // Sunday 27 April 2025 matches
        LocalDate sundayDate = LocalDate.of(2025, Month.APRIL, 27);
        List<Match> sundayMatches = new ArrayList<>();

        sundayMatches.add(new Match(
                "Bournemouth", "Man Utd",
                "BOU.png", "MAN.png",
                LocalTime.of(20, 0), "Vitality Stadium", "Bournemouth", sundayDate,"2 - 2"
        ));

        sundayMatches.add(new Match(
                "Liverpool", "Spurs",
                "LIV.png", "SPU.png",
                LocalTime.of(22, 30), "Anfield", "Liverpool", sundayDate,"2 - 1"
        ));

        matchesByDate.put(saturdayDate, saturdayMatches);
        matchesByDate.put(sundayDate, sundayMatches);

        return matchesByDate;
    }
}
