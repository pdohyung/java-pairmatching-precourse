package pairmatching.domain;

import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;

import java.util.Objects;

public class MatchingOption {
    private Course course;
    private Level level;
    private Mission mission;

    public MatchingOption(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    @Override
    public String toString() {
        return "MatchingOption{" +
                "course=" + course +
                ", level=" + level +
                ", mission=" + mission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingOption that = (MatchingOption) o;
        return course == that.course &&
                level == that.level &&
                mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
