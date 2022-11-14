const modal = document.querySelector(".modal");
function triggerPopUp(){
    alert("in1");
    toggleModal();
}
function toggleModal() {
    alert("in2");
    modal.classList.toggle("show-modal");
}

//----@ Leo: POPUP IS CODE ABOVE..it is first being called by line 43 because i want to customize the alert--------

const myKeysValues = window.location.search;

const urlParams = new URLSearchParams(myKeysValues);

// const theDept = urlParams.get("userReviewDepartment");
// const theCourseNumber = urlParams.get("userReviewCourseNumber");


let theUserSection = document.querySelector("section");
let theTitRow = document.querySelector("#titleRow")

const form = document.getElementById('formElem');

function containsNumbers(str) {
    return /\d/.test(str);
  }
  function containsOnlyNumbers(str) {
    return /^\d+$/.test(str);
  }


form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)

    const payload = new URLSearchParams(prepayload);
    let dpt = payload.get("department");
    let cnm = payload.get("classNumber");
    if((dpt.length == 0) || (cnm.length == 0)){
        alert("Please fill in all fields.");
        triggerPopUp();
    }else if(!((dpt.length >= 1) && (dpt.length <= 4))){
        alert("Invalid Department!");
    }else if(containsNumbers(dpt)){
        alert("Invalid Department!");
    }else if(cnm.length > 5){
        alert("Invalid Course Number!");
    }
    else if(!containsOnlyNumbers(cnm)){
        alert("Invalid Course Number!");
    }else{
        console.log(dpt)
    console.log(cnm)

    let data = {
        department:dpt,
        classNumber:cnm
    }

    axios.get(`http://localhost:8080/api/v1/getClassAndReviewByDeptAndNum?department=${dpt}&classNumber=${cnm}`).then((res) => {


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
        addToPlannerBtn.id = "addClassStyle";

        console.log(res.data , res.data[0].length,res.data[1].length)
        if(res.data[0].length == 0 && res.data[1].length == 0 ){

            alert("Sorry..We Do Not Have This Course On Our Site.")
            alert("Please Add It So That Others May Find It.")

            window.location.href='AddClass.html'

        }else {


            // id.innerText = "Num: " + res.data[0].id;
            className.innerHTML = `<a id = "classNameStyle" href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[0].department}&userReviewCourseNumber=${res.data[0].classNumber}\">` + res.data[0].className + "</a>";
            className.className = "theClassName"

            classDescription.innerHTML = "Description: " + res.data[0].classDescription;
            department.innerHTML = "<br>Department: " + res.data[0].department;
            classNumber.innerHTML = "Class Number: " + res.data[0].classNumber;
            cumGPA.innerHTML = "Cumulative GPA " + res.data[0].cumGPA;
            cumDif.innerHTML = "Cumulative Difficulty " + res.data[0].cumDif;
            likes.innerHTML = "Total Likes " + res.data[0].likes;
            dislikes.innerHTML = "Total Dislikes " + res.data[0].dislikes;
            addToPlannerBtn.innerText = "Save this class ❤️";
            addToPlannerBtn.id = "addClassStyle";
            const title = document.createElement('h1');
            title.className = "title";
            title.innerText = "Additional Class Info: " + res.data[0].classNumber + " " + res.data[0].className;
            // theTitRow.append(title);
            addToPlannerBtn.onclick = saveClass;


            function saveClass(){
                console.log("Clicked")
                alert(`${res.data[0].department} ${res.data[0].classNumber} Class Has Been Saved!`)

                axios.post(`http://localhost:8080/api/v1/saveStudentCourse?department=${res.data[0].department}&classNumber=${res.data[0].classNumber}`).then((res) => {

                })
                // axios.post('http://localhost:8080/api/v1/saveStudentCourse', {
                //     department: theDept,
                //     classNumber: theCourseNumber
                //   })
                //   .then(function (response) {
                //     console.log(response);
                //   })
                //   .catch(function (error) {
                //     console.log(error);
                //   });

            }

        theUserSection.append(id);
        theUserSection.append(className);
        theUserSection.append(classDescription);
        theUserSection.append(department);
        theUserSection.append(classNumber);
        theUserSection.append(cumGPA);
        theUserSection.append(cumDif);  
        theUserSection.append(likes); 
        theUserSection.append(dislikes);
        theUserSection.append(addToPlannerBtn);

            //commenting this out for now
            // for (let i = 0; i < res.data[1].length; i++) {


            //     const userReviewId = document.createElement('h1');
            //     const userReviewEmail = document.createElement("h2");
            //     const userReviewGPA = document.createElement("h4");
            //     const userReviewDifficulty = document.createElement("h4");
            //     const userReviewLike = document.createElement("h4");
            //     const userReviewDislike = document.createElement("h4");
            //     const userReviewFeedback = document.createElement("h3");
            //     userReviewFeedback.className = "feedBack"


            //     // userReviewId.innerText = "Review #: " + res.data[1][i].userReviewID;
            //     userReviewId.innerHTML = "<br>";
            //     userReviewEmail.innerHTML = res.data[1][i].userReviewEmail;
            //     userReviewGPA.innerHTML = "GPA:  " + res.data[1][i].userReviewGPA;
            //     userReviewDifficulty.innerHTML = "Difficulty Rating:  " + res.data[1][i].userReviewDifficulty;
            //     // classNumber.innerHTML = "Class Number " +res.data[i].classNumber;
            //     // cumGPA.innerHTML = "Cumulitive GPA " + res.data[i].cumGPA;
            //     // cumDif.innerHTML = "Cumulitive Difference " + res.data[i].cumDif;
            //     userReviewLike.innerHTML = "Student Liked Class 👍";
            //     userReviewDislike.innerHTML = "Student Disliked Class 👎 ";
            //     userReviewFeedback.innerHTML = "Student Feedback: " + res.data[1][i].userReviewFeedback;

            //     theUserSection.append(userReviewId);
            //     theUserSection.append(userReviewEmail);
            //     theUserSection.append(userReviewGPA);
            //     theUserSection.append(userReviewDifficulty);
            //     if (res.data[1][i].userReviewLike) {
            //         theUserSection.append(userReviewLike);
            //     } else {
            //         theUserSection.append(userReviewDislike);
            //     }
            //     theUserSection.append(userReviewFeedback);


            // }
        }
    })
    }
})

