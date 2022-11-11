const myKeysValues = window.location.search;

const urlParams = new URLSearchParams(myKeysValues);

const theDept = urlParams.get("userReviewDepartment");
const theCourseNumber = urlParams.get("userReviewCourseNumber");

let theUserSection = document.querySelector("section");
let theTitRow = document.querySelector("#titleRow")

//54.146.226
axios.get(`http://localhost:8080/api/v1/getClassAndReviewByDeptAndNum?department=${theDept}&classNumber=${theCourseNumber}`).then((res) => {


    const id = document.createElement('h2');
    const className =  document.createElement("h3");
    const classDescription =  document.createElement("h3");
    const department =  document.createElement("h4");
    const classNumber =  document.createElement("h5");
    const cumGPA =  document.createElement("h5");
    const cumDif = document.createElement("h5");
    const likes = document.createElement("h5");
    const dislikes = document.createElement("h5");

    console.log(res.data)
    // id.innerText = "Num: " + res.data[0].id;
    className.innerHTML = `<a href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[0].department}&userReviewCourseNumber=${res.data[0].classNumber}\">` + res.data[0].className + "</a>";
    className.className = "theClassName"

    classDescription.innerHTML = "Description " + res.data[0].classDescription;
    department.innerHTML = "Department " + res.data[0].department;
    classNumber.innerHTML = "Class Number " +res.data[0].classNumber;
    cumGPA.innerHTML = "Cumulative GPA " + res.data[0].cumGPA;
    cumDif.innerHTML = "Cumulative Difficulty " + res.data[0].cumDif;
    likes.innerHTML = "Total Likes " + res.data[0].likes;
    dislikes.innerHTML = "Total Dislikes " + res.data[0].dislikes;

    const title = document.createElement('h1');
    title.className ="title";
    title.innerText = "Additional Class Info: " + res.data[0].department + "-" + res.data[0].classNumber + " ("  + res.data[0].className + ")";
    theTitRow.append(title);

    theUserSection.append(id);
    theUserSection.append(className);
    theUserSection.append(classDescription);
    theUserSection.append(department);
    theUserSection.append(classNumber);
    theUserSection.append(cumGPA);
    theUserSection.append(cumDif);
    theUserSection.append(likes);
    theUserSection.append(dislikes);

    for (let i = 0; i < res.data[1].length; i++) {


        const userReviewId = document.createElement('h1');
        const userReviewEmail =  document.createElement("h2");
        const userReviewGPA =  document.createElement("h4");
        const userReviewDifficulty =  document.createElement("h4");
        const userReviewLike =  document.createElement("h4");
        const userReviewDislike =  document.createElement("h4");
        const userReviewFeedback = document.createElement("h3");
        userReviewFeedback.className ="feedBack"



        // userReviewId.innerText = "Review #: " + res.data[1][i].userReviewID;
        userReviewId.innerHTML = "<br>";
        userReviewEmail.innerHTML = res.data[1][i].userReviewEmail;
        userReviewGPA.innerHTML = "GPA:  " + res.data[1][i].userReviewGPA;
        userReviewDifficulty.innerHTML = "Difficulty Rating:  " + res.data[1][i].userReviewDifficulty;
        // classNumber.innerHTML = "Class Number " +res.data[i].classNumber;
        // cumGPA.innerHTML = "Cumulitive GPA " + res.data[i].cumGPA;
        // cumDif.innerHTML = "Cumulitive Difference " + res.data[i].cumDif;
        userReviewLike.innerHTML = "Student Liked Class 👍";
        userReviewDislike.innerHTML = "Student Disliked Class 👎 ";
        userReviewFeedback.innerHTML = "Student Feedback: " + res.data[1][i].userReviewFeedback;

        theUserSection.append(userReviewId);
        theUserSection.append(userReviewEmail);
        theUserSection.append(userReviewGPA);
        theUserSection.append(userReviewDifficulty);
        if(res.data[1][i].userReviewLike){
            theUserSection.append(userReviewLike);
        }else{
            theUserSection.append(userReviewDislike);
        }
        theUserSection.append(userReviewFeedback);




    }

})