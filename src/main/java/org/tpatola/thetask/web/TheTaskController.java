package org.tpatola.thetask.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tpatola.thetask.logic.SolutionProvider;
import org.tpatola.thetask.validation.InputValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TheTaskController {

    @Autowired
    private SolutionProvider solutionProvider;

    @Autowired
    private InputValidator inputValidator;

    @Autowired
    private ResponseFormatter responseFormatter;

    @GetMapping("/mapping")
    ResponseEntity provideMappings(@RequestParam String category, @RequestParam List<Integer> val) {

        List<String> params =val.stream().map(v -> v.toString()).collect(Collectors.toList());

        List<String> warnings = inputValidator.validateInput(category,val);
        if (warnings.size() > 0){
            return generateErrorResponse(warnings);
        }
        return new ResponseEntity<>(responseFormatter.createFormattedResponse(solutionProvider.getDividersWithMappings(val,category)),HttpStatus.OK);
    }

    @org.springframework.web.bind.annotation.ResponseStatus(code = org.springframework.http.HttpStatus
            .BAD_REQUEST, reason = "Some parameters are invalid")

    private ResponseEntity generateErrorResponse(List<String> warnings) {
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("<html>").append("<body>").append("<h1>");
        warnings.forEach(t->    htmlBuilder.append(t + "<br>"));
        htmlBuilder.append("</h1>").append("</body>").append("</html>");
        // encode HTML content
        return new ResponseEntity<>(htmlBuilder.toString(),HttpStatus.BAD_REQUEST);
    }

}
