# taf-example
Test automation framework example.
Contains of two gradle modules:
* ui-example
* api-example

# How to run locally ( Java 11 needed)
Ui tests can be launched locally via 
> ***.\gradlew :ui-example:test***

Api tests can be launched locally via 
> ***.\gradlew :api-example:test***

# CI
Tests can be launched via GitHub Actions manually, workflows are ui-tests.yml and api-tests.yml.

Api suite runs every 1:00 AM and UI smokes runs every midnight.

## Allure report 

### UI tests: 
> https://ruslansoma.github.io/taf-example/ui-example/ 
### API tests:
> https://ruslansoma.github.io/taf-example/api-example/

(Please add the number of Git Actions run at the end of the link to navigate to corresponding test-report)

e.g. https://ruslansoma.github.io/taf-example/ui-example/30 

