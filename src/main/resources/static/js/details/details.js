const params = new URLSearchParams(window.location.search)

function writeContent(apiID) {
    axios.get(`https://api.themoviedb.org/3/movie/${apiID}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-US`).then(
        fill => {
            console.log(fill.data);
            let parent=document.getElementById("movieInfo");

            let detailsChild=document.createElement("div");
            detailsChild.className="col-10";
            detailsChild.innerHTML=`<div class="card card--details card--series">
                  <div class="row">
                     <!-- card cover -->
                     <div class="col-12 col-sm-4 col-md-4 col-lg-3 col-xl-3">
                        <div class="card__cover">
                           <img src="https://image.tmdb.org/t/p/original${fill.data.poster_path}" alt="">
                        </div>
                     </div>
                     <!-- end card cover -->

                     <!-- card content -->
                     <div class="col-12 col-sm-8 col-md-8 col-lg-9 col-xl-9">
                        <div class="card__content">
                           <div class="card__wrap">
                              <span class="card__rate"><i class="icon ion-ios-star"></i>${fill.data.vote_average}</span>

                              <ul class="card__list">
                                 <li>HD</li>
                                 <li>16+</li>
                              </ul>
                           </div>

                           <ul class="card__meta">
                              <li><span>Genre:</span> 
                              <a href="#">${fill.data.genres[0].name}</a>
                              <a href="#">${fill.data.genres[1].name}</a></li>
                              <li><span>Release date:</span> ${fill.data.release_date}</li>
                              <li><span>Running time:</span> ${fill.data.runtime} min</li>
                              <li><span>Country:</span> <a href="#">USA</a> </li>
                           </ul>

                           <div class="b-description_readmore_wrapper js-description_readmore_wrapper" style="max-width: 682.5px;"><div class="card__description card__description--details b-description_readmore_ellipsis" style="min-height: 150px; max-height: 150px; overflow: hidden;">
                           ${fill.data.overview}
                            </div><div class="b-description_readmore_button"></div></div>
                        </div>
                     </div>
                     <!-- end card content -->
                  </div>
               </div>`;
            parent.prepend(detailsChild);

            let titleChild=document.createElement("div");
            titleChild.className="col-12";
            titleChild.innerHTML=`<h1 class="details__title">${fill.data.title}</h1>`
            parent.prepend(titleChild);
        }
    )
}

axios.get(`http://localhost:8080/movie/get/${params.get('id')}`).then(
    write => {
        console.log(write.data);
        writeContent(write.data.apiID);
        videoSource(write.data.apiID)
    }
)

function videoSource(apiID) {
    axios.get(`https://api.themoviedb.org/3/movie/${apiID}/videos?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-US
`).then(
        write => {
            console.log(write.data);
            document.getElementById("video").src=`https://www.youtube.com/embed/${write.data.results[0].key}`;
        }
    )
}
