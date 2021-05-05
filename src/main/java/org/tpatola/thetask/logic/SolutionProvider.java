package org.tpatola.thetask.logic;

import org.tpatola.thetask.common.TaskConstants;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface SolutionProvider {

    default Integer getUpperLimit()  {
        return TaskConstants.MAXIMUM_MAPPING_RANGE;
    };

    Map<Integer, List<String>> getDividersWithMappings(List<Integer> values, String mapping);

}
