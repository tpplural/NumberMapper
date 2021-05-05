package org.tpatola.thetask.validation;

import java.util.List;

public interface InputValidator {
     List<String> validateInput(String category, List<Integer> values);
}
