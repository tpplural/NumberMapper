package org.tpatola.thetask.web;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class ResponseFormatterImpl implements ResponseFormatter{
    @Override
    public String createFormattedResponse(Map<Integer, List<String>> responseContent) {

        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<html>").append("<body>").append("<h1>").append("Mapping: </h1><br>");
        responseContent.forEach((k,v) ->   {
            htmlBuilder.append(k +" ->" + String.join(",",v)+ "<br>");
        });
        htmlBuilder.append("</body>").append("</html>");
        // encode HTML content

        return  htmlBuilder.toString();

    }
}
