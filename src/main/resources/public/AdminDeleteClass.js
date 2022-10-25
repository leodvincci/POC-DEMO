const form = document.getElementById('formElem');

form.addEventListener('submit',function (e){
    e.preventDefault();
    const prepayload = new FormData(form)

    const payload = new URLSearchParams(prepayload);

    let dpt = payload.get("department");
    let cnm = payload.get("classNumber");

    console.log(dpt)
    console.log(cnm)

    let data = {
        department:dpt,
        classNumber:cnm
    }

    fetch(`http://54.146.226.153:8080/api/v1/searchandremoveclass?department=${dpt}&classNumber=${cnm}`, {
        method: 'DELETE',
        headers: {
            "Content-Type":'application/json'
        },
        body: JSON.stringify(data),

    }).then(r=>(alert(dpt + " " + cnm + " Was Deleted")))

})