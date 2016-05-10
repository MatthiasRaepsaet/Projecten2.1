/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import domein.DomeinController;
import domein.Evaluatie;
import domein.EvaluatieMoment;
import domein.Kleuren;
import domein.Leerling;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class LoginController {

    DomeinController dc = new DomeinController();

    private LoginController lc;

    public DomeinController getDc() {
        return dc;
    }

    public void setDc(DomeinController dc) {
        this.dc = dc;
    }

    private ZoekLlnSchermController zsc = new ZoekLlnSchermController();

    @FXML
    private Button zoekButton;

    @FXML
    private Button nieuwButton;

    @FXML
    private Button haalGegevensOp;

    @FXML
    private Button postButton;

//    private DomeinController dc = new DomeinController();
//    ZoekLlnSchermController zls = new ZoekLlnSchermController(dc);
    public void veranderScherm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        dc.setZlsc(zsc);
        zsc.setDc(dc);
        loader.setLocation(getClass().getResource("ZoekLlnScherm.fxml"));
        Stage stage = (Stage) nieuwButton.getScene().getWindow();
        loader.setController(dc.getZlsc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void naarNieuwLlnScherm(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        dc.setZlsc(zsc);
        zsc.setDc(dc);
        loader.setLocation(getClass().getResource("ZoekLlnScherm.fxml"));
        Stage stage = (Stage) zoekButton.getScene().getWindow();
        loader.setController(dc.getZlsc());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void haalGegevensOp(ActionEvent event) throws IOException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/projecten/api/evaluaties");
        System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        List<Evaluatie> evaluatiesLijst = new ArrayList<>();

        Gson gson = new Gson();
        JsonArray jsona = gson.fromJson(target.request(MediaType.APPLICATION_JSON).get(String.class), JsonArray.class).getAsJsonArray();

        for (JsonElement jse : jsona) {
            Kleuren aux = null;
            System.out.println(jse);
            JsonObject jsono = gson.fromJson(jse, JsonElement.class).getAsJsonObject();
            System.out.println(jsono);
            Evaluatie e = new Evaluatie(jsono.get("evaluatieNummer").getAsString(), jsono.get("rijtechniekenScore").getAsInt(), jsono.get("verkeerstechniekenScore").getAsInt(), jsono.get("algemeneScore").getAsInt(), jsono.get("algemeneOpmerkingen").getAsString(), getByValue(jsono.get("rotonde").getAsString()), getByValue(jsono.get("rotonde").getAsString()), getByValue(jsono.get("rotonde").getAsString()), getByValue(jsono.get("rotonde").getAsString()));
            e.setEvaLijst(new ArrayList<>());
            JsonArray jsonArrayEvam = jsono.get("evaLijst").getAsJsonArray();
            System.out.println(jsonArrayEvam);
            System.out.println(jsonArrayEvam.get(0).getAsJsonObject().get("naam").getAsString());
            e.getEvaLijst().add(new EvaluatieMoment(jsonArrayEvam.get(0).getAsJsonObject().get("naam").getAsString(), null, null));
            e.getEvaLijst().add(new EvaluatieMoment("eva2", null, null));
            e.getEvaLijst().add(new EvaluatieMoment("eva3", null, null));
            e.setHuidigeEva(e.getEvaLijst().get(0));
            evaluatiesLijst.add(e);
        }
        dc.setEvaluatiesCache(evaluatiesLijst);

        client = ClientBuilder.newClient();
        target = client.target("http://localhost:8080/projecten/api/leerlingen");
        System.out.println(target.request(MediaType.APPLICATION_JSON).get(String.class));
        List<Leerling> leerlingenLijst = new ArrayList<>();

        gson = new Gson();
        jsona = gson.fromJson(target.request(MediaType.APPLICATION_JSON).get(String.class), JsonArray.class).getAsJsonArray();

        for (JsonElement jse : jsona) {
            System.out.println(jse);
            JsonObject jsono = gson.fromJson(jse, JsonElement.class).getAsJsonObject();
            System.out.println(jsono);
            Leerling l = new Leerling(jsono.get("inschrijvingsNummer").getAsString(), jsono.get("naam").getAsString().replaceAll("\"", ""), new File("src/images/" + jsono.get("inschrijvingsNummer").getAsString() + ".png"),
                    jsono.get("email").getAsString(), null);
            for (Evaluatie e : dc.getEvaluatiesCache()) {
                if (e.getEvaluatieNummer().equals(jsono.get("evaluatieNummer").getAsString().replaceAll("\"", ""))) {
                    l.setEvaluatie(e);
                }
            }
            System.out.println(l.getEvaluatie().getEvaluatieNummer());
            leerlingenLijst.add(l);
        }
        dc.setLeerlingenCache(leerlingenLijst);
    }

    public void nieuweLeerling(ActionEvent event) throws MalformedURLException, IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/projecten/api/leerlingen/");
        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        JsonObject jsonLeerling = new JsonObject();
        Leerling leerlingEnt = new Leerling();
        leerlingEnt.setNaam("ewout ghysbrecht");
        leerlingEnt.setInschrijvingsNummer("0002");
        leerlingEnt.setEmail("ewout.g@gmail.com");
        Gson gson = new Gson();
        jsonLeerling.addProperty("inschrijvingsNummer", "0002");
        jsonLeerling.addProperty("naam", "Ewout Ghysbrecht");
        jsonLeerling.addProperty("email", "ewout.g@gmail.com");
        System.out.println(jsonLeerling);
        nvps.add(new BasicNameValuePair("inschrijvingsNummer", "0002"));
        nvps.add(new BasicNameValuePair("naam", "Ewout Ghysbrecht"));
        nvps.add(new BasicNameValuePair("email", "ewout.g@gmail.com"));
        StringEntity postString = new StringEntity(gson.toJson(leerlingEnt));
        httpPost.setEntity(postString);
        System.out.println(gson.toJson(leerlingEnt));

        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        
        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
    }

    public Kleuren getByValue(String kleur) {
        if (kleur == "#FFFFFF") {
            return Kleuren.WIT;
        }
        if (kleur == "#FF0000") {
            return Kleuren.ROOD;
        }
        if (kleur == "FFA500") {
            return Kleuren.ORANJE;
        }
        if (kleur == "#00FF00") {
            return Kleuren.GROEN;
        } else {
            return Kleuren.WIT;
        }
    }
}
