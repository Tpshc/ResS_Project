Feature: Gerar historico de coleta
  As a membro da empresa de coleta
  I want to gerar um historico de coletas
  So that eu posso saber o desempenho da minha empresa.


  Scenario Adicionar coleta do dia no sistema
    Given estou na pagina de adicionar coleta
    And nao foi adicionada uma coleta do dia "08/04/2015" do restaurante "RU"
    When preencho os campos necessarios com informaçoes validas
    And clico em adicionar coleta do dia
    Then eh adicionada com sucesso
