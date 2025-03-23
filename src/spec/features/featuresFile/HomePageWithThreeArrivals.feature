
@HomePageWithThreeArrivals
Feature: HomePageWithThreeSliders
  Utilisateur veut vérifier la page accuiel contient trois sliders

  @HomePageWithThreeArrivals
  Scenario: Page Acceuil contient trois arrivals
    Given Ouvrir application
    When Cliquer sur le bouton menu Shop 
    And Cliquer sur le bouton menu Home
    Then I validate the outcomes with '3' arrivals
  

