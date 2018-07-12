package interview.palntir;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] datafeed = new String[] {"Nick;START",
                "Jeremy;START",
                "Leah;START",
                "Nick;1000000000000",
                "Jeremy;START",
                "Leah;15",
                "Jeremy;8,14"
        };
        String[] violations = findViolations(datafeed);

        for(int i = 0; i < violations.length; i++) {
            System.out.println(violations[i]);
        }
    }

    static String[] findViolations(String[] datafeed) {
        Map<String, List<Long[]>> lowestInvoiceIdMap = new HashMap<>();
        Long largestInvoiceId = Long.MIN_VALUE;
        ArrayList<String> violations = new ArrayList<>();

        for(int i = 0; i < datafeed.length; i++) {
            System.out.println(datafeed[i]);
            String[] data = datafeed[i].split(";");
            if(data[1].equals("START")) {
                if(lowestInvoiceIdMap.containsKey(data[0])) {
                    List<Long[]> invoiceId = lowestInvoiceIdMap.get(data[0]);
                    invoiceId.add(new Long[] {Long.valueOf(i), largestInvoiceId});
                } else {
                    List<Long[]> invoiceId = new LinkedList<>();
                    invoiceId.add(new Long[] {Long.valueOf(i), largestInvoiceId});
                    lowestInvoiceIdMap.put(data[0], invoiceId);
                }
            } else {
                String[] dataNumber = data[1].split(",");
                if(dataNumber.length == 1) {
                    Long invoice = Long.parseLong(data[1]);
                    if (invoice < lowestInvoiceIdMap.get(data[0]).get(0)[1]) {
                        violations.add(new String(lowestInvoiceIdMap.get(data[0]).get(0)[0] + 1 + ";" + data[0] + ";" + "SHORTENED_JOB"));
                    }
                    if (invoice > largestInvoiceId) {
                        largestInvoiceId = Long.parseLong(data[1]);
                    }
                } else {
                    List<Long[]> invoiceId = lowestInvoiceIdMap.get(data[0]);
                    Arrays.sort(dataNumber, Collections.reverseOrder());
                    boolean violation = false;

                    int currentPos = 0;
                    for(Long[] invoiceValue : invoiceId) {
                        System.out.println(Arrays.asList(dataNumber));
                        int invoice = Integer.parseInt(dataNumber[currentPos]);
                        if(invoice < invoiceValue[1]) {
                            violation = true;
                            violations.add(new String(invoiceValue[0] + 1 + ";" + data[0] + ";" + "SHORTENED_JOB"));
                        }
                        currentPos++;
                    }
                    if(violation) {
                        violations.add(new String(i + 1 + ";" + data[0] + ";" + "SUSPICIOUS_BATCH"));
                    }
                }
                lowestInvoiceIdMap.remove(data[0]);
            }
        }

        return violations.toArray(new String[violations.size()]);
    }

}
