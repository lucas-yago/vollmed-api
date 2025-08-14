package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.infra.exception.ValidacaoException;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {


    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();

        var Domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDaAberturaDaClinica = dataConsulta.getHour() > 18;

        if (Domingo || antesDaAberturaDaClinica || depoisDaAberturaDaClinica) {
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}
