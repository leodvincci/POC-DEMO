const form = document.getElementById('formElem');

form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)

    const payload = new URLSearchParams(prepayload);

    let eml = payload.get("email");
    let clnm = payload.get("className");
    let dpt = payload.get("dptName")

    console.log(eml)
    console.log(clnm)
    console.log(dpt)
    let data = {
        email:eml,
        className: clnm
    }

    fetch(`http://54.146.226.153:8080/api/v1/deleteReviewByEmailCourseDept?userEmail=${eml}&courseNumber=${clnm}&department=${dpt.toUpperCase()}`, {
        method: "DELETE",
        headers: {
            "Content-Type":'application/json'
        },
        body: JSON.stringify(data),

    }).then(r=>(alert("Review for " + className + " was deleted")))

})