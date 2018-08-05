package com.goods.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class CreateDocumentService {

    public ByteArrayInputStream createPdf() throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BaseFont baseFont = BaseFont.createFont("static/fonts/TAHOMA_0.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont, 10);
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        PdfWriter.getInstance(document, out);
        document.open();
        document.add(new Paragraph("г.Минск                                                             ДОГОВОР №123                                                    " + new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime()), font));
        document.add(new Paragraph("ООО \"СЕРВИСПИЩЕТОРГгрупп\", именуемое в дальнейшем Продавец, в лице директора Слижова И.Л., действующего на основании Устава, с одной стороны, и ИООО «Кроноспан» именуемое в дальнейшем Покупатель, в лице ____________________________________, с другой стороны заключили настоящий Договор о нижеследующем:", font));
        document.add(new Paragraph("1. Покупатель обязуется оплатить и принять в собственность, а Продавец обязуется передать в собственность Покупателя оборудование для общепита, далее - товар согласно Договору, являющемуся одновременно спецификацией, счет-фактурой и протоколом согласования цен.\n\n", font));
        document.add(createHeader(table, font));
        document.add(new Paragraph("", font));
        document.add(new Paragraph("", font));
        document.add(new Paragraph("2. Продавец поставляет товар согласно договору, в течение 20-ти рабочих дней с момента поступления предоплаты на р/с Продавца. Доставка на склад Покупателя.", font));
        document.add(new Paragraph("3. Продавец даёт гарантию на поставляемый товар сроком 12 месяцев с момента продажи, при условии соблюдения правил эксплуатации и ежемесячного технического обслуживания оборудования (наличие гарантийного талона на товар обязательно). Гарантия на изделие не включает в себя техническое обслуживание оборудования в течение гарантийного срока. Техническое обслуживание производится за отдельную плату, согласно договору на обслуживание оборудования. На товар производства РБ гарантийные обязательства несёт завод-изготовитель.", font));
        document.add(new Paragraph("4. О визуальных и скрытых дефектах товара Покупатель обязан сообщить в течение 10 (десяти)  дней с момента получения оборудования.", font));
        document.add(new Paragraph("5. Оплата: 50% предоплата в течение 5-ти банковских дней от даты составления договора, оставшиеся 50% перед отгрузкой каждой партии товара. В случае несвоевременной оплаты цена и срок поставки могут быть изменены.", font));
        document.add(new Paragraph("6. Все споры и разногласия, возникающие между сторонами при исполнении настоящего Договора, разрешаются путём взаимного согласия. При не достижении согласия сторон, с применением обязательной внесудебной процедуры разрешения спора, с предъявлением письменной претензии (заказным почтовым уведомлением), подлежащей рассмотрению в 30-ти дневный срок с момента её получения. В случае невозможности урегулирования споров с использованием внесудебной процедуры, такие споры передаются на рассмотрение в Экономический суд по месту нахождения ответчика и рассматриваются в соответствии с законодательством РБ.", font));
        document.add(new Paragraph("7. Дополнительные условия: Продавец за нарушение срока поставки товара уплачивает Покупателю пеню в размере 0,15% от стоимости не поставленного в срок товара за каждый день просрочки.", font));
        document.add(new Paragraph("8. Цель покупки: для собственного потребления.", font));
        document.add(new Paragraph("9. Договор, переданный посредством факсимильной связи, имеет полную юридическую силу.", font));
        Paragraph p1 = new Paragraph("ЮРИДИЧЕСКИЕ АДРЕСА СТОРОН:", font);
        p1.setAlignment(Element.ALIGN_CENTER);
        document.add(p1);
        document.add(new Paragraph("                        ПРОДАВЕЦ                                                                         ПОКУПАТЕЛЬ", font));
        document.add(createFooter(font));
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

    private static PdfPTable createHeader(PdfPTable table, Font font) {
        ArrayList<String> list = new ArrayList<>();
        list.add("№");
        list.add("Наименование");
        list.add("Кол-во");
        list.add("Цена, руб. коп.");
        list.add("Сумма, руб. коп.");
        list.add("Став-ка НДС, %");
        list.add("Сумма НДС, руб. коп.");
        list.add("Всего стоимость с НДС, руб. коп.");
        for (String str : list) {
            PdfPCell cell = new PdfPCell(new Phrase(str, font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        return table;
    }

    private static PdfPTable createFooter(Font font) throws BadPdfFormatException, IOException, BadElementException {
        ArrayList<String> list = new ArrayList<>();
        list.add("ООО \"СЕРВИСПИЩЕТОРГгрупп\"");
        list.add("220090 г. Минск, Логойский тракт, 22А, пом. 112");
        list.add("р/с BY35UNBS30120332010020010933 в ЗАО \"БСБ Банк\"");
        list.add("г. Минск, Логойский тракт, 15, корп.4");
        list.add("УНП 192819056, БИК: UNBSBY2X");
        list.add("ф (017) 237-58-82, т. 237-58-79 (72-78)");
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        for (String str : list) {
            PdfPCell cell = new PdfPCell(new Phrase(str, font));
            cell.setBorder(Rectangle.NO_BORDER);
            table.addCell(cell);
            table.addCell(cell);
        }
        table.addCell(new PdfPCell(Image.getInstance("D:\\Goods\\src\\main\\resources\\static\\image\\signature.png")));
        PdfPCell cell1 = new PdfPCell(new Phrase("______________ Директор Л.В. Сырникова", font));
        cell1.setBorder(Rectangle.NO_BORDER);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setPaddingTop(80);
        table.addCell(cell1);
        return table;
    }
}
