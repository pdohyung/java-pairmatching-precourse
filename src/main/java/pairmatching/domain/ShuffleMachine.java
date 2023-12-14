package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.enums.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.domain.enums.Course.*;

public class ShuffleMachine {
    private final List<String> crews;

    public ShuffleMachine(Course course) {
        this.crews = createCrews(course);
    }

    public List<String> getCrews() {
        return crews;
    }

    private List<String> createCrews(Course course) {
        if (course.equals(FRONTEND)) {
            return createFrontCrews();
        }
        return createBackendCrews();
    }

    private List<String> createFrontCrews() {
        List<String> frontCrews = new ArrayList<>();
        try {
            File frontendCrews = new File("src/main/resources/frontend-crew.md");
            BufferedReader frontendCrewsReader = new BufferedReader(new FileReader(frontendCrews));
            String frontendCrew;
            while ((frontendCrew = frontendCrewsReader.readLine()) != null) {
                frontCrews.add(frontendCrew);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return Randoms.shuffle(frontCrews);
    }

    private List<String> createBackendCrews() {
        List<String> backCrews = new ArrayList<>();
        try {
            File backendCrews = new File("src/main/resources/backend-crew.md");
            BufferedReader backendCrewsReader = new BufferedReader(new FileReader(backendCrews));
            String backendCrew;
            while ((backendCrew = backendCrewsReader.readLine()) != null) {
                backCrews.add(backendCrew);
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return Randoms.shuffle(backCrews);
    }
}
