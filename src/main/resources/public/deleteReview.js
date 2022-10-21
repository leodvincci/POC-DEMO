const form = document.getElementById('formElem');

form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)

    const payload = new URLSearchParams(prepayload);

    let eml = payload.get("email");
    let clnm = payload.get("className");

    console.log(eml)
    console.log(clnm)
    let data = {
        email:eml,
        className: clnm
    }

    fetch('http://3.88.60.54:8080/api/v1/deleteReview', {
        method: "DELETE",
        headers: {
            "Content-Type":'application/json'
        },
        body: JSON.stringify(data),

    }).then(r=>(alert("Review for " + className + " was deleted")))

})