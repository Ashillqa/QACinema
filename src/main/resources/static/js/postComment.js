/**
 * 
 */

let form1 = document.getElementById('comForm').addEventListener("submit",postCom)
let entryTag = document.getElementById('others')



function postCom(event){
	let name = document.getElementById('username').value;
	let stars = document.querySelector('input[type="radio"]:checked').value
	let msg = document.getElementById('comment').value;
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
            	entryTag.innerHTML += `
            		<div class="col-12 col-md-6 col-lg-4">
            			<div class="price">
            			<div class="price__item price__item--first">${userName}
            			</div>
            			<div class="fa fa-star" style="color:#FFD700">
            			</div>
            			<div class="price__item"><span>${comment}</span></div>	
            			</div>
            		</div>`;
            	
            }else if(`${rating}`<3){
            	entryTag.innerHTML += `
            		<div class="col-12 col-md-6 col-lg-4">
            			<div class="price">
            			<div class="price__item price__item--first">${userName}
            			</div>
            			<div class="fa fa-star" style="color:#FFD700">
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			</div>
            			<div class="price__item"><span>${comment}</span></div>	
            			</div>
            		</div>`;
            	
            }else if(`${rating}`<4){
            	
            	entryTag.innerHTML += `
            		<div class="col-12 col-md-6 col-lg-4">
            			<div class="price">
            			<div class="price__item price__item--first">${userName}
            			</div>
            			<div class="fa fa-star" style="color:#FFD700">
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			</div>
            			<div class="price__item"><span>${comment}</span></div>	
            			</div>
            		</div>`;
            	
            }else if(`${rating}`<5){
            	
            	entryTag.innerHTML += `
            		<div class="col-12 col-md-6 col-lg-4">
            			<div class="price">
            			<div class="price__item price__item--first">${userName}
            			</div>
            			<div class="fa fa-star" style="color:#FFD700">
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			</div>
            			<div class="price__item"><span>${comment}</span></div>	
            			</div>
            		</div>`;
            	
            }else{
            	entryTag.innerHTML += `
            		<div class="col-12 col-md-6 col-lg-4">
            			<div class="price">
            			<div class="price__item price__item--first">${userName}
            			</div>
            			<div class="fa fa-star" style="color:#FFD700">
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			<span class="fa fa-star" style="color:#FFD700"></span>
            			</div>
            			
            			<div class="price__item"><span>${comment}</span></div>	
            			</div>
            		</div>`;
            }
	
        });
    })
}

function relo(){
	location.reload();
}



