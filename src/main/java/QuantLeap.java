import com.studerw.tda.client.HttpTdaClient;
import com.studerw.tda.client.TdaClient;
import com.studerw.tda.model.quote.EquityQuote;
import com.studerw.tda.model.quote.Quote;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class QuantLeap {
    public static void main(String args[]) {
        log.info("Testing");
        Properties props = new Properties();
        try (InputStream input = QuantLeap.class.getClassLoader().getResourceAsStream("ql.properties")) {
            props.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        TdaClient tdaClient = new HttpTdaClient(props);
        final Quote quote = tdaClient.fetchQuote("msft");
        EquityQuote equityQuote = (EquityQuote) quote;

        System.out.println("Current price of MSFT: " + equityQuote.getAskPrice());
    }
}
