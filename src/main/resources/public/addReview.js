var likes = false;
var dislikes = false;

function updateLikes() {
    likes = true;
    dislikes = false;

}
function updateDislikes() {
    dislikes = true;
    likes = false;
}

const form = document.getElementById('formElem');
function isFloat(value) {
    if (
      typeof value === 'number' &&
      !Number.isNaN(value) &&
      !Number.isInteger(value)
    ) {
      return true;
    }
  
    return false;
  }
function containsNumbers(str) {
    return /\d/.test(str);
  }
  function containsOnlyNumbers(str) {
    return /^\d+$/.test(str);
  }
form.addEventListener('submit', function (e) {
    e.preventDefault();

    const prepayload = new FormData(form)
    const payload = new URLSearchParams(prepayload);

    let email = payload.get("email");
    let course = payload.get("course").split(" ");
    console.log(course)
    let dpt = course[0];
    let cnm = course[1];
    let gpa = payload.get("gpa");
    let difficultyRating = payload.get("difficultyRating");
    likeDislikeNone = 0;
    
    if (likes) {
        likeDislikeNone = 2;
    } else if (dislikes) {
        likeDislikeNone = 1;
    }
    let classDescription = payload.get("classDescription");
    var ampersandFound = false;
    var dotFound = false;

    
    var i = 0;
    for(i; i<email.length; i++){
        if(email[i] == '@' ){
            ampersandFound = true;
        }
        else if(email[i] == '.'){
            dotFound = true;
        }
    }
    if ((dpt.length == 0) || (cnm.length == 0)|| (gpa.length == 0)|| (email.length == 0)|| (difficultyRating.length == 0)|| (classDescription.length == 0)) {
        alert("Please fill in all fields.");
    }
    else if(!(ampersandFound && dotFound)){
        alert('Invalid Email!');
    }else if (!((dpt.length >= 1) && (dpt.length <= 4))) {
        alert("Invalid Department!");
    } else if (containsNumbers(dpt)) {
        alert("Invalid Department!");
    } else if (cnm.length > 5) {
        alert("Invalid Course Number!");
    }else if (!containsOnlyNumbers(cnm)) {
        alert("Invalid Course Number!");
    } 
    // else if(isFloat(gpa)){
    //     alert("Invalid GPA!");
    // } 
    else if(!((difficultyRating >= 1) && (difficultyRating <= 10))){
        alert("Invalid Difficulty Rating!");
    }
    else {
        alert("Thanks For Leaving A Rating!");
        //call the API
        let data = {
            userReviewEmail: email,
            userReviewDepartment: course[0],
            userReviewCourseNumber: course[1],
            userReviewGPA: gpa,
            userReviewDifficulty: difficultyRating,
            userReviewLike: likes,
            userReviewDislike: dislikes,
            userReviewFeedback: classDescription
        }

        fetch('http://localhost:8080/api/v1/addUserReview', { //idk where api is
            method: "POST",
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(data),

        }).then(r => (alert("Added New Review: " + className)))
    }


})