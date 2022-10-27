let theUserSection = document.querySelector("section");
let theUserTable = document.getElementById("tableBody");


    axios.get('http://localhost:8080/api/v1/getAllClasses').then((res) => {
    for (let i = 0; i < res.data.length; i++) {

        const id = document.createElement('h2');
        const className =  document.createElement("h3");
        const classDescription =  document.createElement("h3");
        const department =  document.createElement("h4");
        const classNumber =  document.createElement("h5");
        const cumGPA =  document.createElement("h5");
        const cumDif = document.createElement("h5");  
        const likes = document.createElement("h5");  
        const dislikes = document.createElement("h5");

        const addToPlannerBtn = document.createElement("button");
        addToPlannerBtn.className = "btn btn-info";
        addToPlannerBtn.id = "that-btn";


        // id.innerText = "Num: " + res.data[i].id;
        className.innerHTML = `<a href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[i].department}&userReviewCourseNumber=${res.data[i].classNumber}\">` + res.data[i].className + "</a>";
        className.className = "theClassName"
        classDescription.innerHTML = "Description " + res.data[i].classDescription;
        department.innerHTML = "Department " + res.data[i].department;
        classNumber.innerHTML = "Class Number " +res.data[i].classNumber;
        cumGPA.innerHTML = "Cumulitive GPA " + res.data[i].cumGPA; 
        cumDif.innerHTML = "Cumulitive Difference " + res.data[i].cumDif; 
        likes.innerHTML = "Likes " + res.data[i].likes; 
        dislikes.innerHTML = "Dislikes " + res.data[i].dislikes;
        addToPlannerBtn.innerText = "Add Course To Planner"


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


    }  
    
})