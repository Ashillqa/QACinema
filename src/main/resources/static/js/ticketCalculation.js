
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


