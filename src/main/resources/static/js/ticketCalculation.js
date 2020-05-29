const params = new URLSearchParams(window.location.search)

let adultNumber = 0;
    let childNumber = 0;
    let studentNumber = 0;

function updateTotal(type){

    var id = "totalPrice";

    console.log(type);
    

    if(type === 'adult'){
        let adult = document.getElementById(type);
        adultNumber = adult.options[adult.selectedIndex].value;
    }
    else if(type === 'child'){
        let child = document.getElementById(type);
        childNumber = child.options[child.selectedIndex].value;
    }
    else if(type === 'student'){
        let student = document.getElementById(type);
        studentNumber = student.options[student.selectedIndex].value;
    }

    let total = (adultNumber * 10) + (childNumber * 5) + (studentNumber * 7.5);


    console.log(total);

    document.getElementById(id).className = "section__title";

    

    document.getElementById(id).textContent = "£"+total;
    
}


function dateSelect(dates) {
    let templist = [];
    let bigParent = document.getElementById("accordion");
    let counter = 0;
    for (let i=0;i<dates.length;counter++){
        let day = document.createElement("div")
        day.className="accordion__card"
        let insert ="";
        templist.push(dates[0]);
        dates.splice(0,1);

        for(let j=0; j<dates.length;j++){
            if(dates[j].split(" ")[0]===templist[0].split(" ")[0]){
                templist.push(dates[j]);
                dates.splice(j,1)
            }
        }

        for(let j=0; j<templist.length;j++){
            insert+=`<tbody><tr><th>${templist[j].split(" ")[1]}</th></tr></tbody>`
        }

        day.innerHTML=
            `<div class="card-header" id="heading${counter}">
                    <button type="button" data-toggle="collapse" data-target="#collapse${counter}" aria-expanded="true" aria-controls="collapse${counter}">
                        <span>${templist[0].split(" ")[0]}</span>
                    </button>
                </div>
        
                   <div id="collapse${counter}" class="collapse show" aria-labelledby="heading${counter}" data-parent="#accordion">
                    <div class="card-body">
                           <table class="accordion__list">`+

                            insert+

                        `</table>
                    </div>
                </div>`;

        bigParent.appendChild(day);

        templist = [];
    }
}

axios.get(`http://localhost:8080/movie/get/${params.get('id')}`).then(
    write => {
        let showTimes = [];
        // writeContent(write.data.apiID);
        // videoSource(write.data.apiID);

        for (let i =0; i< write.data.showTimes.length; i++){
            showTimes.push(write.data.showTimes[i].time);
        }
        dateSelect(showTimes.sort());
    }
)
