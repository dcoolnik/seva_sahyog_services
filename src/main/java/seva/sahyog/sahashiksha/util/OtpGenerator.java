package seva.sahyog.sahashiksha.util;

import java.util.Random;

public class OtpGenerator {

    private static final String OTP_EMAIL_SUBJECT = "OneTimePassword for SahaShiksha password change request!";
    private static final String OTP_EMAIL_BODY = "The OneTimePassword for SahaShiksha password change request is ";
    private static final String numbers = "0123456789";

    public static String generateOtp() {

        Random random = new Random();
        char[] otp = new char[6];   //assuming OTP needs to be of 6 digits
        for (int i = 0; i < 6 ; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        /*int randomPin =(int) (Math.random()*9000)+1000;
        String otp  = String.valueOf(randomPin);*/
        return otp.toString();
    }

    public static void sendOtp(String emailAddress, String otp) {
        EmailSender.sendEmail(emailAddress, OTP_EMAIL_SUBJECT, OTP_EMAIL_BODY+otp);
    }

}
