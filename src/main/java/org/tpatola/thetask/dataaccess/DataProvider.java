package org.tpatola.thetask.dataaccess;

import java.util.Map;

/**
 * Provides methods to retrieve mappings pro category from underlying datasource.
 */
public interface DataProvider {
    /**
     * Retrieves mappings for given category.
     * @param key defines category
     * @return map containing values for given category
     */
    Map<Integer,String> provideMappingForKey(String key);
}
