package steps

import cucumber.api.Format
import pages.HistoricoPage
import static cucumber.api.groovy.EN.*
import HistoricoDeColeta.Coleta

Given (~'^estou na pagina de adicionar coleta$'){ ->
    to HistoricoPage
    at HistoricoPage
}

And (~'^nao foi adicionada uma coleta do dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy")Date dia, String rest ->
    data = dia
    restaurante = rest
    def  coleta = Coleta.findByDataAndNome(dia,rest)
    assert coleta == null
}

When (~'^preencho os campos necessarios com informa�oes validas$'){
    page.fillColetaInfo()
}
And (~'^clico em adicionar coleta do dia$'){ ->
    page.selectAdicionarColeta()
}
Then (~'^eh adicionada com sucesso$'){ ->
    coleta = Coleta.findByDataAndNome(data,restaurante)
    assert coleta != null
}



Given(~'^nao foi criada um relatorio de coleta do dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String restaurante ->
    coleta = Coleta.findByDataAndNome(dia,restaurante)
    assert coleta == null
}
When (~'^crio um novo relatorio o dia "([^"]*)" do restaurante "([^"]*)"$'){@Format("dd/MM/yyyy") Date dia, String rest ->
    data = dia
    restaurante = rest
    HistoricoTestDataAndOperations.CreateHistorico(rest,dia)
}
Then (~'o relatorio � adicionado ao historico de coletas$'){ ->
    assert Coleta.findByDataAndNome(data,restaurante) != null
}
