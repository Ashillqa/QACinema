function updateTotal(type){
    var id = "totalPrice";

    console.log(type);

    if(type === 'adult'){
    }
    else if(type === 'child'){

    }

    let adult = document.getElementById(type);

    let number = adult.options[adult.selectedIndex].value;

    console.log(adultChoice);

    document.getElementById(id).className = "section__title";

    let total;

    document.getElementById(id).textContent = number;
    
}




let adult = document.getElementById("adult");
let child = document.getElementById("child");
let student = document.getElementById("student");

    let adultChoice = adult.options[adult.selectedIndex].value;
    let childChoice = child.options[child.selectedIndex].value;
    let studentChoice = student.options[student.selectedIndex].value;

    console.log(adultChoice);
    console.log(childChoice);
console.log(studentChoice);

