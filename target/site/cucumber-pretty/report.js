$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("services.feature");
formatter.feature({
  "line": 1,
  "name": "Task 2 - API Automated test using",
  "description": "",
  "id": "task-2---api-automated-test-using",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3577028900,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Get each country information",
  "description": "",
  "id": "task-2---api-automated-test-using;get-each-country-information",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@TestReport"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I validate GET service response",
  "rows": [
    {
      "cells": [
        "Country"
      ],
      "line": 6
    },
    {
      "cells": [
        "US"
      ],
      "line": 7
    },
    {
      "cells": [
        "DE"
      ],
      "line": 8
    },
    {
      "cells": [
        "GB"
      ],
      "line": 9
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesSteps.IValidateGETServiceResponse(DataTable)"
});
formatter.result({
  "duration": 4118361700,
  "status": "passed"
});
formatter.after({
  "duration": 574061700,
  "status": "passed"
});
});