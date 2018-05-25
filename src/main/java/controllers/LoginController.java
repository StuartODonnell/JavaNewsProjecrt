package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.Spark.post;

public class LoginController {

        public LoginController() {
            this.setupEndPoints();
        }

        private void setupEndPoints(){
            post("/login", (req, res) -> {
                String inputtedUsername = req.queryParams("username");
                req.session().attribute("username", inputtedUsername);
                res.redirect("/");
                return null;
            }, new VelocityTemplateEngine());

            get("/login", (req, res) -> {
                HashMap<String, Object> model = new HashMap<>();
                return new ModelAndView( model, "templates/login.vtl");
            }, new VelocityTemplateEngine());

            get("/logout", (req, res) -> {
                req.session().removeAttribute("username");
                res.redirect("/");
                return null;
            }, new VelocityTemplateEngine());
        }

        public static String getLoggedInUsername(Request req, Response res){
            String username = req.session().attribute("username");
            if (username == null || username.isEmpty()){
                res.redirect("/login");
            }
            return username;
        }
}
