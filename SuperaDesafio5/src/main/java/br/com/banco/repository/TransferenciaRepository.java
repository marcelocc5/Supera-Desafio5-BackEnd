package br.com.banco.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.modelo.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

	public Optional<Transferencia> findByNomeOperadorTransacao (String nomeOperadorTransacao);
	@Query(nativeQuery = true,value = "SELECT * FROM TRANSFERENCIA WHERE data_transferencia BETWEEN :inicio and :termino")
	public List<Transferencia> findByPeriod( LocalDate inicio, LocalDate termino);
}
