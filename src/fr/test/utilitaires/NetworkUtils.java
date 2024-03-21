package fr.test.utilitaires;

import fr.test.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NetworkUtils {

    /**
     * Lance une requête REST et récupère une réponse JSON
     *
     * @param url L'URL du service web
     * @return la réponse JSON
     */
    public static String request(String url) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String jsonString = null;
        try {
            URL requestURL = new URL(Main.API_BASE_URL.concat(url));
            if (requestURL.getProtocol().toLowerCase().equals("https")) {
                trustAllCertificates();
                urlConnection = (HttpsURLConnection) requestURL.openConnection();
            } else {
                urlConnection = (HttpURLConnection) requestURL.openConnection();
            }
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return "Erreur : input stream == null";
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
            }
            if (buffer.length() == 0) {
                System.out.println("Rien à charger, le buffer est vide");
                return "Erreur : rien à afficher !";
            }
            jsonString = buffer.toString();
        } catch (IOException ex) {
            System.out.println("Erreur lors de la connexion au réseau");
            ex.printStackTrace();
            return "Erreur : " + ex.getMessage();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println("Erreur lors de la fermeture du reader");
                    ex.printStackTrace();
                    return "Erreur : " + ex.getMessage();
                }
            }
        }
        return jsonString;
    }

    /**
     * Cette méthode permet de désactiver la vérification
     * des certificats SSL utilisés par l'HTTPS.
     */
    private static void trustAllCertificates() {
        // On instancie la classe qui s'occupe de vérifier les certificats et on enlève les vérifications
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            // On récupère le contexte SSL
            SSLContext sc = SSLContext.getInstance("SSL");
            // On demande au contexte de génerer une clé de sécurité pour notre manager
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            // On lui dit d'utiiser notre gestionnaire "trustAllCerts"
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
