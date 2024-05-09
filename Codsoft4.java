import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.* ;
import org.JSON.JSONObject;
 
public class Codsoft4{
    public class currencyConverter{

    }
    public static void main(String args[]){
        HashMap<Integer,String> currencyCodes = new HashMap<Integer,String>();

        currencyCodes.put(1,"USD");
        currencyCodes.put(2,"CAD");
        currencyCodes.put(3,"EUR");
        currencyCodes.put(4,"HKD");
        currencyCodes.put(5,"INR");

        Integer from,to;
        String fromCode,toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the currency converter !!");

        System.out.println("Base Currency : Currency converting from ?");
        System.out.println("1:USD(US Dollar)\t 2:CAD(CAnadian Dollar)\t 3:EUR(Euro)\t 4:HKD(Hong Kong Dollar)\t 5:INR(Indian Rupee)");
        from = sc.nextInt() ;
        while(from<1|| from>5){
            System.out.println("Please select a valid currency(1-5)");
            from = sc.nextInt();
        }
        fromCode = currencyCodes.get(from);

        System.out.println("Target Currency : Currency converting to ?");
        System.out.println("1:USD(US Dollar)\t 2:CAD(CAnadian Dollar)\t 3:EUR(Euro)\t 4:HKD(Hong Kong Dollar)\t 5:INR(Indian Rupee)");
        to = sc.nextInt() ;
        while(to<1|| to>5){
            System.out.println("Please select a valid currency(1-5)");
            to = sc.nextInt();
        }
        toCode = currencyCodes.get(to);

        System.out.println("Amount you want to convert");
        amount = sc.nextFloat();

        sendHTTpGETRequest(fromCode,toCode,amount);

        System.out.println("Thank you for using the Currency Converter");
    }

    private static void sendHTTpGETRequest(String fromCode, String toCode, double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendHTTpGETRequest'");
    }

    /**
     * @param fromCode
     * @param toCode
     * @param amount
     * @param JSONObject 
     * @throws IOException
     */
    private static void sendHTTpGETRequest(String fromCode,String toCode,double amount, Object JSONObject) throws IOException{
        String GET_URL = "https://api.exchangeratesapi.io/latest?base=" + toCode + "&symbols=" + fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(fromCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount + fromCode + " = " + amount/exchangeRate + toCode);
        }
        else{
            System.out.println("GET request failed !");
        }

    }
}