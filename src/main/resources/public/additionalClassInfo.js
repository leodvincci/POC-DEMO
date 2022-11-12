const myKeysValues = window.location.search;

const urlParams = new URLSearchParams(myKeysValues);

const theDept = urlParams.get("userReviewDepartment");
const theCourseNumber = urlParams.get("userReviewCourseNumber");

let theUserSection = document.querySelector("section");
let theTitRow = document.querySelector("#titleRow")

//54.146.226
axios.get(`http://localhost:8080/api/v1/getClassAndReviewByDeptAndNum?department=${theDept}&classNumber=${theCourseNumber}`).then((res) => {


    const id = document.createElement('h2');
    const className =  document.createElement("h2");
    const classDescription =  document.createElement("h5");
    const department =  document.createElement("h6");
    const classNumber =  document.createElement("h6");
    const cumGPA =  document.createElement("h6");
    const cumDif = document.createElement("h6");
    const likes = document.createElement("h6");
    const dislikes = document.createElement("h6");
    const addToPlannerBtn = document.createElement("button");
    addToPlannerBtn.className = "btn btn-info";
    addToPlannerBtn.id = "that-btn";

    console.log(res.data)
    // id.innerText = "Num: " + res.data[0].id;
    className.innerHTML = `<a id = "classNameStyle" href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[0].department}&userReviewCourseNumber=${res.data[0].classNumber}\">` + res.data[0].className + "</a>";
    className.className = "theClassName"

    classDescription.innerHTML = "Description " + res.data[0].classDescription;
    department.innerHTML = "<br>Department " + res.data[0].department;
    classNumber.innerHTML = "Class Number " +res.data[0].classNumber;
    cumGPA.innerHTML = "Cumulative GPA " + res.data[0].cumGPA;
    cumDif.innerHTML = "Cumulative Difficulty " + res.data[0].cumDif;
    likes.innerHTML = "Total Likes " + res.data[0].likes;
    dislikes.innerHTML = "Total Dislikes " + res.data[0].dislikes;
    addToPlannerBtn.innerText = "Save this class ❤️";
    addToPlannerBtn.id = "addClassStyle";

    const title = document.createElement('h1');
    title.className ="title";
    title.style = "font-weight: bold;"
    title.innerText = "Additional Class Info: " + res.data[0].department + "-" + res.data[0].classNumber + " ("  + res.data[0].className + ")";
    theTitRow.append(title);

    const fullClass = document.createElement("div");
    fullClass.id = "getAllClassesContainer";
    fullClass.append(className);
    fullClass.append(classDescription);
    fullClass.append(department);
    fullClass.append(classNumber);
    fullClass.append(cumGPA);
    fullClass.append(cumDif);  
    fullClass.append(likes); 
    fullClass.append(dislikes);
    fullClass.append(addToPlannerBtn);


    // theUserSection.append(fullClass);

    let theReviewSection = document.createElement("section");

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

        theReviewSection.append(userReviewId);
        theReviewSection.append(userReviewEmail);
        theReviewSection.append(userReviewGPA);
        theReviewSection.append(userReviewDifficulty);
        if(res.data[1][i].userReviewLike){
            theReviewSection.append(userReviewLike);
        }else{
            theReviewSection.append(userReviewDislike);
        }
        theReviewSection.append(userReviewFeedback);



        fullClass.append(theReviewSection);
    }
    theUserSection.append(fullClass);

})