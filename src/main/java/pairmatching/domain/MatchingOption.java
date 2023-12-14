package pairmatching.domain;

import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;

public class MatchingOption {
    private Course course;
    private Level level;
    private Mission mission;

    public MatchingOption(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    @Override
    public String toString() {
        return "MatchingOption{" +
                "course=" + course +
                ", level=" + level +
                ", mission=" + mission +
                '}';
    }
}
