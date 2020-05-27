axios.get("https://api.themoviedb.org/3/movie/495764?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK").then(
    res1 => {
        const secondMovieImage = this.document.getElementById("secondMovieImage");
        const secondMovieTitle = this.document.getElementById("secondMovieTitle");
        const genresSpan2 = this.document.getElementById("secondGenres");
        const movieInfoDiv2 = this.document.getElementById("secondMovieInfoDiv");

        const image2 = document.createElement("img");
        const aTag2 = document.createElement("a");
        image2.src = "https://image.tmdb.org/t/p/original" + res1.data.poster_path;

        console.log(res1.data);

        aTag2.textContent = res1.data.title;
        console.log(res1.data.title);

        for(let genres of res1.data.genres){
            const aTag = document.createElement("a");
            aTag.textContent = genres.name;
            genresSpan2.appendChild(aTag);
        }

        const span2 = document.createElement("span");
        span2.className = "card__rate";
        span2.textContent = res1.data.vote_average;

        movieInfoDiv2.appendChild(span2);
        secondMovieImage.appendChild(image2);
        secondMovieTitle.appendChild(aTag2);

    }
)