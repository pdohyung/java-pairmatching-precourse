package pairmatching.util;

import pairmatching.domain.MatchingOption;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.util.Constants.*;
import static pairmatching.util.ErrorMessage.*;

public class InputValidator {
    public static String validateInputChooseFunction(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3") &&
                !input.equalsIgnoreCase("Q")) {
            throw new IllegalArgumentException(INVALID_CHOOSE_FUNCTION_MESSAGE.getErrorMessage());
        }
        return input;
    }

    public static MatchingOption validateInputMatchingOption(String input) {
        List<String> matchingOption = Arrays.stream(input.split(COMMA))
                .collect(Collectors.toList());

        Course course = findCourse(matchingOption.get(0));
        Level level = findLevel(matchingOption.get(1));
        Mission mission = findMission(matchingOption.get(2), level);

        return new MatchingOption(course, level, mission);
    }

    private static Course findCourse(String courseName) {
        return Arrays.stream(Course.values())
                .filter(c -> c.getName().equals(courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_MESSAGE.getErrorMessage()));
    }

    private static Level findLevel(String levelName) {
        return Arrays.stream(Level.values())
                .filter(l -> l.getName().equals(levelName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LEVEL_MESSAGE.getErrorMessage()));
    }

    private static Mission findMission(String missionName, Level level) {
        Mission mission = Arrays.stream(Mission.values())
                .filter(m -> m.getName().equals(missionName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_MESSAGE.getErrorMessage()));

        if (!mission.getLevel().equals(level)) {
            throw new IllegalArgumentException(INVALID_MISSION_MESSAGE.getErrorMessage());
        }

        return mission;
    }
}
