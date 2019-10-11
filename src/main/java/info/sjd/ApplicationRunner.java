package info.sjd;

import info.sjd.model.Product;
import info.sjd.service.FilesManager;
import info.sjd.service.ProductPageParser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ApplicationRunner {

    public static final Logger LOG = Logger.getLogger(ApplicationRunner.class.getName());

    public static void main( String[] args ) {
        LOG.info("Parser started");

        List<Product> products = new ArrayList<>();
        String url = "https://prom.ua/p991841006-omen-9300h8gb512win10-gtx1660ti.html";
        ProductPageParser productPageParser = new ProductPageParser(products, url);
        productPageParser.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        products.forEach(it -> FilesManager.write(it));

        LOG.info("Parser finished");

    }
}
