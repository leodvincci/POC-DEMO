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


<<<<<<< HEAD
        id.innerText = "Num: " + res.data[i].id;

    //    className.innerHTML = "Class Name <button id=\"className\" href=\"AdditionalClassInfo.html\">" + res.data[i].className + "</button>";
        className.innerHTML = "Class Name <button id=\""+ 
                                res.data[i].department+
                                "-"+
                                res.data[i].classNumber+
                                 "\" onclick=\"renderAdditionalDetails()\">"+
//                                "\">"+
                                res.data[i].className+
                                "</button>";

=======
        // id.innerText = "Num: " + res.data[i].id;
        className.innerHTML = `<a href=\"AdditionalClassInfo.html?userReviewDepartment=${res.data[i].department}&userReviewCourseNumber=${res.data[i].classNumber}\">` + res.data[i].className + "</a>";
        className.className = "theClassName"
>>>>>>> 377b0ea9ae5107a5ef40cd724c9f600423e6f903
        classDescription.innerHTML = "Description " + res.data[i].classDescription;
        department.innerHTML = "Department " + res.data[i].department;
        classNumber.innerHTML = "Class Number " +res.data[i].classNumber;
        cumGPA.innerHTML = "Cumulative GPA " + res.data[i].cumGPA;
        cumDif.innerHTML = "Cumulative Difference " + res.data[i].cumDif;
        likes.innerHTML = "Likes " + res.data[i].likes; 
        dislikes.innerHTML = "Dislikes " + res.data[i].dislikes;

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


function renderAdditionalDetails(){
    alert("hello");
}
//var buttons = document.getElementsByTagName("button");
//var buttonsCount = buttons.length;
//alert(buttonsCount);
// for (var i = 0; i <= buttonsCount; i += 1) {
//     alert("hello");
//     // buttons[i].onclick = function(e) {
//     //     alert("hello");
//     //     // alert(this.id);
//     // };
// };​

// $("button").click(function() {
//     alert("hello!");
//     //alert(this.id); // or alert($(this).attr('id'));
// });