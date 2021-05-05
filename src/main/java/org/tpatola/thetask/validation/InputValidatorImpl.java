package org.tpatola.thetask.validation;

import org.springframework.stereotype.Component;
import org.tpatola.thetask.common.TaskConstants;

import java.util.ArrayList;
import java.util.List;

@Component
public class InputValidatorImpl implements InputValidator {


    public List<String> validateInput(String category, List<Integer> values) {
        List<String> result = new ArrayList<>();
        if (category == null || category.isEmpty()) {
            result.add(String.format("Category parameter value is required."));
        } else if (!TaskConstants.SUPPORTED_COLLECTIONS.contains(category)) {
            result.add(String.format("Category parameter value [%s] is not known.", category));

        }

        if (values == null || values.isEmpty()) {
            result.add(String.format("value parameter  is required."));
        } else {
            values.stream()
                    .filter(val -> val > TaskConstants.MAXIMUM_MAPPING_RANGE || val < 1)
                    .forEach(val -> result.add(String.format("parameter value of %s is invalid.", val)));
        }

        return result;
    }
}
