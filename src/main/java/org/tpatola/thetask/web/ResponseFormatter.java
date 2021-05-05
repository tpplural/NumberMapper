package org.tpatola.thetask.web;

import java.util.List;
import java.util.Map;

public interface ResponseFormatter {
    String createFormattedResponse( Map<Integer, List<String>> responseContent);
}
