let featuredList = [];
let featuredIds = [];
let comingList = [];
let comingIds = [];


axios.get(`http://localhost:8080/movie/getAll`).then(
    data => {
        for(let i of data.data){
            if (i.status!=="upcoming"){
                continue;
            }
            comingList.push(i.apiID);
            comingIds.push(i.id);
        }
        showComing(comingList, comingIds);

        for(let i of data.data){
            if (i.status!=="featured"){
                continue;
            }
            featuredList.push(i.apiID);
            featuredIds.push(i.id);
        }
        showFeatured(featuredList, featuredIds);
    }
)




function showFeatured(list, ids) {
    let div = document.getElementById("primeDiv");
    for(let i=0;i<list.length;i++){
        let carousel = document.createElement("div");
        carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
        axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            res2 => {
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
                    `<a href="#">${res2.data.title}</a>\n` +
                    '            </h3>\n' +
                    '            <span class="card__category">\n' +
                    `<a href="#">${res2.data.genres[0].name}</a>\n` +
                    `<a href="#">${res2.data.genres[1].name}</a>\n` +
                    '                </span>\n' +
                    '            <span class="card__rate"\n' +
                    `            ><i class="icon ion-ios-star"></i>${res2.data.vote_average}</span\n` +
                    '            >\n' +
                    '        </div>\n' +
                    '    </div>\n';
            }
        )
        div.appendChild(carousel);
    }
}

function showComing(list, ids) {
    let div2 = document.getElementById("soonComeDiv");
    for(let j=0;j<list.length;j++){
        let carousel = document.createElement("div");
        carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
        axios.get(`https://api.themoviedb.org/3/movie/${list[j]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            res3 => {
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
                    `<a href="#">${res3.data.title}</a>\n` +
                    '            </h3>\n' +
                    '            <span class="card__category">\n' +
                    `<a href="#">${res3.data.genres[0].name}</a>\n` +
                    `<a href="#">${res3.data.genres[1].name}</a>\n` +
                    '                </span>\n' +
                    '            <span class="card__rate"\n' +
                    `            ><i class="icon ion-ios-star"></i>${res3.data.vote_average}</span\n` +
                    '            >\n' +
                    '        </div>\n' +
                    '    </div>\n';
            }
        )
        div2.appendChild(carousel);
    }
}

