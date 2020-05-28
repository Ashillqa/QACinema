const params = new URLSearchParams(window.location.search)

axios.get(`http://localhost:8080/movie/get/${params.get('id')}`).then(
    write => {
        console.log(write.data);
    }
)