Feature: Elegibilidade do cliente
  Background:  
    Given que o indicador cliente correntista é "S"
    And que o indicador conta ativa é "S"
    And que o código tipo produto oferta é "AB"
    And o código produto origem é 1234

  Scenario: Cliente elegível
    When eu verifico a elegibilidade do cliente
    Then o indicador de elegibilidade do cliente deve ser "S"

  Scenario: Cliente não correntista
    Given que o indicador cliente correntista é "N"
    When eu verifico a elegibilidade do cliente
    Then o indicador de elegibilidade do cliente deve ser "N"

  Scenario: Cliente com conta não ativa
    Given que o indicador conta ativa é "N"
    When eu verifico a elegibilidade do cliente
    Then o indicador de elegibilidade do cliente deve ser "N"

  Scenario: Cliente com tipo de produto oferta não elegível
    Given que o código tipo produto oferta é "CC"
    When eu verifico a elegibilidade do cliente
    Then o indicador de elegibilidade do cliente deve ser "N"

  Scenario:  Cliente com tipo de produto origem não elegível
    Given que o código tipo produto oferta é "CC"
    And o código produto origem é 5555
    When eu verifico a elegibilidade do cliente
    Then o indicador de elegibilidade do cliente deve ser "N"
