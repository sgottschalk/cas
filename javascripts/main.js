 
$(function(){
  	  var currentVersion = "current";
  	  var href = location.href;
      var index = href.indexOf("/_site/");

      if (index == -1) {
      	var uri = new URI(document.location);
  	  	currentVersion = uri.segment(1);

  	  	var prefix = "/cas/" + currentVersion;
  	  	$("#sidebartoc").load(prefix + "/sidebar.html");

  	  	$('a').each(function() {
          var href = this.href;
          if (href.indexOf("$version") != -1) {
            href = href.replace("$version", prefix);
            $(this).attr('href', href);
          }
      	});

  	  } else {
        href = href.substring(index + 7);
        index = href.indexOf("/");
        
        currentVersion = href.substring(0, index);
      }

      document.title = document.title + " - Version " + currentVersion;
});
