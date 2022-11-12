let theUserSection = document.querySelector("section");
let theUserTable = document.getElementById("tableBody");


    axios.get('http://localhost:8080/api/v1/getAllClasses').then((res) => {
    for (let i = 0; i < res.data.length; i++) {

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


        className.innerHTML = `<a id = "classNameStyle" href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[i].department}&userReviewCourseNumber=${res.data[i].classNumber}\">` + res.data[i].className + "</a>";
        className.className = "theClassName";

        classDescription.innerHTML = "Description: " + res.data[i].classDescription;
        department.innerHTML = "<br>Department: " + res.data[i].department;
        classNumber.innerHTML = "Course Number: " +res.data[i].classNumber;
        cumGPA.innerHTML = "Average GPA: " + res.data[i].cumGPA;
        likes.innerHTML = "Total Likes: " + res.data[i].likes;
        dislikes.innerHTML = "Total Dislikes: " + res.data[i].dislikes;
        addToPlannerBtn.innerText = "Save this class ❤️";
        addToPlannerBtn.id = "addClassStyle";


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


        theUserSection.append(fullClass);



    }  
    
})