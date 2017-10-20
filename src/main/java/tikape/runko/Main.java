package tikape.runko;

import java.util.HashMap;
import spark.ModelAndView;
import spark.Spark;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.runko.database.Database;
import tikape.runko.database.OpiskelijaDao;
import tikape.runko.database.DrinkkiDao;
import tikape.runko.database.DrinkkiAinesDao;
import tikape.runko.database.AinesosaDao;
import tikape.runko.domain.Drinkki;
import tikape.runko.domain.DrinkkiAines;

public class Main {

    public static void main(String[] args) throws Exception {
        //Database database = new Database("jdbc:sqlite:opiskelijat.db");
        Database database1 = new Database("jdbc:sqlite:Drink.db");

        //database.init();
        database1.init();

        //OpiskelijaDao opiskelijaDao = new OpiskelijaDao(database);
        DrinkkiDao drinkkiDao = new DrinkkiDao(database1);
        AinesosaDao ainesosaDao = new AinesosaDao(database1);
        DrinkkiAinesDao drinkkiAinesDao = new DrinkkiAinesDao(database1);

        /*get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("viesti", "tervehdys");

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/opiskelijat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelijat", opiskelijaDao.findAll());

            return new ModelAndView(map, "opiskelijat");
        }, new ThymeleafTemplateEngine());

        get("/opiskelijat/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelija", opiskelijaDao.findOne(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "opiskelija");
        }, new ThymeleafTemplateEngine()); */
        Spark.get("/ainesosat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("ainesosat", ainesosaDao.findAll());

            return new ModelAndView(map, "ainesosat");
        }, new ThymeleafTemplateEngine());

        Spark.post("/ainesosat", (req, res) -> {
            String ainesosa = req.queryParams("ainesosa");
            ainesosaDao.lisaaAinesosa(ainesosa);

            res.redirect("/ainesosat");

            return "";
        });

        Spark.get("/drinkit", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("drinkit", drinkkiDao.findAll());
            map.put("ainesosat", ainesosaDao.findAll());

            return new ModelAndView(map, "drinkit");
        }, new ThymeleafTemplateEngine());

        Spark.post("/drinkit", (req, res) -> {
            String drinkki = req.queryParams("drinkki");
            String vahvuusStringina = req.queryParams("vahvuus");
            double vahvuus = Double.parseDouble(vahvuusStringina);
            String lasi = req.queryParams("lasi");

            drinkkiDao.nimeaDrinkki(drinkki, vahvuus, lasi);

            res.redirect("/drinkit");

            return "";
        });

        Spark.post("/drinkit/:id", (req, res) -> {
            Integer drinkkiId = Integer.parseInt(req.params(":id"));
            Integer ainesId = Integer.parseInt(req.queryParams("userId"));

            drinkkiAinesDao.tallennaID(drinkkiId, ainesId);

            String apuMaara = req.queryParams("maara");
            Integer maara = Integer.parseInt(apuMaara);
            String ohje = req.queryParams("ohje");
            
            drinkkiAinesDao.tallennaMuut(drinkkiId,ainesId, maara, ohje);
            res.redirect("/drinkit");
            return "";
        });
        
        Spark.get("/home", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("drinkit", drinkkiDao.findAll());

            return new ModelAndView(map, "drinkit");
        }, new ThymeleafTemplateEngine());

        /*Spark.get("/users/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            Integer userId = Integer.parseInt(req.params(":id"));
            map.put("user", users.findOne(userId));
            map.put("tasks", tasks.findNonCompletedForUser(userId));

            return new ModelAndView(map, "user");
        }, new ThymeleafTemplateEngine());*/
    }
}
