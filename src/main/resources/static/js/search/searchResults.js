let list = [];
let ids = [];
let ratings = [];

let featuredList = [];
let featuredIds = [];
let featuredRatings = [];

const params = new URLSearchParams(window.location.search)

axios.get(`http://${window.location.href.toString().split("/")[2]}/movie/getAll`).then(
    data => {
        for(let i of data.data){

            list.push(i.apiID);
            ids.push(i.id);
            if (i.rating===null){
                ratings.push("TBC");
            } else{
                ratings.push(i.rating)
            }

            // if (i.status!=="featured"){
            //     continue;
            // }
            // featuredList.push(i.apiID);
            // featuredIds.push(i.id);
            // if (i.rating===null){
            //     featuredRatings.push("TBC");
            // } else{
            //     featuredRatings.push(i.rating)
            // }
        }
        showOnPage(list, ids, ratings);
        // showFeatured(featuredList, featuredIds, featuredRatings);
    }
)

function showOnPage(list, ids, ratings){
    let tile = document.getElementById('movieDisplay')
    for(let i=0;i<list.length;i++){
        let movieTile = document.createElement('div');
        movieTile.className="col-6 col-sm-12 col-lg-6";
        axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            append => {
                if (params.get("term")!==null && !append.data.title.toLowerCase().includes(params.get("term").toLowerCase())){
                    return;
                }

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
    let minRating = document.getElementById("filter__imbd-start").textContent;
    let maxRating = document.getElementById("filter__imbd-end").textContent;
    let minRelease = document.getElementById("filter__years-start").textContent;
    let maxRelease = document.getElementById("filter__years-end").textContent;
    let filterValue = document.getElementById('searchBox2').value.toLowerCase();


    let movies = document.getElementById('movieDisplay');
    let ld = movies.getElementsByClassName('col-6 col-sm-12 col-lg-6');
    let li = movies.getElementsByClassName('card__title');
    let genre = movies.getElementsByClassName("card__category");
    let rating = movies.getElementsByClassName("card__rate");
    let release = movies.getElementsByClassName("card__list");


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
        console.log()
        if(
            (li[i].getElementsByTagName('a')[0].innerHTML.toLowerCase().indexOf(filterValue)>-1 ||
            ld[i].getElementsByTagName('p')[0].innerHTML.toLowerCase().indexOf(filterValue)>-1) &&
            genreMatch(genre[i].getElementsByTagName('a'),genreSelect) &&
            parseFloat(rating[i].textContent)>=parseFloat(minRating) &&
            parseFloat(rating[i].textContent)<=parseFloat(maxRating) &&
            parseFloat(release[i].getElementsByTagName('li')[0].innerHTML.toString().split("-")[0])>=parseFloat(minRelease) &&
            parseFloat(release[i].getElementsByTagName('li')[0].innerHTML.toString().split("-")[0])<=parseFloat(maxRelease)){
            li[i].style.display='';
            ld[i].style.display=''
        }else{
            li[i].style.display = 'none';
            ld[i].style.display= 'none';
        }
    }

}

// function showFeatured(list, ids, ratings) {
//     let div = document.getElementById("primeDiv");
//     for(let i=0;i<list.length;i++){
//         let carousel = document.createElement("div");
//         carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
//         axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
//             res2 => {
//
//                 let genres = "";
//                 for (let k = 0; k< res2.data.genres.length; k++){
//                     genres += `<a href="#">${res2.data.genres[k].name}</a>`
//                 }
//
//                 carousel.innerHTML =
//                     '    <div class="card">\n' +
//                     '        <div class="card__cover">\n' +
//                     `            <img src="https://image.tmdb.org/t/p/original${res2.data.poster_path}" alt="" />\n` +
//                     `<a id="play" href="details2.html?title=${res2.data.title}&id=${ids[i]}" class="card__play">` +
//                     '                <i class="icon ion-ios-play"></i>\n' +
//                     '            </a>\n' +
//                     '        </div>\n' +
//                     '        <div class="card__content">\n' +
//                     '            <h3 class="card__title">\n' +
//                     `<a href="details2.html?title=${res2.data.title}&id=${ids[i]}">${res2.data.title}</a>\n` +
//                     '            </h3>\n' +
//                     '            <span class="card__category">\n' +
//                     genres +
//                     '                </span>\n' +
//                     `            <span class="card__rate"><i class="icon ion-ios-star"></i>${res2.data.vote_average}</span>\n` +
//                     '<ul class="card__list">'+
//                     `<li><a style="color: #ff5860;" id="ageRating" href="classifications.html">${ratings[i]}</a></li>`+
//                     '</ul>'+
//                     '        </div>\n' +
//                     '    </div>\n';
//             }
//         )
//         div.appendChild(carousel);
//     }
// }

document.getElementById("filter__years").addEventListener("mouseup",applyFilter);
document.getElementById("filter__imbd").addEventListener("mouseup",applyFilter);
document.getElementById("filter__genre").addEventListener("click",applyFilter);
document.getElementById("resetButton").addEventListener("click",function(){window.location = window.location.href.split("?")[0];})
document.getElementById('searchBox2').addEventListener('keyup',applyFilter);



