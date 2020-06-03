let list = [];
let ids = [];
let ratings = [];

axios.get(`/movie/getAll`).then(
    data => {
        for(let i of data.data){
            if (i.status!=="upcoming"){
                continue;
            }
            list.push(i.apiID);
            ids.push(i.id);
            if (i.rating===null){
                ratings.push("TBC");
            } else{
                ratings.push(i.rating)
            }
        }
        showOnPage(list, ids, ratings);
    }
)

function showOnPage(list, ids, ratings){
    let tile = document.getElementById('movieDisplay')
    for(let i=0;i<list.length;i++){
        let movieTile = document.createElement('div');
        movieTile.className="col-6 col-sm-12 col-lg-6";
        axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            append => {

                didntFind("hide")

                let genres = "";
                for (let k = 0; k< append.data.genres.length; k++){
                    genres += `<a href="#">${append.data.genres[k].name}</a>`
                }

                movieTile.innerHTML =
                    '<div class="card card--list">'+
                    '<div class="row">'+
                    '<div class="col-12 col-sm-4">'+
                    '<div class="card__cover">'+
                    `<img src="https://image.tmdb.org/t/p/original${append.data.poster_path}" alt="">`+
                    `<a id="play" href="details2.html?title=${append.data.title}&id=${ids[i]}" class="card__play">`+
                    `<i class="icon ion-ios-play" id="playbutton${ids[i]}"></i>`+
                    '</a>'+
                    '</div>'+
                    '</div>'+
                    '<div class="col-12 col-sm-8">'+
                    '<div class="card__content">'+
                    `<h3 class="card__title"><a id="title" href="details2.html?title=${append.data.title}&id=${ids[i]}">${append.data.title}</a></h3>`+
                    '<span class="card__category">'+
                    genres +
                    '</span>'+
                    '<div class="card__wrap">'+
                    `<span class="card__rate"><i class="icon ion-ios-star"></i>${append.data.vote_average}</span>`+
                    '<ul class="card__list">'+
                    `<li>${append.data.release_date}</li>`+
                    `<li><a style="color: #ff5860;" id="ageRating" href="classifications.html">${ratings[i]}</a></li>`+
                    '</ul>'+
                    '</div>'+
                    '<div class="card__description">' +
                    `<p>${append.data.overview}</p>`+
                    '</div>'+
                    '</div>'+
                    '</div>'+
                    '</div>';
                tile.appendChild(movieTile);
            }
        )
    }
}


function applyFilter (){
    let genreSelect = document.getElementById("selectGenre").value.toLowerCase();
    let filterValue = document.getElementById('searchBox2').value.toLowerCase();


    let movies = document.getElementById('movieDisplay');
    let ld = movies.getElementsByClassName('col-6 col-sm-12 col-lg-6');
    let li = movies.getElementsByClassName('card__title');
    let genre = movies.getElementsByClassName("card__category");


    function genreMatch(Element){
        if (genreSelect==="select genre"){
            return true;
        }
        for (let i=0;i<Element.length;i++){
            if(Element[i].innerHTML.toLowerCase().indexOf(genreSelect)>-1){
                return true;
            }
        }
        return false;
    }


    for(let i=0;i<li.length;i++){
        if(
            (li[i].getElementsByTagName('a')[0].innerHTML.toLowerCase().indexOf(filterValue)>-1 ||
                ld[i].getElementsByTagName('p')[0].innerHTML.toLowerCase().indexOf(filterValue)>-1) &&
            genreMatch(genre[i].getElementsByTagName('a'),genreSelect)){
            li[i].style.display='';
            ld[i].style.display=''
        }else{
            li[i].style.display = 'none';
            ld[i].style.display= 'none';
        }
    }
    checkEmpty();
}

function didntFind(state) {
    if (state==="show"){
        document.getElementById("nothingHere").style.display='';
    } else {
        document.getElementById("nothingHere").style.display='none';
    }
}

function checkEmpty(){
    let displayed = "";
    let movies2 = document.getElementById('movieDisplay');
    displayed = movies2.getElementsByClassName("col-6 col-sm-12 col-lg-6");

    for (let i = 0; i<displayed.length;i++){
        if (displayed[i].style.display!=="none"){
            didntFind("hide");
            return true;
        }
    }

    didntFind("show");
    return false;
}



document.getElementById("filter__genre").addEventListener("click",applyFilter);
document.getElementById("resetButton").addEventListener("click",function(){window.location = window.location.href.split("?")[0];})
document.getElementById('searchBox2').addEventListener('keyup',applyFilter);








