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
    let course = payload.get("course").split(" ");
    console.log(course)
    let department = course[0];
    let number = course[1];
    let gpa = payload.get("gpa");
    let difficultyRating = payload.get("difficultyRating");
    likeDislikeNone = 0;
    // alert("hello");
    if(likes){
        likeDislikeNone = 2;
    }else if(dislikes){
        likeDislikeNone = 1;
    }
    let classDescription = payload.get("classDescription");
    alert("Thanks For Leaving A Rating!");
    // alert(email +" "+course +" "+department +" "+number +" "+gpa +" "+difficultyRating +" "+likeDislikeNone +" "+classDescription);

    //adding gpa functionality so someone can't add a review without putting a gpa first
    const parsed = parseInt(gpa);
    if (gpa.length == 0 || isNaN(parsed)){
        alert("you can't add a review without adding your gpa!");
    }
    else{
    //call the API
        let data = {
            userReviewEmail:email,
            userReviewDepartment:course[0],
            userReviewCourseNumber: course[1],
            userReviewGPA:gpa,
            userReviewDifficulty:difficultyRating,
            userReviewLike:likes,
            userReviewDislike: dislikes,
            userReviewFeedback:classDescription
        }

         fetch('http://localhost:8080/api/v1/addUserReview', { //idk where api is
             method: "POST",
             headers: {
                 "Content-Type":'application/json'
             },
             body: JSON.stringify(data),
         }).then(r=>(alert("Added New Class: " + className)))
    }

     fetch('http://localhost:8080/api/v1/addUserReview', { //idk where api is
         method: "POST",
         headers: {
             "Content-Type":'application/json'
         },
         body: JSON.stringify(data),

     }).then(r=>(alert("Added New Review: " + className)))

})