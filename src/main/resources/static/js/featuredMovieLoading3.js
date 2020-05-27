axios.get("https://api.themoviedb.org/3/movie/385103?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK").then(
    res2 => {
        const secondMovieImage = this.document.getElementById("thirdMovieImage");
        const secondMovieTitle = this.document.getElementById("thirdMovieTitle");
        const genresSpan2 = this.document.getElementById("thirdGenres");
        const movieInfoDiv2 = this.document.getElementById("thirdMovieInfoDiv");

        const image2 = document.createElement("img");
        const aTag2 = document.createElement("a");
        image2.src = "https://image.tmdb.org/t/p/original" + res2.data.poster_path;

        console.log(res2.data);

        aTag2.textContent = res2.data.title;
        console.log(res2.data.title);

        for(let genres of res2.data.genres){
            const aTag = document.createElement("a");
            aTag.textContent = genres.name;
            genresSpan2.appendChild(aTag);
        }

        const span2 = document.createElement("span");
        span2.className = "card__rate";
        span2.textContent = res2.data.vote_average;

        movieInfoDiv2.appendChild(span2);
        secondMovieImage.appendChild(image2);
        secondMovieTitle.appendChild(aTag2);

    }
)