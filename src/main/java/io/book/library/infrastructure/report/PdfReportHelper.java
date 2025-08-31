package io.book.library.infrastructure.report;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;
import java.util.List;

public class PdfReportHelper {

    public static void gerarRelatorioUsuarios(List<String> usuarios, String fileName) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 18);
            content.newLineAtOffset(200, 750);
            content.endText();
            float y = 700;

            for (String usuario : usuarios) {
                content.beginText();
                content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
                content.newLineAtOffset(200, 750);
                content.showText(usuario);
                content.endText();
                y -= 20;
            }

            content.close();
            document.save(fileName);

        } catch (IOException e) {

            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }
}
