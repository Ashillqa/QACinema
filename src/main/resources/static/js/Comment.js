
let form1 = document.getElementById('comForm').addEventListener("submit",postCom)
let entryCom = document.getElementById('enterPointCom')



function postCom(event){
	let mTitle = document.getElementById('movieTitle').value;
	let name = document.getElementById('username').value;
	let stars = document.querySelector('input[type="radio"]:checked').value
	let msg = document.getElementById('text').value;
	event.preventDefault();
	fetch(`http://${window.location.href.toString().split("/")[2]}/createComment`, {
	    method: 'POST',
	    headers : {'Content-Type': 'application/json'},
	    body:JSON.stringify({movieTitle:mTitle,userName:name,rating:stars,comment:msg})
	}).then((res) => res.json())
	    .then((data) =>  console.log(data)).then(relo).
	    catch((err)=>console.log(err))
	}


function seeComms(){
	fetch(`http://${window.location.href.toString().split("/")[2]}/getAllComments`)
    .then(function (res) {
        return res.json();
    })
    .then(function (data) {
        data.forEach((com) => {
            const {movieTitle,userName,rating,comment} = com;
            if(`${rating}`<2){
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<3){
            	entryCom.innerHTML += `
            		<li class="comments__item">            		
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<4){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">           		
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<5){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">          
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else{
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name">Viewed: <span style="color:#E00F67">${movieTitle}</span></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name fa fa-star" style="color:#E00F67"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            }
	
	
        });
    })
}

function relo(){
	location.reload();
}



