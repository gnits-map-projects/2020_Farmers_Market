package controllers;

import models.Person;
import models.PersonRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class PersonController extends Controller {

    private final FormFactory formFactory;
    private final PersonRepository personRepository;
    private final HttpExecutionContext ec;

    @Inject
    public PersonController(FormFactory formFactory, PersonRepository personRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.personRepository = personRepository;
        this.ec = ec;
    }

    public Result index() {
        return ok(views.html.index.render());
    }

    public CompletionStage<Result> addPerson() {
        Person person = formFactory.form(Person.class).bindFromRequest().get();
        return personRepository.add(person).thenApplyAsync(p -> {
            return redirect(routes.PersonController.index());
        }, ec.current());
    }

    public CompletionStage<Result> addPersonJson() {
        JsonNode js=request().body().asJson();
        //String name=js.get("name").asText();
        //Person person=new Person();
        //person.setName(name);
        //Person person = formFactory.form(Person.class).bindFromRequest().get();
        Person person=fromJson(js,Person.class);
        return personRepository.add(person).thenApplyAsync(p -> {
           //return redirect(routes.PersonController.index());
           return ok("successful");
       }, ec.current());
    }

    public CompletionStage<Result> getPersons() {
        return personRepository.list().thenApplyAsync(personStream -> {
            return ok(toJson(personStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> delPersons() {
        JsonNode js=request().body().asJson();
        String name=js.get("name").asText();
        Person person=new Person();
        person.setName(name);
        //Person person = formFactory.form(Person.class).bindFromRequest().get();
        return personRepository.delete(name).thenApplyAsync(p -> {
           // return redirect(routes.PersonController.index());
            return ok("deleted");
        }, ec.current());
    }

}
