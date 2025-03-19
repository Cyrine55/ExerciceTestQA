
@HomePageWithThreeSliders
Feature: HomePageWithThreeSliders
  Utilisateur veut vérifier la page accuiel contient trois sliders

  @HomePageWithThreeSliders
  Scenario: Page Acceuil contient trois slider
    Given Ouvrir application
    When Cliquer sur le bouton menu Shop 
    And Cliquer sur le bouton menu Home
    Then I validate the outcomes with '3' sliders
  

