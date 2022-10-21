var likes = false;
var dislikes = false;

function updateLikes(){
    likes = true;
    dislikes = false;
}
function updateDislikes(){
    dislikes = true;
    likes = false;
}

const form = document.getElementById('formElem');
//const course = form.getElementById('course').split(" ");
form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)
    const payload = new URLSearchParams(prepayload);

    let email = payload.get("email");
    let course = payload.get("course").split(" ");

    let department = course[0];
    let number = course[1];
    let gpa = payload.get("gpa");
    let difficultyRating = payload.get("difficultyRating");
    likeDislikeNone = 0;
    alert("hello");
    if(likes){
        likeDislikeNone = 2;
    }else if(dislikes){
        likeDislikeNone = 1;
    }
    let classDescription = payload.get("classDescription");
    alert(likeDislikeNone);
    alert(email +" "+course +" "+department +" "+number +" "+gpa +" "+difficultyRating +" "+likeDislikeNone +" "+classDescription);


//call the API
     let data = {

     }

     fetch('http://localhost:8080/api/v1/addClass', { //idk where api is
         method: "POST",
         headers: {
             "Content-Type":'application/json'
         },
         body: JSON.stringify(data),

     }).then(r=>(alert("Added New Class: " + className)))

})