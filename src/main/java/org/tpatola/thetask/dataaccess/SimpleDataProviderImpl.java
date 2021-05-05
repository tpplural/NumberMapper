package org.tpatola.thetask.dataaccess;

import org.springframework.stereotype.Component;
import org.tpatola.thetask.common.TaskConstants;

import java.security.InvalidParameterException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SimpleDataProviderImpl implements DataProvider {
    @Override
    public Map<Integer, String> provideMappingForKey(String key) {
        if (!TaskConstants.SUPPORTED_COLLECTIONS.contains(key)) {
            throw new InvalidParameterException();
        }
        return IntStream.rangeClosed(1, TaskConstants.MAXIMUM_MAPPING_RANGE)
                .boxed()
                .collect(Collectors.toMap(i->i,i-> key + "_" + i));

    }
}
