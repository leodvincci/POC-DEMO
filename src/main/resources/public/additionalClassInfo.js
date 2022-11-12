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
    const addToPlannerBtn = document.createElement("div");
    let lineBreak = document.createElement("h6");
    lineBreak.innerHTML = "hello";
    lineBreak.style = "color:#ffffff";
    let lineBreakTwo = document.createElement("p");
    lineBreakTwo.innerHTML = "";
    console.log(res.data)
    className.innerHTML = `<a id = "classNameStyle" href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[0].department}&userReviewCourseNumber=${res.data[0].classNumber}\">` + res.data[0].className + "</a>";
    className.className = "theClassName"

    classDescription.innerHTML = "Description: " + res.data[0].classDescription;
    department.innerHTML = "<br>Department: " + res.data[0].department;
    classNumber.innerHTML = "Class Number: " +res.data[0].classNumber;
    cumGPA.innerHTML = "Cumulative GPA: " + res.data[0].cumGPA;
    cumDif.innerHTML = "Cumulative Difficulty: " + res.data[0].cumDif;
    likes.innerHTML = "Total Likes: " + res.data[0].likes;
    dislikes.innerHTML = "Total Dislikes: " + res.data[0].dislikes;
    
    addToPlannerBtn.innerHTML = "<button id=\"addClassStyle\" class=\"btn btn-info\" onclick=\"saveClass()\">Save this class ❤️</button>";
    // addToPlannerBtn.id = "addClassStyle";
    // addToPlannerBtn.className = "btn btn-info";
    // addToPlannerBtn.onclick = saveClass();

    const title = document.createElement('h1');
    title.className ="title";
    title.style = "font-weight: bold;"
    title.innerText = "Additional Class Info: " + res.data[0].department + "-" + res.data[0].classNumber + " ("  + res.data[0].className + ")";
    theTitRow.append(title);

    const fullClass = document.createElement("div");
    fullClass.id = "getAllClassesContainerAdditionalClassInfo";

    fullClass.append(className);
    fullClass.append(classDescription);
    fullClass.append(department);
    fullClass.append(classNumber);
    fullClass.append(cumGPA);
    fullClass.append(cumDif);  
    fullClass.append(likes); 
    fullClass.append(dislikes);
    fullClass.append(lineBreakTwo);
    fullClass.append(addToPlannerBtn);

    
    fullClass.append(lineBreak);


    let theReviewSection = document.createElement("section");
    theReviewSection.id = "reviewsStyles";

    for (let i = 0; i < res.data[1].length; i++) {


        const userReviewId = document.createElement('h5');
        const userReviewEmail =  document.createElement("h5");
        const userReviewGPA =  document.createElement("h6");
        const userReviewDifficulty =  document.createElement("h6");
        const userReviewLike =  document.createElement("h6");
        const userReviewDislike =  document.createElement("h6");
        const userReviewFeedback = document.createElement("p");
        userReviewFeedback.id = "feedbackColor";
        userReviewFeedback.className ="feedBack";
        // userReviewId.innerHTML = "<br>";
        userReviewEmail.innerHTML = res.data[1][i].userReviewEmail;
        userReviewGPA.innerHTML = "GPA:  " + res.data[1][i].userReviewGPA;
        userReviewDifficulty.innerHTML = "Difficulty Rating:  " + res.data[1][i].userReviewDifficulty;
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
        let lineBreak2 = document.createElement("hr");
        lineBreak2.id = "hr-length";
        if(i != res.data[1].length-1){
            theReviewSection.append(lineBreak2);
        }


        fullClass.append(theReviewSection);
    }
    theUserSection.append(fullClass);

})

function saveClass(){
    alert("hello");
}