const searchBar = document.getElementById('searchBox2')
searchBar.addEventListener('keyup',filterNames)




function filterNames(){
	let filterValue = document.getElementById('searchBox2').value.toLowerCase();
	let movies = document.getElementById('movieDisplay')
	let li = movies.getElementsByClassName('card__title')
	let ld = movies.getElementsByClassName('col-6 col-sm-12 col-lg-6')
	console.log(li.length)
	console.log(ld.length)
	
	for(let i=0;i<li.length;i++){
		let test = li[i].getElementsByTagName('a')[0];
		if(test.innerHTML.toLowerCase().indexOf(filterValue)>-1){
			li[i].style.display='';
			ld[i].style.display=''
		}else{
			li[i].style.display = 'none';
			ld[i].style.display= 'none';
		}
	}
}




















        
    




























//onst resultMovie = movies.getElementsByTagName('h');
	//Array.from(resultMovie).forEach(function(resultMovies){
		//const title = resultMovies.firstElementChild.textContent;
		//if(title.toLowerCase().indexOf(term)!= -1){
		//	resultMovies.style.display = 'block';
		//}else{
			//resultMovies.style.display = 'none';
		//}
	//})