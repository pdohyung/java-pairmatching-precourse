package pairmatching.controller;

import pairmatching.domain.MatchingOption;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchingRepository pairMatchingRepository;

    public PairMatchingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.pairMatchingRepository = new PairMatchingRepository();
    }

    public void run() {
        while (true) {
            String chooseFunction = retryChooseFunction();
            if (chooseFunction.equals("Q")) {
                break;
            }
            performFunction(chooseFunction);
        }
    }

    private void performFunction(String chooseFunction) {
        if (chooseFunction.equals("1")) {
            outputView.printCourseAndMission();
            matchingPair();
        }

        if (chooseFunction.equals("2")) {
            outputView.printCourseAndMission();
        }

        if (chooseFunction.equals("3")) {
            resetPair();
        }
    }

    private void matchingPair() {
        MatchingOption matchingOption = retryMatchingOption();
        List<String> pairMatchingResult = pairMatchingRepository.createPairMatching(matchingOption);
        outputView.printPairMatchingResult(pairMatchingResult);
    }

    private void resetPair() {
        pairMatchingRepository.deleteAllPairMatching();
        outputView.printResetPairMatching();
    }

    private String retryChooseFunction() {
        while (true) {
            try {
                return inputView.inputChooseFunction();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private MatchingOption retryMatchingOption() {
        while (true) {
            try {
                return inputView.inputMatchingOption();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
