package main.java.task4.utils;

/**
 * SMSMessageBuilder class
 */
public class SMSMessageBuilder {

    /**
     * buildSMSMessage method
     * method is used to form the SMS text message
     * accordingly to the Routee API pattern
     *
     * @param message
     * @param from
     * @param to
     * @return String - formed message
     */
    public static String buildSMSMessage(String message, String from, String to) {
        StringBuilder smsBuilder = new StringBuilder();
        smsBuilder.append("{\"body\":\"").append(message);
        smsBuilder.append("\",\"to\":\"").append(to);
        smsBuilder.append("\",\"from\":\"").append(from).append("\"}");

        return smsBuilder.toString();
    }
}
