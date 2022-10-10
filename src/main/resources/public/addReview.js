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
form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)
    const payload = new URLSearchParams(prepayload);
    let email = payload.get("email");
    let course = payload.get("course");
    let gpa = payload.get("gpa");
    let difficultyRating = payload.get("difficultyRating");
    let like = 0;
    let dislike = 0;
    if(likes){
        like += 1;
    }else if(dislikes){
        dislike += 1;
    }
    let classDescription = payload.get("classDescription");

alert(email +" "+course +" "+gpa +" "+difficultyRating +" "+like +" "+dislike +" "+classDescription)
//call the API
    // let data = {
    //     classDescription:classDescription,
    //     className:className,
    //     department:department,
    //     classNumber: classNumber
    // }

    // fetch('http://localhost:8080/api/v1/addClass', {
    //     method: "POST",
    //     headers: {
    //         "Content-Type":'application/json'
    //     },
    //     body: JSON.stringify(data),

    // }).then(r=>(alert("Added New Class: " + className)))

})