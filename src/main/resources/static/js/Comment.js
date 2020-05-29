
let form1 = document.getElementById('comForm').addEventListener("submit",postCom)
let entryCom = document.getElementById('enterPointCom')



function postCom(event){
	let name = document.getElementById('username').value;
	let stars = document.querySelector('input[type="radio"]:checked').value
	let msg = document.getElementById('text').value;
	event.preventDefault();
	fetch('http://localhost:8080/createComment', {
	    method: 'POST',
	    headers : {'Content-Type': 'application/json'},
	    body:JSON.stringify({userName:name,rating:stars,comment:msg})
	}).then((res) => res.json())
	    .then((data) =>  console.log(data)).then(relo).
	    catch((err)=>console.log(err))
	}


function seeComms(){
	fetch('http://localhost:8080/getAllComments')
    .then(function (res) {
        return res.json();
    })
    .then(function (data) {
        data.forEach((com) => {
            const {userName,rating,comment} = com;
            if(`${rating}`<2){
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<3){
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<4){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else if(`${rating}`<5){
            	
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name">${comment}</span>
            		</div>
            		</li>
            		`;
            	
            }else{
            	entryCom.innerHTML += `
            		<li class="comments__item">
            		<div class="comments__autor">
            		<span class="comments__name">${userName}</span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
            		<span class="comments__name fa fa-star" style="color:#FFD700"></span>
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



