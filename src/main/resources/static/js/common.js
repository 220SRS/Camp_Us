includeHTML( function () {
  includeRouter( function () {
      // do something in the future
  });
});
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




  // ------------------------ point-star ------------------------
  window.addEventListener("DOMContentLoaded",() => {
    const starRating = new StarRating("form");
  });
  
  class StarRating {
    constructor(qs) {
      this.ratings = [
        {id: 1, name: "Terrible"},
        {id: 2, name: "Bad"},
        {id: 3, name: "OK"},
        {id: 4, name: "Good"},
        {id: 5, name: "Excellent"}
      ];
      this.rating = null;
      this.el = document.querySelector(qs);
  
      this.init();
    }
    init() {
      this.el?.addEventListener("change",this.updateRating.bind(this));
  
      // stop Firefox from preserving form data between refreshes
      try {
        this.el?.reset();
      } catch (err) {
        console.error("Element isn’t a form.");
      }
    }
    updateRating(e) {
      // clear animation delays
      Array.from(this.el.querySelectorAll(`[for*="rating"]`)).forEach(el => {
        el.className = "rating__label";
      });
  
      const ratingObject = this.ratings.find(r => r.id === +e.target.value);
      const prevRatingID = this.rating?.id || 0;
  
      let delay = 0;
      this.rating = ratingObject;
      this.ratings.forEach(rating => {
        const { id } = rating;
  
        // add the delays
        const ratingLabel = this.el.querySelector(`[for="rating-${id}"]`);
  
        if (id > prevRatingID + 1 && id <= this.rating.id) {
          ++delay;
          ratingLabel.classList.add(`rating__label--delay${delay}`);
        }
  
        // hide ratings to not read, show the one to read
        const ratingTextEl = this.el.querySelector(`[data-rating="${id}"]`);
  
        if (this.rating.id !== id)
          ratingTextEl.setAttribute("hidden",true);
        else
          ratingTextEl.removeAttribute("hidden");
      });
    }
  }
  // ------------------------------------------------s