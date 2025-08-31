package io.book.library.application.service;

import io.book.library.application.dto.UserDTO;
import io.book.library.application.service.interfaces.ReportService;
import io.book.library.infrastructure.report.PdfReportHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    public void gerarRelatorioUsuarios(List<String> usuarios) {
        PdfReportHelper.gerarRelatorioUsuarios(usuarios, "usuarios.pdf");
    }
}
