package steps

import HistoricoDeColeta.ColetaController
import cucumber.api.Format

class HistoricoTestDataAndOperations {

    static  coletas = [

             nome:"RU",
             data: ("08/04/2015"),
             volume: 101,

    ]

    static public def getColeta(){
        return findColetaByNomeData("RU",("08/04/2015") )
    }

    static public def findColetaByNomeData(String rest,@Format("dd/MM/yyyy") Date date ) {
        coletas.find { coleta ->
            coleta.nome == rest
            coleta.data = date
        }
    }



    static public void CreateHistorico(String rest,@Format("dd/MM/yyyy") Date dia){
        def cont = new ColetaController()

        cont.params << [nome: rest, data: dia, volume: 101]
        cont.create()
        cont.save()
        cont.response.reset()
    }
}
