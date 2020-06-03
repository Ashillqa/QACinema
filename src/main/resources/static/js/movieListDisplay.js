let featuredList = [];
let featuredIds = [];
let featuredRatings = [];


let comingList = [];
let comingIds = [];
let comingRatings = [];


axios.get(`/movie/getAll`).then(
    data => {
        for(let i of data.data){
            if (i.status!=="upcoming"){
                continue;
            }
            comingList.push(i.apiID);
            comingIds.push(i.id);
            if (i.rating===null){
                comingRatings.push("TBC");
            } else{
                comingRatings.push(i.rating)
            }
        }
        showComing(comingList, comingIds, comingRatings);

        for(let i of data.data){
            if (i.status!=="featured"){
                continue;
            }
            featuredList.push(i.apiID);
            featuredIds.push(i.id);
            if (i.rating===null){
                featuredRatings.push("TBC");
            } else{
                featuredRatings.push(i.rating)
            }
        }
        showFeatured(featuredList, featuredIds, featuredRatings);
    }
)




function showFeatured(list, ids, ratings) {
    let div = document.getElementById("primeDiv");
    for(let i=0;i<list.length;i++){
        let carousel = document.createElement("div");
        carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
        axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            res2 => {

                let genres = "";
                for (let k = 0; k< res2.data.genres.length; k++){
                    genres += `<a href="#">${res2.data.genres[k].name}</a>`
                }

                carousel.innerHTML =
                    '    <div class="card">\n' +
                    '        <div class="card__cover">\n' +
                    `            <img src="https://image.tmdb.org/t/p/original${res2.data.poster_path}" alt="" />\n` +
                                `<a id="play" href="details2.html?title=${res2.data.title}&id=${ids[i]}" class="card__play">` +
                    '                <i class="icon ion-ios-play"></i>\n' +
                    '            </a>\n' +
                    '        </div>\n' +
                    '        <div class="card__content">\n' +
                    '            <h3 class="card__title">\n' +
                                    `<a href="details2.html?title=${res2.data.title}&id=${ids[i]}">${res2.data.title}</a>\n` +
                    '            </h3>\n' +
                    '            <span class="card__category">\n' +
                                    genres +
                '                </span>\n' +
                    `            <span class="card__rate"><i class="icon ion-ios-star"></i>${res2.data.vote_average}</span>\n` +
                                '<ul class="card__list">'+
                                    `<li><a style="color: #ff5860;" id="ageRating" href="classifications.html">${ratings[i]}</a></li>`+
                                '</ul>'+
                    '        </div>\n' +
                    '    </div>\n';
            }
        )
        div.appendChild(carousel);
    }
}

function showComing(list, ids, ratings) {
    let div2 = document.getElementById("soonComeDiv");
    for(let j=0;j<list.length;j++){
        let carousel = document.createElement("div");
        carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
        axios.get(`https://api.themoviedb.org/3/movie/${list[j]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            res3 => {

                let genres = "";
                for (let k = 0; k< res3.data.genres.length; k++){
                    genres += `<a href="#">${res3.data.genres[k].name}</a>`
                }

                carousel.innerHTML =
                    '    <div class="card">\n' +
                    '        <div class="card__cover">\n' +
                    `            <img src="https://image.tmdb.org/t/p/original${res3.data.poster_path}" alt="" />\n` +
                                `<a id="play" href="details2.html?title=${res3.data.title}&id=${ids[j]}" class="card__play">` +
                    '                <i class="icon ion-ios-play"></i>\n' +
                    '            </a>\n' +
                    '        </div>\n' +
                    '        <div class="card__content">\n' +
                    '            <h3 class="card__title">\n' +
                                    `<a href="details2.html?title=${res3.data.title}&id=${ids[j]}">${res3.data.title}</a>\n` +
                    '            </h3>\n' +
                    '            <span class="card__category">\n' +
                                    genres +
                                '</span>' +
                                '<div class="card__wrap">'+
                                    '<ul class="card__list">'+
                                        `<li>${res3.data.release_date}</li>`+
                                        `<li><a style="color: #ff5860;" id="ageRating" href="classifications.html">${ratings[j]}</a></li>`+
                                    '</ul>'+
                                '</div>'+
                    '        </div>\n' +
                    '    </div>\n';
            }
        )
        div2.appendChild(carousel);
    }
}

