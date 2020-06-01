let searchBox = document.getElementById("searchBox");
let searchButton = document.getElementById("searchButton");

function search(){
    window.location.href = `search.html?term=${searchBox.value}`;
}

searchButton.addEventListener("click",search);