package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByMedicoIdAndData(Long id, LocalDateTime data);


    Boolean existsByPacienteIdAndDataBetween(Long id, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
