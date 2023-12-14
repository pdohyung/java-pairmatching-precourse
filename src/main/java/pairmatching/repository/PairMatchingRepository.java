package pairmatching.repository;

import pairmatching.domain.MatchingOption;
import pairmatching.domain.ShuffleMachine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static pairmatching.util.ErrorMessage.*;

public class PairMatchingRepository {
    private final Map<MatchingOption, List<String>> pairMatchingRepository;

    public PairMatchingRepository() {
        this.pairMatchingRepository = new LinkedHashMap<>();
    }

    public Map<MatchingOption, List<String>> getPairMatchingRepository() {
        return pairMatchingRepository;
    }

    public List<String> createPairMatching(MatchingOption matchingOption) {
        ShuffleMachine shuffleMachine = new ShuffleMachine(matchingOption.getCourse());
        List<String> crews = shuffleMachine.getCrews();
        List<String> pairMatchingResult = pairMatching(crews);
        pairMatchingRepository.put(matchingOption, pairMatchingResult);
        return pairMatchingResult;
    }

    public List<String> pairMatching(List<String> crews) {
        List<String> pairedCrews = new ArrayList<>();
        int size = crews.size();

        for (int i = 0; i < size - size % 2; i += 2) {
            pairedCrews.add(crews.get(i) + " : " + crews.get(i + 1));
        }

        if (size % 2 != 0) {
            String lastPair = crews.get(size - 3) + " : " + crews.get(size - 2) + " : " + crews.get(size - 1);
            pairedCrews.set(pairedCrews.size() - 1, lastPair);
        }
        return pairedCrews;
    }

    public List<String> findPairMatching(MatchingOption matchingOption) {
        List<String> pairs = pairMatchingRepository.get(matchingOption);

        if (pairs == null) {
            throw new IllegalArgumentException(INVALID_MATCHING_OPTION.getErrorMessage());
        }

        return pairs;
    }

    public void deleteAllPairMatching() {
        pairMatchingRepository.clear();
    }
}
