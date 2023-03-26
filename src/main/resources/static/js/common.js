function includeHTML(callback) {
    let z, i, elmnt, file, xhr;

    z = document.getElementsByTagName('*');
    for (i = 0; i < z.length; i++) {
      elmnt = z[i];

      file = elmnt.getAttribute('include-html');

      if (file) {

        xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
          if (this.readyState == 4) {
            if (this.status == 200) {elmnt.innerHTML = this.responseText;}
            if (this.status == 404) {elmnt.innerHTML = 'Page not found.';}
            /*remove the attribute, and call this function once more:*/
            elmnt.removeAttribute('include-html');
            includeHTML(callback);
          }
        }      
        xhr.open('GET', file, true);
        xhr.send();

       return;
      }
    }
    setTimeout(function() {
      callback();
    }, 0)
  };

  function includeRouter(cb) {
    let content, file, xhttp, i;
    document.body.addEventListener('click', function (e) {
      file = e.target.getAttribute('route-link');
      if (file) {
        content = document.getElementById('content');
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4) {
            if (this.status == 200) {
              content.innerHTML = this.responseText; 
              var scripts = content.getElementsByTagName('script');
              for (var i = 0; i < scripts.length; i++) {
                eval(scripts[i].text); 
              }
              setTimeout(function() {
                cb(e);
              }, 0)
            }
            if (this.status == 404) {
              content.innerHTML = 'Page not found.';
            }
          }
        }      
        xhttp.open('GET', file, true);
        xhttp.send();
      }
    });
  }