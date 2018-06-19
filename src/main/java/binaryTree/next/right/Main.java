package binaryTree.next.right;


import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.*;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x)  {
            val = x;
        }
    }



    public static void temp() throws IOException {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        public java.security.cert.X509Certificate[] getAcceptedIssuers()
                        {
                            return null;
                        }
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                            //No need to implement.
                        }
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                        {
                            //No need to implement.
                        }
                    }
            };



//        System.out.println();
        // Install the all-trusting trust manager
        try
        {
            /*SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
*/
            URL url = new URL("https://www.digicert.com/");
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            // Create all-trusting host name verifier

        con.setDoOutput(true);
//        con.setRequestProperty("Cookie", "token=37e486d9-54d6-4991-b1d6-87cb109df2c7");
            con.connect();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        }


        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException, KeyStoreException, NoSuchAlgorithmException {
//        temp();
        TrustManagerFactory trustManagerFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        List<Certificate> x509Certificates = new ArrayList<>();
        trustManagerFactory.init((KeyStore)null);
        System.out.println(trustManagerFactory.getTrustManagers());
        Arrays.asList(trustManagerFactory.getTrustManagers()).stream().forEach(t -> {
            x509Certificates.addAll(Arrays.asList(((X509TrustManager)t).getAcceptedIssuers()));
        });
        /*TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.left = new TreeLinkNode(4);
        treeLinkNode.left.right = new TreeLinkNode(5);
        treeLinkNode.right.right = new TreeLinkNode(7);

        connect(treeLinkNode);*/


        System.out.println(x509Certificates);
    }

    private static void connect(TreeLinkNode treeLinkNode) {
        if(treeLinkNode == null) {
            return;
        }
        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();

        queue1.add(treeLinkNode);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if(!queue1.isEmpty()) {
                while(!queue1.isEmpty()) {
                    TreeLinkNode current = queue1.poll();
                    if(current.left != null) {
                        queue2.add(current.left);
                    }
                    if(current.right != null) {
                        queue2.add(current.right);
                    }

                    if(!queue1.isEmpty()) {
                        current.next = queue1.peek();
                    }
                }
            } else {
                while(!queue2.isEmpty()) {
                    TreeLinkNode current = queue2.poll();
                    if(current.left != null) {
                        queue1.add(current.left);
                    }
                    if(current.right != null) {
                        queue1.add(current.right);
                    }

                    if(!queue2.isEmpty()) {
                        current.next = queue2.peek();
                    }
                }
            }
        }
    }
}
