let theUserSection = document.querySelector("section");
let theUserTable = document.getElementById("tableBody");
const form = document.getElementById('formElem');

form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)
    const payload = new URLSearchParams(prepayload);
    let department = payload.get("department");
    let classNumber = payload.get("classNumber");
    fetchAndRenderDetails(department, classNumber);
    });


function fetchAndRenderDetails(department, classNumber){
    alert("sent in");
    let data = {
        department:department,
        classNumber: classNumber
    }

        fetch('http://localhost:8080/api/v1/getClassByNameAndNumber', {
            method: "GET",
            headers: {
                "Content-Type":'application/json'
            },
            body: JSON.stringify(data),

        }).then(r=>{
            alert("Retrieved class: " + department + " " + classNumber);
            alert(department+classNumber);
            for (let i = 0; i < length(r.data); i++) {
                    const id = document.createElement('h2');
                    const className =  document.createElement("h3");
                    const classDescription =  document.createElement("h3");
                    const department =  document.createElement("h4");
                    const classNumber =  document.createElement("h5");
                    const cumGPA =  document.createElement("h5");
                    const cumDif = document.createElement("h5");
                    const likes = document.createElement("h5");
                    const dislikes = document.createElement("h5");


                    id.innerText = "Num: " + r.data[i].id;
                    className.innerHTML = "Class Name <a href=\"AdditionalClassInfo.html\">" + r.data[i].className + "</a>";
                    classDescription.innerHTML = "Description " + r.data[i].classDescription;
                    department.innerHTML = "Department " + r.data[i].department;
                    classNumber.innerHTML = "Class Number " +r.data[i].classNumber;
                    cumGPA.innerHTML = "Cumulative GPA " + r.data[i].cumGPA;
                    cumDif.innerHTML = "Cumulative Difference " + r.data[i].cumDif;
                    likes.innerHTML = "Likes " + r.data[i].likes;
                    dislikes.innerHTML = "Dislikes " + r.data[i].dislikes;

                    theUserSection.append(id);
                    theUserSection.append(className);
                    theUserSection.append(classDescription);
                    theUserSection.append(department);
                    theUserSection.append(classNumber);
                    theUserSection.append(cumGPA);
                    theUserSection.append(cumDif);
                    theUserSection.append(likes);
                    theUserSection.append(dislikes);


                }
})

}