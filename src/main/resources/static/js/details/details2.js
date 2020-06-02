let dates = ["28/05/2020 14:30","28/05/2020 22:30","29/05/2020 22:30","28/05/2020 16:30","28/05/2020 14:30","28/05/2020 16:30","29/05/2020 18:30","27/05/2020 14:30"];
dateSelect(dates);

function dateSelect(dates) {
    let bigParent = document.getElementById("accordion");
    let counter = 0;

    for (let i=0;i<dates.length;){
        let day = document.createElement("div")
        day.className="accordion__card"
        let insert ="";
        let tempList = [];
        tempList.push(dates[0]);
        dates.splice(0,1);

        for(let j=0; j<dates.length;j++){
            if(dates[j].split(" ")[0]===tempList[0].split(" ")[0]){
                tempList.push(dates[j]);
                tempList.sort();
                dates.splice(j,j+1)
                j--;
            }
        }

        for(let j=0; j<tempList.length;j++){
            insert+=
            `<tbody>
                <tr>
                    <th>${tempList[j].split(" ")[1]}<a class="sign__btn1" href="bookings2.html?time=${tempList[j]}">Book now</a></th>
                </tr>
            </tbody>`
        }

        day.innerHTML=
            `<div class="card-header" id="heading${counter}">
                    <button type="button" data-toggle="collapse" data-target="#collapse${counter}" aria-expanded="true" aria-controls="collapse${counter}">
                        <span>${tempList[0].split(" ")[0]}</span>
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
    }
}


