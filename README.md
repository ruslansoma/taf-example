# taf-example
Test automation framework example.
Contains of two gradle modules:
* ui-example
* api-example

## How to run locally

Ui tests can be launched locally via 
> ***.\gradlew :ui-example:test***

Api tests can be launched locally via 
> ***.\gradlew :api-example:test***

## CI

Tests are running via Github actions.

Api suite runs every 1:00 AM. UI tests are running every midnight.

Tests can be launched manually, workflows are ui-tests.yml and api-tests.yml.

## Allure report 

### UI tests: 
> https://ruslansoma.github.io/taf-example/ui-example/ 
### API tests:
> https://ruslansoma.github.io/taf-example/api-example/

(Please add the id of Git Actions run at the end of the link to navigate to corresponding test-report)

e.g. https://ruslansoma.github.io/taf-example/ui-example/30 

