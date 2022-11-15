
const form = document.getElementById('formElem');
function containsNumbers(str) {
    return /\d/.test(str);
}
function containsOnlyNumbers(str) {
    return /^\d+$/.test(str);
}
form.addEventListener('submit', function (e) {
    e.preventDefault();
    // alert("hello!");
    const prepayload = new FormData(form)

    const payload = new URLSearchParams(prepayload);

    let classDescription = payload.get("classDescription");
    let className = payload.get("className");
    let dpt = payload.get("department").toUpperCase();
    let cnm = payload.get("classNumber")
    if(containsNumbers(className)){
        alert("Your class name contains numbers. Please stick to Roman Numerals!");
    }
    else if (!((dpt.length >= 1) && (dpt.length <= 4))) {
        alert("Invalid Department!");
    } else if (containsNumbers(dpt)) {
        alert("Invalid Department!");
    } else if (cnm.length > 5) {
        alert("Invalid Course Number!");
    }
    else if (!containsOnlyNumbers(cnm)) {
        alert("Invalid Course Number!");
    } else if ((dpt.length == 0) || (cnm.length == 0) || (className.length == 0)|| (classDescription.length == 0)) {
        alert("Please fill in all fields.");
    } else {
        let data = {
            classDescription: classDescription,
            className: className,
            department: dpt.toUpperCase(),
            classNumber: cnm
        }

        fetch('http://54.146.226.153:8080/api/v1/addClass', {
            method: "POST",
            headers: {
                "Content-Type": 'application/json'
            },
            body: JSON.stringify(data),

        }).then(r => (alert("Added New Class: " + className)))
    }



})