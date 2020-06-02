let list = [];
let ids = [];

axios.get(`http://${window.location.href.toString().split("/")[2]}/movie/getAll`).then(
        data => {
            for(let i of data.data){
                if (i.status==="upcoming"){
                    continue;
                }
                list.push(i.apiID);
                ids.push(i.id);
            }
            someFunc(list);
        }
    )
    
    
    function someFunc(list){
	
	let movieDivision = document.getElementById('movieTitle');
	for(let i=0;i<list.length;i++){
        let movieOpt = document.createElement('option');
        axios.get(`https://api.themoviedb.org/3/movie/${list[i]}?api_key=e8787f4d45be4c1bcdb939f0d6113db5&language=en-UK`).then(
            append => {
                movieOpt.innerHTML = 
                 `${append.data.title}`+
                  
                 '</option>';
                            
                movieDivision.appendChild(movieOpt);
            }
        )
    }
}

	
	
	
	
