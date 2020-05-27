axios.get("https://api.themoviedb.org/3/movie/338762?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK").then(
    res => {
        const firstMovieImage = this.document.getElementById("firstMovieImage");
        const firstMovieTitle = this.document.getElementById("firstMovieTitle");
        const genresSpan = this.document.getElementById("firstGenres");
        const movieInfoDiv = this.document.getElementById("firstMovieInfoDiv");

        const image = document.createElement("img");
        const aTag = document.createElement("a");
         image.src = "https://image.tmdb.org/t/p/original" + res.data.poster_path;

        aTag.textContent = res.data.title;
        console.log(res.data.title);

        for(let genres of res.data.genres){
            const aTag = document.createElement("a");
            aTag.textContent = genres.name;
            genresSpan.appendChild(aTag);
        }

        const span = document.createElement("span");
        span.className = "card__rate";
        span.textContent = res.data.vote_average;

        movieInfoDiv.appendChild(span);
        firstMovieImage.appendChild(image);
        firstMovieTitle.appendChild(aTag);

    }
)
