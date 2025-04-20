import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SendSMSMSG91 {

    private static final String AUTH_KEY = "390291AcFU2d6o63f351b2P1"; // Replace with env/config for security
    private static final String ROUTE = "4";
    private static final String SMS_API_URL = "https://control.msg91.com/api/sendhttp.php?";
    private static final String SENDER = "JAGGII";
    private static final String DLT_TEMPLATE_ID = "1207174461877096983";
    private static final String OTP_TEMPLATE = "Dear Customer, %s is the OTP to register your complaint. JAGGI BROTHERS";
    
    private static final Logger LOGGER = Logger.getLogger(SendSMSMSG91.class.getName());

    public static String sendTransactionalSms(String mobileNumber, String otp) {
        // Input validation
        if (mobileNumber == null || !mobileNumber.matches("\\d{10}")) {
            return "Invalid mobile number.";
        }
        if (otp == null || otp.trim().isEmpty()) {
            return "Invalid OTP.";
        }

        try {
            String message = String.format(OTP_TEMPLATE, otp);
            String encodedMessage = URLEncoder.encode(message, "UTF-8");

            // Building URL with parameters
            StringBuilder postData = new StringBuilder(SMS_API_URL);
            postData.append("authkey=").append(AUTH_KEY)
                    .append("&mobiles=+91").append(mobileNumber)
                    .append("&message=").append(encodedMessage)
                    .append("&route=").append(ROUTE)
                    .append("&sender=").append(SENDER)
                    .append("&DLT_TE_ID=").append(DLT_TEMPLATE_ID);

            // Logging request (auth key excluded)
            LOGGER.info("Sending SMS to 91" + mobileNumber + " using sender ID " + SENDER);

            // Creating connection
            URL url = new URL(postData.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                LOGGER.warning("Failed to send SMS. HTTP response code: " + responseCode);
                return "Failed to send SMS, Response Code: " + responseCode;
            }

            // Reading response
            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            LOGGER.info("SMS sent successfully. API Response: " + response);
            return "SMS sent successfully: " + response;

        } catch (MalformedURLException e) {
            LOGGER.log(Level.SEVERE, "Malformed URL", e);
            return "Error: Invalid SMS API URL.";
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IO Exception while sending SMS", e);
            return "Error: Unable to send SMS due to network issues.";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error while sending SMS", e);
            return "Error: An unexpected error occurred.";
        }
    }

    // Test the method from main()
    public static void main(String[] args) {
        String mobile = "8252470072";
        String otp = "123456";
        String result = sendTransactionalSms(mobile, otp);
        System.out.println(result);
    }
}
