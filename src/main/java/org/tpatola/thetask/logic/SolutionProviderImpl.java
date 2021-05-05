package org.tpatola.thetask.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tpatola.thetask.dataaccess.DataProvider;


import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Service
public class SolutionProviderImpl implements SolutionProvider {

    @Autowired
    private DataProvider dataProvider;

    @Override
    public Map<Integer, List<String>> getDividersWithMappings(List<Integer> values, String category) {

        Map<Integer, List<String>> result = new HashMap<>();
        Map<Integer, String> mapping = dataProvider.provideMappingForKey(category);
        Map<Integer, List<Integer>> dividersCache = new HashMap<>();


        for (Integer i : values) {
            List<String> mapped = getDividers(dividersCache,i)
                    .stream()
                    .map(mapping::get)
                    .collect(Collectors.toList());

            result.put(i,mapped);
        }
        return result;
    }

    private List<Integer> getDividers(Map<Integer, List<Integer>> cache,Integer n){
        if (n > getUpperLimit()){
            throw new InvalidParameterException("Exceeding upper limit of " + getUpperLimit());
        }
        if (!cache.containsKey(n)) {
            cache.put(n,calculateDivisors(n));
        }
        return cache.get(n);

    }

    private List<Integer> calculateDivisors(Integer input){
        return IntStream.rangeClosed(1, input).filter(i -> input % i == 0).boxed().collect(Collectors.toList());
    }
}
