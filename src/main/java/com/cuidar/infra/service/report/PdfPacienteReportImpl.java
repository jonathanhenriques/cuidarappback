package com.cuidar.infra.service.report;

import com.cuidar.api.PacienteResponseMin;
import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.repository.PacienteRepository;
import com.cuidar.domain.service.PacienteReportService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;

@Service
public class PdfPacienteReportImpl implements PacienteReportService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public byte[] emitirQuantidadeDePacientesCadastrados() {
        try {
            var inputStream = this.getClass().getResourceAsStream("/relatorios/pacientes-cadastrados.jasper");

            var parametros = new HashMap<String, Object>();
            parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var pacientes = pacienteRepository.findAll();

            // Converter a lista de pacientes para uma lista com datas convertidas
//            List<PacienteED> pacientesRelatorio = new ArrayList<>();
//            for (PacienteED paciente : pacientes) {
//                PacienteED pacienteRelatorio = new PacienteED();
//                pacienteRelatorio.setNome(paciente.getNome());
////                pacienteRelatorio.setDataCadastro(Date.from(paciente.getDataNasc().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//                // Adicione outras propriedades do paciente que você precise no relatório
//                pacientesRelatorio.add(pacienteRelatorio);
//            }

            var dataSource = new JRBeanCollectionDataSource(pacientes);
            var jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new ReportException("Não foi possível emitir relatório de quantidade de pacientes", e);
        }
    }
}