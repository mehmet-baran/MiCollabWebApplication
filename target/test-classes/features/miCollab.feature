Feature: MiCollab Web Application Automation


  Scenario: MiCollab incoming call validation
    Given the user accepts the license agreement
    When the user logs in with "QT14126@qmul.ac.uk" credentials
    Then the user should wait 120 minutes and accept all incoming calls

