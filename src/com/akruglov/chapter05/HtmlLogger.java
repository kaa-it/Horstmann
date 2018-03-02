package com.akruglov.chapter05;

import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.*;

public class HtmlLogger {

    private static class HtmlFormatter extends Formatter {

        @Override
        public String getHead(Handler h) {
            StringBuilder sb = new StringBuilder();
            sb.append("<!DOCTYPE html>\n");
            sb.append("<head>\n");
            sb.append("<title>My application log file</title>\n");
            sb.append("</head>\n");
            sb.append("<body>\n");
            sb.append("<table width=\"100%\" border=\"2\" cellpadding=\"5\">\n");
            sb.append("<thead>\n");
            sb.append("<tr>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Sequence");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Milliseconds");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Logger");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Level");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Class");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Method");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Thread ID");
            sb.append("</th>\n");
            sb.append("<th style=\"width: auto; padding: 5px;\">");
            sb.append("Message");
            sb.append("</th>\n");
            sb.append("</tr>\n");
            sb.append("</thead>\n");
            sb.append("<tbody>\n");

            return sb.toString();
        }

        @Override
        public String format(LogRecord record) {
            StringBuilder sb = new StringBuilder();

            sb.append("<tr>\n");
            sb.append("<td>");
            sb.append(record.getSequenceNumber());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getMillis());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getLoggerName());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getLevel().toString());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getSourceClassName());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getSourceMethodName());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getThreadID());
            sb.append("</td>\n");
            sb.append("<td>");
            sb.append(record.getMessage());
            sb.append("</td>\n");
            sb.append("</tr>\n");

            return sb.toString();
        }

        @Override
        public String getTail(Handler h) {
            StringBuilder sb = new StringBuilder();

            sb.append("</tbody>\n");
            sb.append("</table>\n");
            sb.append("</body>\n");
            sb.append("</html>");

            return sb.toString();
        }
    }

    static {
        Logger logger = Logger.getLogger("com.akruglov.chapter05");

        try {
            FileHandler handler = new FileHandler("myapp.log.%u.html");
            handler.setFormatter(new HtmlFormatter());
            logger.setUseParentHandlers(false);
            logger.addHandler(handler);
        } catch (IOException e) {
            System.out.println("Can not initialize log file.");
        }
    }

    public static BigInteger factorial(int n) {
        Logger logger = Logger.getLogger("com.akruglov.chapter05");
        logger.info("Factorial: " + n);

        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(factorial(100));
    }
}
