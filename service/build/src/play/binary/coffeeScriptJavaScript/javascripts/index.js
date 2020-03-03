(function() {
  $(function() {
    return $.get("/persons", function(persons) {
      return $.each(persons, function(index, person) {
        return $("#persons").append($("<li>").text(person.name));
      });
    });
  });

}).call(this);
