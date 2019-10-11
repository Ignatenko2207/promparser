package info.sjd.service;

import info.sjd.model.Product;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class ProductPageParser extends Thread {

    private List<Product> products;
    private final String url;

    public ProductPageParser(List<Product> products, String url) {
        this.products = products;
        this.url = url;
    }

    @Override
    public void run() {

        try {
            Document document = Jsoup.connect(url).get();
            Element productInfo = document.getElementsByAttributeValue("data-qaid", "main_product_info").first();

            String code = getCode(productInfo);
            String name;
            BigDecimal price;
            BigDecimal initPrice;
            String avialability;
            String url;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCode(Element element) {
        Elements codeElements = element.getElementsByAttributeValue("data-qaid", "product-sku");
        if (codeElements.isEmpty()) {
            return "";
        }
        return codeElements.first().text();
    }
}
