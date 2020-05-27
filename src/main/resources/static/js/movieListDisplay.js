let a = [419704,338762,495764,454626,38700,475557];
let b = [400160,514847,556678,696007,635237,524047];

let div = document.getElementById("primeDiv");
let div2 = document.getElementById("soonComeDiv");


for(let i of a){
        console.log(i);

    let carousel = document.createElement("div");
    carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
    axios.get(`https://api.themoviedb.org/3/movie/${i}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
        res2 => {
                carousel.innerHTML =
                    '    <div class="card">\n' +
                    '        <div class="card__cover">\n' +
                    `            <img src="https://image.tmdb.org/t/p/original${res2.data.poster_path}" alt="" />\n` +
                    '            <a href="#" class="card__play">\n' +
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
for(let j of b){
        console.log(j);

    let carousel = document.createElement("div");
    carousel.className = "col-6 col-sm-4 col-lg-3 col-xl-2";
    axios.get(`https://api.themoviedb.org/3/movie/${j}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
        res3 => {
                carousel.innerHTML =
                    '    <div class="card">\n' +
                    '        <div class="card__cover">\n' +
                    `            <img src="https://image.tmdb.org/t/p/original${res3.data.poster_path}" alt="" />\n` +
                    '            <a href="#" class="card__play">\n' +
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


